package com.example.moamz.controller.mypage.seller;

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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/seller/sales")
public class SellerSalesController {
    private final SellerSalesService sellerSalesService;
    private final SellerMyService sellerMyService;


    // 판매한 상품 내역 페이지
    // 목록은 비동기 처리를 하기 때문에 여기서는 판매자 프로필 정보만 전달한다.
    @GetMapping("/list")
    public String salesList(Model model) {
        // ⭐로그인 유저의 businessId 필요
        Long businessId = 1L;
        Long userCode = 1L;

        // 판매자 프로필 가져오기
        SellerProfileDTO sellerProfileDTO = sellerMyService.getSellerProfile(businessId, userCode);
        List<SalesListDTO> salesListDTO = sellerSalesService.findCheckOrder(businessId);

        // 모델에 추가
        model.addAttribute("sellerProfileDTO", sellerProfileDTO);
        model.addAttribute("salesListDTO", salesListDTO);
        log.info("💜💜💜salesListDTO : {}", salesListDTO);

        return "mypage/seller/sellerSalesHistory";

    }
}
