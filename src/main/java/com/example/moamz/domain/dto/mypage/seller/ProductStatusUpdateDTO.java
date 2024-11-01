package com.example.moamz.domain.dto.mypage.seller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ProductStatusUpdateDTO {
    //
    // 상품 판매상태 변경 DTO (상품 품절, 상품 삭제)
    //

    private Long productId;         // 상품ID
    private String productStatus;   // 상품 판매상태

}
