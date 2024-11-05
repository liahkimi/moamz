package com.example.moamz.domain.dto.mypage.seller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ProductListDTO {
    //
    // 등록한 상품 목록 DTO
    //

    private Long productId;                 // 상품ID
    private String productName;             // 상품명
    private String categoryId;                 // 카테고리ID
    private int productPrice;               // 상품가격
    private int productStock;               // 재고
    private int productWeight;              // 중량
    private String productExpDate;   // 소비기한
    private String productTime;      // 상품등록일
    private String productContent;          // 상품상세
    private String productStatus;           // 상품 판매상태

    private Long productFileId;         // 파일ID
    private String productFileName;     // 파일명
    private String productFileRoot;     // 파일경로
    private String productFileUuid;     // UUID

}
