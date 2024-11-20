package com.example.moamz.controller.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.ProductListDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.page.Page;
import com.example.moamz.service.mypage.seller.SellerMyService;
import com.example.moamz.service.mypage.seller.SellerProductService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/seller/product")
public class SellerProductRestController {
    // 상품 목록 비동기 처리를 위한 RestController

    private final SellerProductService sellerProductService;
    private final SellerMyService sellerMyService;

    @Autowired
    public SellerProductRestController(SellerProductService sellerProductService, SellerMyService sellerMyService) {
        this.sellerProductService = sellerProductService;
        this.sellerMyService = sellerMyService;
    }

    //
    // 상품 목록 <GET 요청>
    // 페이지네이션 O
    //
    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> getProductList(@SessionAttribute(value="fgUserCode", required = false) Long userCode,
                                                               // 쿼리스트링에서 status값을 받아옴
                                                               @RequestParam(name = "status", required = false, defaultValue = "onSale") String status,
                                                               Criteria criteria) {
        // businessId값 가져오기
        Long businessId = sellerMyService.findBusinessId(userCode);

        // 한 페이지에 게시글 5개씩 보이도록 설정
        criteria.setAmount(5);

        // 결과 리스트, 페이지네이션 변수 정의
        List<ProductListDTO> productListDTO;
        int total;

        // 판매 상태에 따라 목록 가져오기
        if ("onSale".equals(status)) {
            productListDTO = sellerProductService.findOnSalesAll(businessId, criteria);    // 판매중 상품 목록
            // 전체 상품 수
            total = sellerProductService.findOnsaleTotal(businessId);
        } else {
            productListDTO = sellerProductService.findNotOnSalesAll(businessId, criteria); // 판매완료 상품 목록
            // 전체 상품 수
            total = sellerProductService.findNotOnsaleTotal(businessId);
        }

        // 페이지
        Page page = new Page(criteria, total);

        // 응답 객체 정의
        Map<String, Object> response = new HashMap<>();
        response.put("page", page);
        response.put("productListDTO", productListDTO);

        System.out.println("🧡🧡🧡응답객체 " + response);
        // page 정보, 리스트를 담아서 응답 객체 반환
        return ResponseEntity.ok(response);
    } // getProductList 끝


    //
    // 상품 상태 변경 <PATCH 요청>
    //
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

    //
    // 상품 삭제 <DELETE 요청>
    //
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Map<String, String>> deleteProduct(@PathVariable("productId") Long productId) {
        Map<String, String> response = new HashMap<>();

        try {
            sellerProductService.removeProduct(productId);
            response.put("message", "상품이 삭제되었습니다.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "상품 삭제 실패: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }



} // RestController 끝
