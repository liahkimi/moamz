package com.example.moamz.domain.dto.admin.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class AdminUserSessionDTO {
//    관리자 세션 관리
    private Long fgUserCode;//회원번호(관리자)
    private String fgUserId;//로그인ID(관리자)
}
