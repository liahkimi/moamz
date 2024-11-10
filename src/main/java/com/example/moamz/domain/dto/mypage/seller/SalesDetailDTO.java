package com.example.moamz.domain.dto.mypage.seller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SalesDetailDTO {
    //
    // 상품판매내역 상세 DTO
    //

    // 주문 관련 정보
    private Long orderId;                // 주문ID
    private String orderDate;            // 주문일시 (YYYY/MM/DD HH24:MI:SS 형식)
    private Long businessId;             // 업체ID

    // 상품 정보
    private Long productId;             // 상품ID
    private Long productFileId;         // 파일ID
    private String productFileName;     // 파일명
    private String productFileRoot;     // 파일경로
    private String productFileUuid;     // UUID

    private String productName;          // 상품명
    private int productPrice;            // 상품 가격
    private String productExpDate;       // 소비기한 (YY-MM-DD HH24:MI 형식)
    private int productWeight;           // 상품 중량
    private String productContent;       // 상품 상세 정보

    // 고객 정보
    private Long userCode;               // 고객 유저ID
    private String normalNickname;       // 고객 닉네임
    private String pickupSchedule;       // 픽업 예정 시간
    private String pickupRequest;        // 픽업 요청사항

    // 픽업 정보
    private String pickupStatus;         // 상품 준비 상태
    private String pickupCompletedTime;  // 픽업 완료 시간
}
