package com.example.moamz.domain.dto.mypage.seller.info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class SellerPwModifyDTO {
    //
    // 판매자 비밀번호 변경 DTO
    //

    private Long userCode;           // 회원CODE
    private String currentPassword;  // 기존 비밀번호
    private String newPassword;      // 새 비밀번호
}
