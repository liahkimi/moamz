package com.example.moamz.domain.dto.mypage.seller.info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class SellerPhoneModifyDTO {
    //
    // 판매자 전화번호 변경 DTO
    //

    private Long userCode;        // 회원CODE
    private String sellerPhone;   // 새로운 휴대폰번호
}
