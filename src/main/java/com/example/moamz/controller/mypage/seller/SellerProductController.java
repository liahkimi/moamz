package com.example.moamz.controller.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.ProductDetailDTO;
import com.example.moamz.domain.dto.mypage.seller.ProductListDTO;
import com.example.moamz.domain.dto.mypage.seller.ProductRegistDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerProfileDTO;
import com.example.moamz.service.mypage.seller.SellerMyService;
import com.example.moamz.service.mypage.seller.SellerProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/product")
@RequiredArgsConstructor
@Slf4j
public class SellerProductController {
    public final SellerProductService sellerProductService;
    public final SellerMyService sellerMyService;

    // 상품 등록 페이지 열기
    @GetMapping("/regist")
    public String productRegist(@SessionAttribute(value="fgUserCode", required = false) Long userCode) {
        // 세션에 userCode가 null이면 로그인 페이지로 리다이렉트
        // null이 아니면 상품 등록 페이지로 연결
        return userCode==null ? "redirect:/seller/seller/sellerLogin" :
                    "mypage/seller/sellerProductRegistration";
    }

    // 상품 등록 post 요청 처리하기
    @PostMapping("/regist")
    public String productRegister(ProductRegistDTO productRegistDTO,
                                  RedirectAttributes redirectAttributes,
                                  @SessionAttribute(value="fgUserCode", required = false) Long userCode,
                                  // html에서 input=file 태그의 name속성이 "productFile"이어야 한다.
                                  @RequestParam("productFile") MultipartFile file) {

        // businessId값 가져오기
        Long businessId = sellerMyService.findBusinessId(userCode);

        // DTO에 businessId값 설정하기
        productRegistDTO.setBusinessId(businessId);

        try {
            // 상품 및 파일 등록 서비스 호출
            sellerProductService.registerProduct(productRegistDTO, file);
        } catch (IOException e) {
            log.error("파일 저장 중 오류 발생", e);
            throw new RuntimeException(e);
        }

        // 상품 ID가 제대로 설정되었는지 확인하고 리다이렉트 시 추가 정보 설정
        if (productRegistDTO.getProductId() != null) {
            log.info("productId가 설정되었습니다 : {}", productRegistDTO.getProductId());
            redirectAttributes.addFlashAttribute("productId", productRegistDTO.getProductId());
        } else {
            log.warn("오류 : productRegistDTO.getProductId()가 NULL입니다.");
        }

        // 상품 상세 페이지로 리다이렉트
        return "redirect:/seller/product/detail/" + productRegistDTO.getProductId();
    }


    // 등록한 상품 목록 페이지 열기
    // 상품 목록은 RestController에서 비동기처리를 하기 때문에 여기서는 프로필 정보만 넘겨준다.
    @GetMapping("/list")
    public String productList(@SessionAttribute(value="fgUserCode", required = false) Long userCode,
                              Model model) {
        // 세션에 userCode가 null이면 로그인 페이지로 리다이렉트
        if(userCode == null) {
            return "redirect:/seller/seller/sellerLogin";
        }

        // businessId값 가져오기
        Long businessId = sellerMyService.findBusinessId(userCode);

        // 판매자 프로필 가져오기
        SellerProfileDTO sellerProfileDTO = sellerMyService.getSellerProfile(businessId, userCode);

        // 모델에 추가
        model.addAttribute("sellerProfileDTO", sellerProfileDTO);

        return "mypage/seller/sellerProductList";
    }

    // 상품 상세보기 페이지
    @GetMapping("/detail/{productId}")
    public String productDetail(@PathVariable("productId") Long productId,
                                @SessionAttribute(value="fgUserCode", required = false) Long userCode,
                                Model model) {
        // 세션에 userCode가 null이면 로그인 페이지로 리다이렉트
        if(userCode == null) {
            return "redirect:/seller/seller/sellerLogin";
        }

        // 상품 상세정보 가져오기 메서드
        ProductDetailDTO productDetailDTO = sellerProductService.findProductDetail(productId);
        log.info("💜💜상세정보 : {}", productDetailDTO);

        // DTO를 뷰로 전달
        model.addAttribute("productDetailDTO", productDetailDTO);
        return "mypage/seller/sellerProductDetail";
    }


}