package com.example.moamz.domain.dto.admin.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class UserSessionDTO {
    private Long userCode;//회원번호(관리자)
    private String loginId;//로그인ID(관리자)
}
