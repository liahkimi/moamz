package com.example.moamz.domain.dto.mypage.normal.info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NormalInfoAuthDTO {
    // 회원 정보 변경 전 인증페이지 DTO

    private Long fgUserCode;    //회원 번호
    private String fgUserId;    //회원 아이디 (이메일)
    private String fgUserPassword; //회원 비밀번호
}
