package com.example.moamz.domain.dto.mypage.seller.info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class SellerInfoDTO {
    //
    // 판매자 개인정보 DTO
    // 개인정보 변경 페이지에 들어갔을 때 이 내용이 보여짐
    //

    private Long userCode;          // 유저CODE
    private String sellerName;      // 판매자 회원명
    private String userId;          // 판매자ID
    private String sellerPhone;     // 판매자 핸드폰번호
}
