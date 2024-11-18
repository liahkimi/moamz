package com.example.moamz.controller.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.StoreReviewDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerProfileDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.page.Page;
import com.example.moamz.service.mypage.seller.SellerMyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/seller/my")
public class SellerMyController {
    private final SellerMyService sellerMyService;


    // 리뷰 보기 페이지
    @GetMapping("/storeReview")
    public String getStoreReview(@SessionAttribute(value="fgUserCode", required=false) Long userCode,
                                 Criteria criteria,
                                 Model model) {
        // 세션에 userCode가 null이면 로그인 페이지로 이동
        if(userCode == null) {
            return "redirect:/seller/seller/sellerLogin";
        }

        // 한 페이지에 게시글 10개씩 보이도록 설정
        criteria.setAmount(10);

        // 판매자 업체id값 가져오기
        Long businessId = sellerMyService.findBusinessId(userCode);
        log.info("🧡🧡🧡businessId : {}", businessId);
        // 페이징을 포함한 리스트 반환
        List<StoreReviewDTO> storeReviewDTO = sellerMyService.findMyStoreRvAll(businessId, criteria);
        // 전체 리뷰 수
        int total = sellerMyService.findTotal(businessId);
        Page page = new Page(criteria, total);

        // 판매자 프로필 반환
        SellerProfileDTO sellerProfileDTO = sellerMyService.getSellerProfile(userCode, businessId);

        // 모델에 전달
        model.addAttribute("page", page);
        model.addAttribute("storeReviewDTO", storeReviewDTO);
        model.addAttribute("sellerProfileDTO", sellerProfileDTO);

        // 리뷰 확인 페이지로 이동
        return "mypage/seller/sellerReviewCheck";
    }
}
