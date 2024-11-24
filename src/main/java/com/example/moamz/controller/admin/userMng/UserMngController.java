package com.example.moamz.controller.admin.userMng;


import com.example.moamz.domain.dto.admin.userMng.SellerMngListDTO;
import com.example.moamz.domain.dto.admin.userMng.UserMngListDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.page.Page;
import com.example.moamz.service.admin.dashboard.DashBoardService;
import com.example.moamz.service.admin.userMng.UserMngService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("/admin/userMng")
@RequiredArgsConstructor
@Slf4j
public class UserMngController {
    private final UserMngService userMngService;

    // 일반 회원관리 목록 보여주기
    @GetMapping("/userList")
    public String userMngList(Model model, Criteria criteria, @SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode) {

        List<UserMngListDTO> userMngListDTO = userMngService.findAllUserMngPage(criteria);
        int userTotal = userMngService.findUserMngTotal(); //일반회원 총 인원 수
        Page userPage = new Page(criteria, userTotal);
        model.addAttribute("userPage", userPage);
        model.addAttribute("userMngListDTO", userMngListDTO);

        return "admin/adminUserManagement";
    }

    // 판매자 회원관리 목록 보여주기
    @GetMapping("/sellerList")
    public String sellerMngList(Model model, Criteria criteria, @SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode) {


        List<SellerMngListDTO> sellerMngListDTO = userMngService.findAllSellerMngPage(criteria);
        int sellerTotal = userMngService.findSellerMngTotal(); //판매자 총 인원수
        Page sellerPage = new Page(criteria, sellerTotal);
        model.addAttribute("sellerPage", sellerPage);
        model.addAttribute("sellerMngListDTO", sellerMngListDTO);

        return "admin/adminSellerManagement";
    }




}
