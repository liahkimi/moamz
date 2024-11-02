package com.example.moamz.domain.dto.admin.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class UserDTO {
//    관리자 로그인

    private Long userCode; //회원번호(관리자)
    private String userId; //로그인ID(관리자)
    private String password; //비밀번호(관리자)
}
