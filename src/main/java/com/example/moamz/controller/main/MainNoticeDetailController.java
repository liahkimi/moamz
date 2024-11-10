package com.example.moamz.controller.main;

import com.example.moamz.domain.dto.main.MainNoticeDetailDTO;
import com.example.moamz.domain.dto.main.MainNoticeListDTO;
import com.example.moamz.service.main.MainNoticeDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainNoticeDetailController {
    private final MainNoticeDetailService mainNoticeDetailService;

    @GetMapping("/noticeDetail/{fgPostId}")
    public String noticeDetail(Model model, @PathVariable("fgPostId") Long fgPostId) {
        MainNoticeDetailDTO mainNoticeDetailDTO = mainNoticeDetailService.getNoticeDetail(fgPostId);
//        List<MainNoticeDetailDTO> noticeDetail = mainNoticeDetailService.getNoticeDetail(fgPostId);
        model.addAttribute("noticeDetail", mainNoticeDetailDTO);

        System.out.println("noticeDetail = " + mainNoticeDetailDTO);

//        return "main/main/noticeDetail/{fgPostId}";
        return "main/main/noticeDetail";
    }



}



