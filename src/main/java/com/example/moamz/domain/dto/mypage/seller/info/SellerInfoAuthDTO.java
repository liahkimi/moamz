package com.example.moamz.domain.dto.mypage.seller.info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class SellerInfoAuthDTO {
    //
    // 판매자 정보 인증 DTO
    // 정보 변경 전 인증 페이지
    // 회원 탈퇴 전 인증 할 때도 이 DTO 사용 가능
    //

    private Long userCode;      // 회원 코드
    private String userId;      // 사용자 아이디 (확인용)
    private String password;    // 사용자 비밀번호 (확인용)
}
