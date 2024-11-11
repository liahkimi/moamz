package com.example.moamz.controller.community.free;

import com.example.moamz.domain.dto.community.free.FreeDetailDTO;
import com.example.moamz.domain.dto.community.free.FreeListDTO;
import com.example.moamz.domain.dto.community.free.FreeModifyDTO;
import com.example.moamz.domain.dto.community.free.FreeWriteDTO;
import com.example.moamz.service.community.free.FreeBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/free")
public class freeController {
    private final FreeBoardService freeBoardService;

    //
    // 자유게시판 목록 <GET>
    //
    @GetMapping("/list")
    public String freeList(Model model) {
        List<FreeListDTO> freeListDTO = freeBoardService.findFreeList();
        model.addAttribute("freeListDTO", freeListDTO);
        return "/community/free/freeList";
    }

    //
    // 자유게시판 상세보기 <GET>
    //
    @GetMapping("/detail/{postId}")
    public String freeDetail(@PathVariable("postId") Long postId,
                             @SessionAttribute(value="fgUserCode", required = false) Long userCode,
                             Model model) {
        // 세션이 null이면 로그인 화면으로 리다이렉트
        if(userCode == null) {
            return "redirect:/normal/regular/userLogin";
        }

        // 게시글 상세보기 메서드 호출
        FreeDetailDTO freeDetailDTO = freeBoardService.findFreeDetail(postId, userCode);

        if(userCode.equals(freeDetailDTO.getWriterCode())) {
            // 내가 작성한 게시글이면 isMyPost = true
            freeDetailDTO.setMyPost(true);
        } else {
            // 내가 작상힌 게시글이 아니면 isMyPost = false
            freeDetailDTO.setMyPost(false);
        }

        log.info("🤯🤯🤯freeDetailDTO : {}", freeDetailDTO);
        // 모델에 담아서 뷰로 전달
        model.addAttribute("freeDetailDTO", freeDetailDTO);
        return "/community/free/freeDetail";
    }


    //
    // 자유게시판 글 작성 <GET>
    //
    @GetMapping("/regist")
    public String registFree(@SessionAttribute(value="fgUserCode", required = false) Long userCode) {
        // 세션이 null이면 로그인 페이지, null이 아니면 글 작성 페이지 열기
        return userCode == null ? "redirect:/normal/regular/userLogin" : "/community/free/freeWrite";
    }

    //
    // 자유게시판 글 작성 <POST>
    //
    @PostMapping("/regist")
    public String registFree(@SessionAttribute(value="fgUserCode", required = false) Long userCode,
                             @RequestParam(value="postFile", required = false) MultipartFile postFile,
                             FreeWriteDTO freeWriteDTO) {
        // 세션의 userCode값을 DTO에 넣기
        freeWriteDTO.setUserCode(userCode);

        // 자유게시판 글 삽입 메서드 호출
        freeBoardService.registFree(freeWriteDTO);

        // 글 상세 페이지로 리다이렉트
        return "redirect:/free/detail/" + freeWriteDTO.getPostId();
    }


    //
    // 자유게시판 글 수정 <GET>
    //
    @GetMapping("/update")
    public String updateFree(@SessionAttribute(value = "fgUserCode", required = false) Long userCode,
                             @RequestParam(value = "postId") Long postId,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        // 세션 userCode가 null이면 로그인 페이지로 이동
        if(userCode == null) {
            return "redirect:/normal/regular/userLogin";
        }

        // 수정할 게시글의 상세DTO 가져오긔
        FreeDetailDTO freeDetailDTO = freeBoardService.findFreeDetail(postId, userCode);

        if(userCode.equals(freeDetailDTO.getWriterCode())) {
            // 세션의 userCode와 게시글 작성자 userCode가 같을 때만 글 수정이 가능하다.
            model.addAttribute("freeDetailDTO", freeDetailDTO);
            return "/community/free/freeModify";
        } else {
            // 세션의 userCode와 게시글 작성자 userCode가 다르면 게시글 수정페이지에 접근할 수 없다.
            redirectAttributes.addFlashAttribute("Message", "본인이 작성한 게시글만 수정할 수 있습니다!");
            return "redirect:/free/detail/" + postId;
        }
    }

    //
    // 자유게시판 글 수정 <POST>
    //
    @PostMapping("/update")
    public String updateFree(FreeModifyDTO freeModifyDTO,
                             @RequestParam("postId") Long postId) {
        // 자유게시판 글 수정 메서드 호출
        freeBoardService.updateFree(freeModifyDTO);

        return "redirect:/free/detail/" + postId;
    }

    //
    // 자유게시판 글 삭제 <GET>
    //
    @GetMapping("/delete")
    public String deleteFree(@SessionAttribute(value = "fgUserCode", required = false) Long userCode,
                             @RequestParam("postId") Long postId,
                             RedirectAttributes redirectAttributes) {

        // 게시글 삭제 메서드 호출 결과를 isDelete에 담음
        Boolean isDelete = freeBoardService.removeFree(userCode, postId);

        if(isDelete) {
            // 삭제 성공하면 자유게시판 목록으로 리다이렉트
            redirectAttributes.addFlashAttribute("Message", "삭제되었습니다.");
            return "redirect:/free/list";
        } else {
            // 삭제 실패하면 해당 게시글 상세보기로 리다이렉트
            redirectAttributes.addFlashAttribute("Message", "본인의 게시글만 삭제할 수 있습니다.");
            return "redirect:/free/detail/" + postId;
        }


    }


}
