package com.example.moamz.controller.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.StoreReviewDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerProfileDTO;
import com.example.moamz.service.mypage.seller.SellerMyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/seller/my")
public class SellerMyController {
    private final SellerMyService sellerMyService;


    // 리뷰 보기 페이지
    @GetMapping("/storeReview")
    public String getStoreReview(Model model) {
        Long businessId = 1L;
        Long userCode = 1L;

        List<StoreReviewDTO> storeReviewDTO = sellerMyService.findMyStoreRv(businessId);
        SellerProfileDTO sellerProfileDTO = sellerMyService.getSellerProfile(userCode, businessId);

        model.addAttribute("storeReviewDTO", storeReviewDTO);
        model.addAttribute("sellerProfileDTO", sellerProfileDTO);
        return "mypage/seller/sellerReviewCheck";
    }
}
