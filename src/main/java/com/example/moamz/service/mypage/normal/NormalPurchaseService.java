//package com.example.moamz.service.mypage.normal;
//
//import com.example.moamz.domain.dto.mypage.normal.PurchaseDetailDTO;
//import com.example.moamz.domain.dto.mypage.normal.PurchaseHistoryDTO;
//import com.example.moamz.mapper.mypage.normal.PurchaseDetailMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class NormalPurchaseService {
//
//    private final PurchaseDetailMapper purchaseDetailMapper;
//
//    // 구매 내역 조회 (구매자 코드로 조회)
//    public List<PurchaseHistoryDTO> getPurchaseHistory(Long userCode) {
//        return purchaseDetailMapper.selectPurchaseHistory(userCode); // 구매 내역을 가져오는 메서드
//    }
//
//    // 구매 내역 상세 정보 조회
//    public PurchaseDetailDTO getPurchaseDetail(Long fgUserCode, Long fgOrderId) {
//        // 주문 상세 정보 가져오기
//        PurchaseDetailDTO purchaseDetail = (PurchaseDetailDTO) purchaseDetailMapper.selectProductPickup(fgOrderId);
//        // 업체 정보 가져오기
//        PurchaseDetailDTO businessInfo = (PurchaseDetailDTO) purchaseDetailMapper.selectProductBusiness(fgUserCode);
//        // 상품 정보 가져오기
//        PurchaseDetailDTO productInfo = (PurchaseDetailDTO) purchaseDetailMapper.selectProduct(fgUserCode);
//
//        // 하나의 DTO에 모두 합침
//        purchaseDetail.setFgBusinessName(businessInfo.getFgBusinessName());
//        purchaseDetail.setFgBusinessAddress(businessInfo.getFgBusinessAddress());
//        purchaseDetail.setFgProductName(productInfo.getFgProductName());
//        purchaseDetail.setFgProductPrice(productInfo.getFgProductPrice());
//
//        return purchaseDetail;
//    }
//}
