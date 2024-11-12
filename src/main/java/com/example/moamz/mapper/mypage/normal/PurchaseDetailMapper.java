package com.example.moamz.mapper.mypage.normal;

import com.example.moamz.domain.dto.mypage.normal.PurchaseDetailDTO;
import com.example.moamz.domain.dto.mypage.normal.PurchaseHistoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseDetailMapper {
    // 주문 픽업
    List<PurchaseDetailDTO> selectProductPickup(Long fgOrderId);

    // 업체명
    List<PurchaseDetailDTO> selectProductBusiness(Long fgUserCode);

    // 상품 정보
    List<PurchaseDetailDTO> selectProduct(Long fgUserCode);

    // 상품 가격
    List<PurchaseDetailDTO> selectProductPrice();

    List<PurchaseHistoryDTO> selectPurchaseHistory(Long userCode);
}
