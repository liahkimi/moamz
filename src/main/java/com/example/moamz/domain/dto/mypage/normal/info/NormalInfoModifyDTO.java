package com.example.moamz.domain.dto.mypage.normal.info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NormalInfoModifyDTO {
    private Long fgUserCode;
    // 회원 프로필 사진
    private Long fgUserFileId;            // 파일ID
    private String fgUserFileName;        // 파일명
    private String fgUserFileRoot;        // 파일경로
    private String fgUserFileUuid;        // 파일UUID

    private String fgUserId;
    private String fgNormalNickname;
    private String fgNormalName;
    private String fgNormalPhone;
    private LocalDateTime fgNormalBirth;
    private String fgNormalGender;
    private String fgNormalAddress;
    private String fgNormalAddressDetail;
}
