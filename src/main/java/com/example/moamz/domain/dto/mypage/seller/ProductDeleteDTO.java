package com.example.moamz.domain.dto.mypage.seller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ProductDeleteDTO {
    //
    // 상품 삭제 검증 DTO
    // 주문확인중, 픽업대기중인 상품은 삭제할 수 없다.
    //

    private Long productId;         // 상품 ID
    private String productStatus;   // 상품 판매 상태 (판매중, 판매종료)
    private String pickupStatus;    // 픽업 상태 (주문확인중, 픽업대기중, 픽업완료)
}
