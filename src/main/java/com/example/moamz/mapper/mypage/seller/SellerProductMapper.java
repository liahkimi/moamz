package com.example.moamz.mapper.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.ProductListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SellerProductMapper {
    // 판매중인 상품 목록 가져오기
    List<ProductListDTO> selectOnSales();

    // 판매종료 상품 목록 가져오기
    List<ProductListDTO> selectNotOnSales();
}
