package com.example.moamz.controller.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.StoreReviewDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerProfileDTO;
import com.example.moamz.service.mypage.seller.SellerMyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/seller/my")
public class SellerMyController {
    private final SellerMyService sellerMyService;


    // 리뷰 보기 페이지
    @GetMapping("/storeReview")
    public String getStoreReview(@SessionAttribute(value="fgUserCode", required=false) Long userCode,
                                 Model model) {
        // 세션에 userCode가 null이면 로그인 페이지로 이동
        if(userCode == null) {
            return "redirect:/seller/seller/sellerLogin";
        }

        // 판매자 업체id값 가져오기
        Long businessId = sellerMyService.findBusinessId(userCode);

        List<StoreReviewDTO> storeReviewDTO = sellerMyService.findMyStoreRv(businessId);
        SellerProfileDTO sellerProfileDTO = sellerMyService.getSellerProfile(userCode, businessId);

        model.addAttribute("storeReviewDTO", storeReviewDTO);
        model.addAttribute("sellerProfileDTO", sellerProfileDTO);

        // 리뷰 확인 페이지로 이동
        return "mypage/seller/sellerReviewCheck";
    }
}
