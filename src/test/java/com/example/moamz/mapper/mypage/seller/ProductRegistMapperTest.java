package com.example.moamz.mapper.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.ProductRegistDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Slf4j
class ProductRegistMapperTest {
    //
    // 상품 등록 mapper 테스트
    //

    @Autowired
    ProductRegistMapper productRegistMapper;
    ProductRegistDTO productRegistDTO;

    @BeforeEach
    void setUp() {
        productRegistDTO = new ProductRegistDTO();

        productRegistDTO.setProductName("고구마");
        productRegistDTO.setProductPrice(3000);
        productRegistDTO.setProductStock(3);
        productRegistDTO.setProductWeight(500);
        productRegistDTO.setProductExpDate("2024-10-26T08:57");
        productRegistDTO.setProductContent("음 맛도리 호박고구마 진짜 싸게팔아요 안사면 손해");
        productRegistDTO.setProductCategoryId(2);
        productRegistDTO.setBusinessId(1);

//        productRegistDTO.setProductFileName("호박고구마.jpg");
//        productRegistDTO.setProductFileRoot("imgs/product");
//        productRegistDTO.setProductFileUuid("uuid01호박고구마");
//
//        productRegistMapper.insertProduct(productRegistDTO);
//        productRegistMapper.insertProductFile(productRegistDTO);
        log.info(productRegistDTO.toString());   //잘 삽입되었는지 로그 찍어보자
        System.out.println("***************************************************");
    }

    @Test
    @DisplayName("상품 등록 테스트")
    void insertProductTest() {
        // 검증할 것 : id값이 있는지?
        assertThat(productRegistDTO.getProductId()).isNotNull();
    }

    @Test
    @DisplayName("상품 사진 등록 테스트")
    void insertProductFileTest() {
        // 검증할것 : id값이 있는지?
//        assertThat(productRegistDTO.getProductFileId()).isNotNull();
    }


}