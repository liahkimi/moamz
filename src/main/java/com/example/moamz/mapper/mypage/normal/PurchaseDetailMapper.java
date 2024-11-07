package com.example.moamz.mapper.mypage.normal;

import com.example.moamz.domain.dto.mypage.normal.PurchaseDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseDetailMapper {
    // 주문 픽업
    List<PurchaseDetailDTO> selectProductPickup();

    // 업체명
    List<PurchaseDetailDTO> selectProductBusiness();

    // 상품 정보
    List<PurchaseDetailDTO> selectProduct();

    // 상품 가격
    List<PurchaseDetailDTO> selectProductPrice();

}
