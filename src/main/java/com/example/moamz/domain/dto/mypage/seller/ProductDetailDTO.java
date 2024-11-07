package com.example.moamz.domain.dto.mypage.seller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ProductDetailDTO {
    //
    // 상품 상세 DTO
    //

    private int productId;          // 상품ID
    private int productWeight;      // 중량
    private Double carbonReduct;    // 탄소감축량
    private String productName;     // 상품명
    private String productExpDate;  // 상품 소비기한
    private String productContent;  // 상품 상세

    private Long businessId;                // 업체ID
    private String businessName;            // 업체명
    private String businessAddress;         // 업체 주소
    private String businessRunTime;         // 영업시간
    private String businessPhone;           // 업체 전화번호

    private Long productFileId;         // 파일ID (상품사진)
    private String productFileName;     // 파일명
    private String productFileRoot;     // 파일경로
    private String productFileUuid;     // UUID
}
