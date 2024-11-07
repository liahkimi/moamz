package com.example.moamz.controller.admin.eco;

import com.example.moamz.service.admin.eco.AdminEcoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("admin/eco")
@RequiredArgsConstructor
@Slf4j
public class AdminEcoController {
    private final AdminEcoService adminEcoService;

    //진행중인 에코프로젝트 목록 보여주기
    @GetMapping("/ingList")
    public String ingEcoList(){
            return "admin/adminEcoList";
        }

    //공지사항 글 작성페이지 보여주기
    @GetMapping("/write")
    public String ecoWrite(@SessionAttribute(value="fgUserCode", required = false) Long fgUserCode) {

        return fgUserCode == null ? "redirect:/admin/login" : "/admin/adminEcoWrite";

    }



    }

