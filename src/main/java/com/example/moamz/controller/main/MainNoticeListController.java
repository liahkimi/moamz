package com.example.moamz.controller.main;

import com.example.moamz.domain.dto.main.MainNoticeListDTO;
import com.example.moamz.service.main.MainNoticeListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainNoticeListController {
    private final MainNoticeListService mainNoticeListService;

    @GetMapping("/noticeList")
    public String noticeList(Model model) {
        List<MainNoticeListDTO> noticeList = mainNoticeListService.getMainNoticeList();
        model.addAttribute("noticeList", noticeList);

        return "main/main/noticeList";
    }
}
