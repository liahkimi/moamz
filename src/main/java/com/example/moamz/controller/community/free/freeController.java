package com.example.moamz.controller.community.free;

import com.example.moamz.domain.dto.community.free.FreeListDTO;
import com.example.moamz.service.community.free.FreeBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

}
