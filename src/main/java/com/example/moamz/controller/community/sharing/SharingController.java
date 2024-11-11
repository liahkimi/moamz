package com.example.moamz.controller.community.sharing;

import com.example.moamz.domain.dto.community.sharing.SharingDetailDTO;
import com.example.moamz.domain.dto.community.sharing.SharingListDTO;
import com.example.moamz.domain.dto.community.sharing.SharingModifyDTO;
import com.example.moamz.domain.dto.community.sharing.SharingWriteDTO;
import com.example.moamz.service.community.sharing.SharingBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/sharing")
public class SharingController {
    private final SharingBoardService sharingBoardService;

    //
    // 게시글 등록하기 <GET>
    //
    @GetMapping("/regist")
    public String registSharing(@SessionAttribute(value="fgUserCode", required = false) Long userCode) {
        // 세션에 userCode가 있는 경우 게시글 등록 페이지로 이동
        // 없는 경우 로그인 페이지로 이동
        return userCode==null ? "redirect:/normal/regular/userLogin" : "/community/sharing/sharingWrite";
    }

    //
    // 게시글 등록하기 <POST>
    //
    @PostMapping("/regist")
    public String registSharing(@SessionAttribute(value="fgUserCode", required = false) Long userCode,
                                @RequestParam("postFile") MultipartFile file,
                                SharingWriteDTO sharingWriteDTO) throws IOException {

        // 세션의 userCode값을 DTO에 넣어주기
        sharingWriteDTO.setUserCode(userCode);

        // 나눔글, 파일 삽입 메서드 호출
        sharingBoardService.registerSharing(sharingWriteDTO, file);

        // 게시글 상세 페이지로 리다이렉트
        return "redirect:/sharing/detail/" + sharingWriteDTO.getPostId();
    }

    //
    // 게시글 수정 <GET>
    //
    @GetMapping("/update")
    public String updateSharing(@SessionAttribute(value="fgUserCode") Long userCode,
                                @RequestParam("postId") Long postId,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        // 세션의 userCode가 null이면 로그인 화면으로 리다이렉트
        if(userCode == null) {
            return "redirect:/normal/regular/userLogin";
        }

        // 수정할 게시글의 상세dto 가져오기
        SharingDetailDTO sharingDetailDTO = sharingBoardService.findSharingDetail(postId, userCode);

        if(sharingDetailDTO.getWriterCode().equals(userCode)) {
            // 게시글의 작성자CODE와 세션의 userCode가 같은 경우에만 글 수정 가능
            model.addAttribute("sharingDetailDTO", sharingDetailDTO);
            return "/community/sharing/sharingModify";
        } else {
            // 세션의 userCode와 DTO의 userCode값이 다르면 상세글에 접근할 수 없다.
            // alert 메시지를 추가.. 실제 alert는 리다이렉트된 뷰에서 뜨게 된다.
            redirectAttributes.addFlashAttribute("Message", "본인이 작성한 게시글만 수정할 수 있습니다!");
            return "redirect:/sharing/detail/" + postId;
        }
    }

    //
    // 게시글 수정 <POST>
    //
    @PostMapping("/update")
    public String updateSharing(SharingModifyDTO sharingModifyDTO,
                                @RequestParam("postFile") MultipartFile file,
                                @RequestParam("fileChanged") boolean fileChanged,
                                RedirectAttributes redirectAttributes) {
        try {
            sharingBoardService.updateSharing(sharingModifyDTO, file, fileChanged);
            log.info("💛💛💛💛💛 컨트롤러에서 fileChanged : {}", fileChanged);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Long postId = sharingModifyDTO.getPostId();
        return "redirect:/sharing/detail/" + postId;
    }

    //
    // 게시글 삭제 <GET>
    //
    @GetMapping("delete")
    public String deleteSharing(@SessionAttribute(value="fgUserCode", required = false) Long userCode,
                                @RequestParam("postId") Long postId,
                                RedirectAttributes redirectAttributes) {
        // 게시글 삭제 메서드
        Boolean isDelete =  sharingBoardService.removeSharing(userCode, postId);

        if(isDelete) {
            redirectAttributes.addFlashAttribute("Message", "삭제되었습니다.");
            return "redirect:/sharing/list";
        } else {
            redirectAttributes.addFlashAttribute("Message", "본인의 게시글만 삭제할 수 있습니다.");
            return "redirect:/sharing/detail/" + postId;
        }
    }

    //
    // 게시글 목록 <GET>
    //
    @GetMapping("/list")
    public String sharingList(Model model) {

        // 나눔 상태별 게시글 목록 가져오기
        List<SharingListDTO> availableList = sharingBoardService.findAvailableList();
        List<SharingListDTO> reservedList = sharingBoardService.findReservedList();
        List<SharingListDTO> completedList = sharingBoardService.findCompletedList();

        // 모델에 추가
        model.addAttribute("availableList", availableList);
        model.addAttribute("reservedList", reservedList);
        model.addAttribute("completedList", completedList);

        return "/community/sharing/sharingList";
    }

    //
    // 게시글 상세페이지
    //
    @GetMapping("/detail/{postId}")
    public String sharingDetail(@PathVariable("postId") Long postId,
                                @SessionAttribute(value="fgUserCode", required = false) Long userCode,
                                Model model) {
        // 세션에 userCode가 null이면 로그인 페이지로 리다이렉트
        if(userCode == null) {
            return "redirect:/normal/regular/userLogin";
        }

        // 상세보기 메서드 호출
        SharingDetailDTO sharingDetailDTO = sharingBoardService.findSharingDetail(postId, userCode);

        if(userCode.equals(sharingDetailDTO.getWriterCode())) {
            // 내 게시글이면 isMyPost = true
            sharingDetailDTO.setMyPost(true);
        } else {
            // 내 게시글이 아니면 isMyPost = false
            sharingDetailDTO.setMyPost(false);
        }

        model.addAttribute("sharingDetailDTO", sharingDetailDTO);
        return "/community/sharing/sharingDetail";
    }

}
