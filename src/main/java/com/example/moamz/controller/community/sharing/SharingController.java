package com.example.moamz.controller.community.sharing;

import com.example.moamz.domain.dto.community.sharing.SharingDetailDTO;
import com.example.moamz.domain.dto.community.sharing.SharingWriteDTO;
import com.example.moamz.service.community.sharing.SharingBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/sharing")
public class SharingController {
    private final SharingBoardService sharingBoardService;

    // 게시글 등록하기
    @GetMapping("/regist")
    public String registSharing(@SessionAttribute(value="fgUserCode") Long userCode) {
        // 세션에 userCode가 있는 경우 게시글 등록 페이지로 이동
        // 없는 경우 로그인 페이지로 이동
        return userCode==null ? "/normal/regular/userLogin" : "/community/sharing/sharingWrite";
    }

    // 게시글 등록하기
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
    // 게시글 수정
    //
    @GetMapping("/update")
    public String updateSharing(@SessionAttribute(value="fgUserCode") Long userCode) {
        // 세션에 userCode가 있는 경우 게시글 수정 페이지로 이동
        // 없는 경우 로그인 페이지로 이동
        return userCode==null ? "/normal/regular/userLogin" : "/community/sharing/sharingModify";
    }

    //
    // 게시글 목록
    //
    @GetMapping("/list")
    public String sharingList() {
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
        SharingDetailDTO sharingDetailDTO = sharingBoardService.findSharingDetail(postId);

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
