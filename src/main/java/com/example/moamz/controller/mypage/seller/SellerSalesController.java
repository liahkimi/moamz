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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/seller/sales")
public class SellerSalesController {
    private final SellerSalesService sellerSalesService;
    private final SellerMyService sellerMyService;

    //
    // 판매 내역 <GET 요청>
    // 판매자 프로필만 전달함. 판매 내역은 RestController에서 처리
    //
    @GetMapping("/list")
    public String salesList(@SessionAttribute(value="fgUserCode", required = false) Long userCode,
                            Model model) {
        // 세션에 userCode가 null이면 로그인 페이지로 리다이렉트
        if(userCode == null) {
            return "redirect:/seller/seller/sellerLogin";
        }

        // businessId값 가져오기
        Long businessId = sellerMyService.findBusinessId(userCode);

        // 판매자 프로필 가져오기
        SellerProfileDTO sellerProfileDTO = sellerMyService.getSellerProfile(businessId, userCode);

        // 상품 준비 상태별 판매 목록 가져오기
//        List<SalesListDTO> readyList = sellerSalesService.findCheckOrder(businessId);
//        List<SalesListDTO> pickupList = sellerSalesService.findReadyToPickUp(businessId);
//        List<SalesListDTO> completedList = sellerSalesService.findCompletePickup(businessId);

        // 모델에 추가
        model.addAttribute("sellerProfileDTO", sellerProfileDTO);
//        model.addAttribute("readyList", readyList);
//        model.addAttribute("pickupList", pickupList);
//        model.addAttribute("completedList", completedList);

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
                              @SessionAttribute(value="fgUserCode", required = false) Long userCode,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        // 세션에 userCode가 null이면 로그인 페이지로 리다이렉트
        if (userCode == null) {
            return "redirect:/seller/seller/sellerLogin";
        }

        // businessId값 가져오기
        Long businessId = sellerMyService.findBusinessId(userCode);

        // 판매자 프로필 가져오기
        SellerProfileDTO sellerProfileDTO = sellerMyService.getSellerProfile(businessId, userCode);

        // 주문 상세보기 내용 가져오기
        SalesDetailDTO salesDetailDTO = sellerSalesService.findSalesDetail(orderId);

        // 세션의 businessId가 salesDetailDTO의 businessId값과 같은 경우에만 상세페이지에 접근 가능
        if (businessId.equals(salesDetailDTO.getBusinessId())) {
            // 모델에 담기
            model.addAttribute("salesDetailDTO", salesDetailDTO);
            model.addAttribute("sellerProfileDTO", sellerProfileDTO);

            return "mypage/seller/sellerSalesDetail";
        } else {
            // 세션의 userCode와 DTO의 userCode값이 다르면 상세글에 접근할 수 없다.
            // alert 메시지를 추가.. 실제 alert는 리다이렉트된 뷰에서 뜨게 된다.
            redirectAttributes.addFlashAttribute("Message", "다른 판매자의 판매내역은 조회 불가능합니다.");
            return "redirect:/seller/sales/list";
        }
    } // salesDetail 끝





}   // 컨트롤러 끝
