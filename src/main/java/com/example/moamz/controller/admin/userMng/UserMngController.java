package com.example.moamz.controller.admin.userMng;


import com.example.moamz.domain.dto.admin.userMng.AdminSearchDTO;
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

    // 검색 기능 추가
    @GetMapping("/search")
    public String searchUserById(
            @RequestParam("fgUserId") String fgUserId,
            @RequestParam(value = "page", defaultValue = "1") int page, // 기본값 설정
            @RequestParam(value = "amount", defaultValue = "10000000") int amount, // 임의로 검색할때 페이지네이션 1로 나오게 하기 위함
            Model model) {

        // Criteria 객체를 생성하고 기본값을 설정
        Criteria criteria = new Criteria();
        criteria.setPage(page);
        criteria.setAmount(amount);

        // 1. 사용자 유형 확인
        String userType = userMngService.searchUserTypeByUserId(fgUserId);

        // 2. 일반 회원 처리
        if ("일반회원".equals(userType)) {
            List<UserMngListDTO> userMngListDTO = userMngService.findNormalUserByUserId(fgUserId , criteria);
            int userTotal = userMngService.findUserMngTotal(); // 일반 회원 총 인원 수
            Page userPage = new Page(criteria, userTotal);
            model.addAttribute("userPage", userPage);
            model.addAttribute("userMngListDTO", userMngListDTO);

            return "admin/adminUserManagement";

            // 3. 판매자 회원 처리
        } else if ("판매자".equals(userType)) {
            List<SellerMngListDTO> sellerMngListDTO = userMngService.findSellerByUserId(fgUserId, criteria);
            int sellerTotal = userMngService.findSellerMngTotal(); // 판매자 총 인원 수
            Page sellerPage = new Page(criteria, sellerTotal);
            model.addAttribute("sellerPage", sellerPage);
            model.addAttribute("sellerMngListDTO", sellerMngListDTO);

            return "admin/adminSellerManagement";

            // 4. 사용자 유형이 없거나 잘못된 경우
        } else {
            model.addAttribute("errorMessage", "해당 ID를 가진 사용자가 존재하지 않습니다.");
            return "admin/adminSearchError";
        }
    }




}
