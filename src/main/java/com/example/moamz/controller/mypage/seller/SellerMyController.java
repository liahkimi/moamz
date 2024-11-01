package com.example.moamz.controller.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.ProductRegistDTO;
import com.example.moamz.service.mypage.seller.SellerProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/seller")
@RequiredArgsConstructor
@Slf4j
public class SellerMyController {
    public final SellerProductService sellerProductService;

    // 상품 등록 페이지 열기
    // 로그인 기능 완료되면 세션 추가해줘야 함
    @GetMapping("/productRegist")
    public String productRegist() {
        return "mypage/seller/sellerProductRegistration";
    }

    // 상품 등록 post 요청 처리하기
    @PostMapping("/productRegist")
    public String productRegister(ProductRegistDTO productRegistDTO,
                                  RedirectAttributes redirectAttributes,
                                  // html에서 input=file 태그의 name속성이 "productFile"이어야 한다.
                                  @RequestParam("productFile") MultipartFile file) {
        // 세션 없어서 일단 businessId에 1값 넣음
        productRegistDTO.setBusinessId(1);
        log.info("🌟🌟🌟상품 등록 요청: {}", productRegistDTO);

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

        // 상품 목록 페이지로 리다이렉트
        return "redirect:/seller/productList";
    }
}