package com.example.moamz.controller.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.SalesDetailDTO;
import com.example.moamz.domain.dto.mypage.seller.SalesListDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerProfileDTO;
import com.example.moamz.service.mypage.seller.SellerMyService;
import com.example.moamz.service.mypage.seller.SellerSalesService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/seller/sales")
public class SellerSalesController {
    private final SellerSalesService sellerSalesService;
    private final SellerMyService sellerMyService;


    // 판매한 상품 내역 페이지
    @GetMapping("/list")
    public String salesList(Model model) {
        // ⭐로그인 유저의 businessId 필요
        Long businessId = 1L;
        Long userCode = 1L;

        // 판매자 프로필 가져오기
        SellerProfileDTO sellerProfileDTO = sellerMyService.getSellerProfile(businessId, userCode);

        // 상품 준비 상태별 판매 목록 가져오기
        List<SalesListDTO> readyList = sellerSalesService.findCheckOrder(businessId);
        List<SalesListDTO> pickupList = sellerSalesService.findReadyToPickUp(businessId);
        List<SalesListDTO> completedList = sellerSalesService.findCompletePickup(businessId);

        // 모델에 추가
        model.addAttribute("sellerProfileDTO", sellerProfileDTO);
        model.addAttribute("readyList", readyList);
        model.addAttribute("pickupList", pickupList);
        model.addAttribute("completedList", completedList);
        //log.info("💜💜💜salesListDTO : {}", salesListDTO);

        return "mypage/seller/sellerSalesHistory";
    }


    // 주문확인 -> 픽업대기 변경 메서드
    @PostMapping("/updateReady/{orderId}")
    public String updateStatusReadyToPickup(@PathVariable("orderId") Long orderId) {

        sellerSalesService.updateStatusReadyToPickup(orderId);

        return "redirect:/seller/sales/list";
    }

    // 픽업대기 -> 픽업완료 변경 메서드
    @PostMapping("/updatePickup/{orderId}")
    public String updateStatusCompletePickup(@PathVariable("orderId") Long orderId) {

        sellerSalesService.updateStatusCompletePickup(orderId);

        return "redirect:/seller/sales/list";
    }


    // 상세보기 페이지
    @GetMapping("/detail/{orderId}")
    public String salesDetail(@PathVariable("orderId") Long orderId,
                              Model model) {
        // ⭐로그인 유저의 businessId 필요
        Long businessId = 1L;
        Long userCode = 1L;

        // 판매자 프로필 가져오기
        SellerProfileDTO sellerProfileDTO = sellerMyService.getSellerProfile(businessId, userCode);

        // 주문 상세보기 내용 가져오기
        SalesDetailDTO salesDetailDTO = sellerSalesService.findSalesDetail(orderId);
        log.info("💜💜상세정보 : {}", salesDetailDTO);

        // 모델에 담기
        model.addAttribute("salesDetailDTO", salesDetailDTO);
        model.addAttribute("sellerProfileDTO", sellerProfileDTO);

        return "mypage/seller/sellerSalesDetail";
    }


}
