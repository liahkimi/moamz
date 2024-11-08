package com.example.moamz.domain.dto.user.normal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NormalUserSignupDTO {
    private Long fgUserCode;
    private String fgNormalName;
    private String fgNormalNickname;
    private String fgNormalBirth;
    private String fgNormalGender;
    private String fgNormalPhone;
    private String fgNormalPostcode;
    private String fgNormalAddress;
    private String fgNormalAddressDetail;
    private String fgNormalLoginType;
    private String fgNormalKaKaoId;
}
