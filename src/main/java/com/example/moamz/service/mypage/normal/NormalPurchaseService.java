package com.example.moamz.service.mypage.normal;

import com.example.moamz.domain.dto.mypage.normal.PurchaseDetailDTO;
import com.example.moamz.domain.dto.mypage.normal.PurchaseHistoryDTO;
import com.example.moamz.domain.dto.mypage.seller.ProductListDTO;
import com.example.moamz.mapper.mypage.normal.PurchaseDetailMapper;
import com.example.moamz.mapper.mypage.normal.PurchaseHistoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class NormalPurchaseService {

    private final PurchaseHistoryMapper purchaseHistoryMapper;
    private final PurchaseDetailMapper purchaseDetailMapper;

    // 구매 내역 조회 (구매자 코드로 조회)
    public List<PurchaseHistoryDTO> getPurchaseHistory(Long fgUserCode) {

        log.info("service 확인 ======== " + fgUserCode);
        List<PurchaseHistoryDTO> list = purchaseHistoryMapper.selectPurchaseList(fgUserCode);
        log.info("🍎🍎🍎🍎🍎service에서 {}", list);
//        return purchaseHistoryMapper.selectPurchaseList(fgUserCode); // 구매 내역을 가져오는 메서드
        return list;   // 중복 제거
//        return List.of(new PurchaseHistoryDTO(
//                LocalDateTime.now(),           // 주문 날짜
////                "/images/sample_image.jpg",    // 상품 사진 경로
//                "Sample Product",              // 상품명
//                50000L,                        // 상품 가격
//                "2024-11-15 14:00",            // 픽업 예정 시간
//                "Sample Business",             // 업체명
//                "Handle with care",            // 요청 사항
//                "Pending",                     // 픽업 여부
//                1001L,                         // 상품 파일 ID
//                "sample_image.jpg",            // 상품 파일명
//                "/images/",                    // 상품 파일 경로
//                "abcd-1234-efgh-5678"          // 상품 파일 UUID
//        ));


    }

    // 주문 픽업 정보 조회
    public PurchaseDetailDTO getProductPickup(Long fgOrderId) {
        return purchaseDetailMapper.selectProductPickup(fgOrderId);
    }
    // 업체 정보 조회
    public PurchaseDetailDTO getProductBusiness(Long fgBusinessId) {
        return purchaseDetailMapper.selectProductBusiness(fgBusinessId);
    }


    // 상품 정보 조회
    public PurchaseDetailDTO getProduct(Long fgOrderId) {
        return purchaseDetailMapper.selectProduct(fgOrderId);
    }

    public PurchaseDetailDTO getProductPrice(Long fgOrderId) {
        return purchaseDetailMapper.selectProductPrice(fgOrderId);
    }

//    public Long getBusinessByOrderId(Long fgOrderId) {
//    }


//
//    // 구매 내역 상세 정보 조회
//    public Map<String, Object> getPurchaseDetail(Long fgUserCode, Long fgOrderId) {
//        // 반환 객체 생성
//        Map<String, Object> detailResponse = new HashMap<>();
//
//        // 주문 상세 정보 가져오기
//        PurchaseDetailDTO purchaseDetail = purchaseDetailMapper.selectProductPickup(fgOrderId);
//
//        // businessId값 가져오기
//        Long businessId = purchaseDetail.getFgBusinessId();
//
//        // 업체 정보 가져오기
//        PurchaseDetailDTO businessInfo = purchaseDetailMapper.selectProductBusiness(businessId);
//
//        // 상품 정보 가져오기
//        PurchaseDetailDTO productInfo = purchaseDetailMapper.selectProduct(fgOrderId);
//
//        // 상품 가격 가져오기
//        PurchaseDetailDTO priceInfo = purchaseDetailMapper.selectProductPrice(fgOrderId);
//
//        // 반환객체 map에 DTO 담기
//        detailResponse.put("purchaseDetail", purchaseDetail);
//        detailResponse.put("businessInfo", businessInfo);
//        detailResponse.put("productInfo", productInfo);
//        detailResponse.put("priceInfo", priceInfo);
//
//
////        System.out.println("🍎🍎" + businessInfo);
////        System.out.println("🍎🍎" + priceInfo);
//        return detailResponse;
//    }

}
