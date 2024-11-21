package com.example.moamz.mapper.mypage.normal;

import com.example.moamz.domain.dto.mypage.normal.PurchaseDetailDTO;
import com.example.moamz.domain.dto.mypage.normal.PurchaseHistoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseDetailMapper {
    PurchaseDetailDTO selectPurchaseDetail(Long fgOrderId);

    // 주문 픽업
    PurchaseDetailDTO selectProductPickup(Long fgOrderId);

    // 업체명
    PurchaseDetailDTO selectProductBusiness(Long fgBusinessId);

    // 상품 정보
    PurchaseDetailDTO selectProduct(Long fgOrderId);

    // 상품 가격
    PurchaseDetailDTO selectProductPrice(Long fgOrderId);

    List<PurchaseHistoryDTO> selectPurchaseHistory(Long userCode);
}
