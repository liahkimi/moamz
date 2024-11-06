package com.example.moamz.controller.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.ProductListDTO;
import com.example.moamz.service.mypage.seller.SellerProductService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/seller/product")
public class SellerProductRestController {
    // 상품 목록 비동기 처리를 위한 RestController

    private final SellerProductService sellerProductService;

    @Autowired
    public SellerProductRestController(SellerProductService sellerProductService) {
        this.sellerProductService = sellerProductService;
    }

    /**
     * 상품 목록을 비동기로 가져오는 API
     */
    @GetMapping("/list")
    public ResponseEntity<List<ProductListDTO>> getProductList(@RequestParam(name = "status", required = false, defaultValue = "onSale") String status) {
        List<ProductListDTO> productListDTO;

        Long businessId = 1L;

        if ("onSale".equals(status)) {
            productListDTO = sellerProductService.findOnSales(businessId);
            return ResponseEntity.ok(productListDTO);    // 판매중 상품 목록
        } else {
            productListDTO = sellerProductService.findNotOnSales(businessId);
            return ResponseEntity.ok(productListDTO);  // 판매완료 상품 목록
        }
    }
}
