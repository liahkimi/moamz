package com.example.moamz.controller.community.free;

import com.example.moamz.domain.dto.community.free.FreeListDTO;
import com.example.moamz.domain.dto.community.free.FreeWriteDTO;
import com.example.moamz.service.community.free.FreeBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
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
                             FreeWriteDTO freeWriteDTO) {
        // 세션의 userCode값을 DTO에 넣기
        freeWriteDTO.setUserCode(userCode);

        // 자유게시판 글 삽입 메서드 호출
        freeBoardService.registFree(freeWriteDTO);

        // 글 상세 페이지로 리다이렉트
        return "redirect:/free/detail/" + freeWriteDTO.getPostId();
    }

}
