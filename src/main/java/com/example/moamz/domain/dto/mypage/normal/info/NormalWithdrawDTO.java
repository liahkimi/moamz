package com.example.moamz.domain.dto.mypage.normal.info;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NormalWithdrawDTO {
    private Long fgUserCode;
    private String fgUserId;
    private String fgUserPassword;
}
