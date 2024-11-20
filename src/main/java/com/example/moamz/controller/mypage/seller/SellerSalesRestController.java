package com.example.moamz.controller.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.SalesListDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.page.Page;
import com.example.moamz.service.mypage.seller.SellerMyService;
import com.example.moamz.service.mypage.seller.SellerSalesService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/seller/sales")
@RequiredArgsConstructor
public class SellerSalesRestController {
    private final SellerSalesService sellerSalesService;
    private final SellerMyService sellerMyService;

    //
    // 판매 내역 <GET 요청>
    // 페이지네이션O
    //
    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> getList(@SessionAttribute(value="fgUserCode", required = false) Long userCode,
                                                       @RequestParam(name = "status") String status,
                                                       Criteria criteria) {
        // 한 페이지에 게시글이 7개씩 보이도록 설정
        criteria.setAmount(7);

        // 판매자 businessId값 가져오기
        Long businessId = sellerMyService.findBusinessId(userCode);

        // 결과 리스트, 총 게시글 수 변수 정의
        List<SalesListDTO> salesList = null;
        int total = 0;

        // 픽업 상태에 따른 결과리스트, 총 게시글 수 가져오기
        switch (status) {
            case "ready":
                salesList = sellerSalesService.findCheckOrderAll(criteria, businessId);
                total = sellerSalesService.findCheckOrderTotal(businessId);
                break;
            case "pickup":
                salesList = sellerSalesService.findReadyToPickUpAll(criteria, businessId);
                total = sellerSalesService.findReadyToPickupTotal(businessId);
                break;
            case "completed":
                salesList = sellerSalesService.findCompletePickupAll(criteria, businessId);
                total = sellerSalesService.findCompletePickupTotal(businessId);
                break;
        }

        // 페이지 객체 생성
        Page page = new Page(criteria, total);

        // 응답 객체 정의
        Map<String, Object> response = new HashMap<>();

        // 응답 객체에 page, 리스트 정보 담아서 반환하기
        response.put("page", page);
        response.put("salesList", salesList);
        System.out.println("🧡 response : " + response);
        return ResponseEntity.ok(response);
    }

    // 주문확인 -> 픽업대기 변경 메서드
    @PatchMapping("/updateReady/{orderId}")
    public void updateStatusReadyToPickup(@PathVariable("orderId") Long orderId) {

        sellerSalesService.updateStatusReadyToPickup(orderId);

    }

    // 픽업대기 -> 픽업완료 변경 메서드
    @PatchMapping("/updatePickup/{orderId}")
    public void updateStatusCompletePickup(@PathVariable("orderId") Long orderId) {

        sellerSalesService.updateStatusCompletePickup(orderId);

    }
}
