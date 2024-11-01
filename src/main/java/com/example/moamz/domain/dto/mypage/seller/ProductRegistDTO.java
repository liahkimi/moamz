package com.example.moamz.domain.dto.mypage.seller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ProductRegistDTO {
    //
    // 상품 등록 DTO
    //

    // 날짜 데이터타입
    // 저장할 때는 String으로
    // 저장된 날짜를 조회할 때는 LocalDateTime나 LocalDate를 쓰자 (날짜 연산하여 문자열 처리 포맷팅이 편리함)
    // LocalDate는 연/월/일만 다룬다(시간x) LocalDateTime은 시간까지 다룬다

    private Long productId;         // 상품ID
    private String productName;     // 상품명
    private int productPrice;       // 상품가격
    private int productStock;       // 재고
    private int productWeight;      // 상품 중량
    private String productExpDate;  // 소비기한
    private String productContent;  // 상품 상세내용
    private String productTime;     // 상품 등록일
    private String productStatus;   // 상품 판매상태
    private int productCategoryId;  // 카테고리ID
    private int businessId;         // 업체ID

    private Long productFileId;         // 파일ID
    private String productFileName;     // 파일명
    private String productFileRoot;     // 파일경로
    private String productFileUuid;     // UUID
    private String productFileTime;     // 파일 생성일

}
