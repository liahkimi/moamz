package com.example.moamz.mapper.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.ProductDetailDTO;
import com.example.moamz.domain.dto.mypage.seller.ProductListDTO;
import com.example.moamz.domain.dto.mypage.seller.ProductRegistDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SellerProductMapper {
    // 상품 등록하기
    void insertProduct(ProductRegistDTO productRegistDTO);

    // 판매중인 상품 목록 가져오기
    List<ProductListDTO> selectOnSales(Long businessId);

    // 판매종료 상품 목록 가져오기
    List<ProductListDTO> selectNotOnSales(Long businessId);

    // 상품 판매상태 변경
    void modifyProductStatus(Long productId);

    // 상품 삭제
    void deleteProduct(Long productId);

    // 상품 상세보기
    Optional<ProductDetailDTO> selectProductDetail(Long productId);
}
