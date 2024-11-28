package com.example.moamz.domain.dto.user.normal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NormalFindPasswordDTO {
    private Long fgUserCode;
    private String fgUserId;
    private String fgNormalPhone;
}
