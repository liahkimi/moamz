package com.example.moamz.domain.dto.mypage.seller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class SalesListDTO {
    //
    // 상품판매내역 DTO
    //

    private Long businessId;            // 업체id
    private Long orderId;               // 주문id
    private String orderDate;           // 주문일
    private String productName;         // 주문상품명
    private int orderPerPrice;          // 상품가격
    private String pickupSchedule;      // 픽업예정시간
    private String pickupCompleteTime;  // 픽업완료시간
    private String normalNickname;      // 주문자 닉네임
    private String pickupRequest;       // 픽업 요청사항
    private String pickupStatus;        // 상품 픽업상태

    private Long productId;             // 상품ID
    private Long productFileId;         // 파일ID
    private String productFileName;     // 파일명
    private String productFileRoot;     // 파일경로
    private String productFileUuid;     // UUID

}
