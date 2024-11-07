package com.example.moamz.controller.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.ProductListDTO;
import com.example.moamz.service.mypage.seller.SellerProductService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/seller/product")
public class SellerProductRestController {
    // 상품 목록 비동기 처리를 위한 RestController

    private final SellerProductService sellerProductService;

    @Autowired
    public SellerProductRestController(SellerProductService sellerProductService) {
        this.sellerProductService = sellerProductService;
    }

    // 상품 목록 비동기로 가져오는 메서드
    @GetMapping("/list")
    public ResponseEntity<List<ProductListDTO>> getProductList(
            // 쿼리스트링에서 status값을 받아옴
            @RequestParam(name = "status", required = false, defaultValue = "onSale") String status) {
        List<ProductListDTO> productListDTO;

        Long businessId = 1L;

        if ("onSale".equals(status)) {
            productListDTO = sellerProductService.findOnSales(businessId);    // 판매중 상품 목록
            System.out.println("💜💜💜DTO : " + productListDTO);
            return ResponseEntity.ok(productListDTO);
        } else {
            productListDTO = sellerProductService.findNotOnSales(businessId); // 판매완료 상품 목록
            System.out.println("💜💜💜DTO : " + productListDTO);
            return ResponseEntity.ok(productListDTO);
        }
    } // getProductList 끝


    // 상품 상태 변경 메서드
    @PatchMapping("/status/{productId}")
    public ResponseEntity<Map<String, String>> updateProductStatus(@PathVariable("productId") Long productId) {
        // 응답 결과를 json 객체로 전달하기 위해 Map 사용
        // {"message":"상품 상태가 변경되었습니다."} 이런 형식으로 전달됨
        Map<String, String> response = new HashMap<>();

        try {
            // 상품 상태 변경 서비스 호출
            sellerProductService.updateProductStatus(productId);
            response.put("message", "상품 상태가 변경되었습니다.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "상품 상태 변경 실패: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    // 상품 삭제 메서드
    // 상품 삭제
    @GetMapping("/delete/{productId}")
    public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable("productId") Long productId) {
        Map<String, String> response = new HashMap<>();

        try {
            int result = sellerProductService.removeProduct(productId);

            if (result > 0) {
                response.put("message", "상품이 삭제되었습니다.");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "유효하지 않은 상품입니다.");
                return ResponseEntity.status(404).body(response);
            }
        } catch (Exception e) {
            response.put("error", "상품 삭제 실패: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }



} // RestController 끝
