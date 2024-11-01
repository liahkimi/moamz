package com.example.moamz.mapper.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.ProductRegistDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRegistMapper {
    // 상품 등록하기
    void insertProduct(ProductRegistDTO productRegistDTO);
}
