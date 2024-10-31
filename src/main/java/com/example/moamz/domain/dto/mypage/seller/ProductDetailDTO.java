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
    private int productWeight;      // 중량(탄소감축량 계산)
    private String productName;     // 상품명
    private String productContent;  // 상품 상세

    private Long businessId;                // 업체ID
    private String businessName;            // 업체명
    private String businessAddress;         // 업체 주소
    private String businessAddressDetail;   // 업체 상세주소
    private String businessOpenTime;        // 오픈시간
    private String businessCloseTime;       // 마감시간
    private String businessPhone;           // 업체 전화번호

    private Long productFileId;         // 파일ID (상품사진)
    private String productFileName;     // 파일명
    private String productFileRoot;     // 파일경로
    private String productFileUuid;     // UUID
}
