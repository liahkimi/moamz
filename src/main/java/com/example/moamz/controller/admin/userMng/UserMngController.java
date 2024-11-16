package com.example.moamz.controller.admin.userMng;


import com.example.moamz.domain.dto.admin.userMng.SellerMngListDTO;
import com.example.moamz.domain.dto.admin.userMng.UserMngListDTO;
import com.example.moamz.service.admin.dashboard.DashBoardService;
import com.example.moamz.service.admin.userMng.UserMngService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("/admin/userMng")
@RequiredArgsConstructor
@Slf4j
public class UserMngController {
    private final UserMngService userMngService;

    // 일반 or 판매자 회원관리 목록 보여주기
    @GetMapping("/list")
    public String userMngList(Model model, @SessionAttribute(value="fgUserCode", required = false) Long fgUserCode){
        List<UserMngListDTO> userMngListDTO = userMngService.findUserMngList();
        model.addAttribute("userMngListDTO", userMngListDTO);
        log.info("❤️❤️❤️❤️❤️❤️❤️ userMngListDTO {}", userMngListDTO);



        List<SellerMngListDTO> sellerMngListDTO = userMngService.findSellerMngList();
        model.addAttribute("sellerMngListDTO",sellerMngListDTO);

        return "admin/adminUserManagement";
    }

}
