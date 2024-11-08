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
public class NormalCommonSignupDTO {
    private Long fgUserCode;
    private String fgUserId;
    private String fgUserPassword;
    private String fgUserJoinDate;
    private String fgUserType;
}
