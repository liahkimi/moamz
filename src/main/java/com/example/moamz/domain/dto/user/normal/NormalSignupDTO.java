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
public class NormalSignupDTO {
    private Long fgUserCode;
    private String fgUserId;
    private String fgUserPassword;
    private LocalDateTime fgUserJoinDate;
    private String fgUserType;
    private String fgNormalName;
    private String fgNormalNickname;
    private LocalDateTime fgNormalBirth;
    private String fgNormalGender;
    private String fgNormalPostCode;
    private String fgNormalAddress;
    private String fgNormalAddressDetail;
    private String fgNormalLoginType;
    private String fgNormalKakaoId;
    private Long fgUserFileId;
    private String fgUserFileRoot;
    private String fgUserFileName;
    private LocalDateTime fgUserFileTime;
    private String fgUserFileUuid;
    private Long fgPointId;
}
