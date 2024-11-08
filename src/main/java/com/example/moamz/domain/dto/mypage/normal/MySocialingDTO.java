package com.example.moamz.domain.dto.mypage.normal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MySocialingDTO {
    private Long fgUserCode;
    private String fgPostTitle;
    private String fgSocialingStart;
    private String fgSocialingEnd;
    private Long fgSociaingMaxParticipants;
    private String fgSocialingCategory;
    private Long fgSocialingMinage;
    private Long fgSocialingMaxage;
    private String fgSocialingGenderRes;


    // 소셜링 사진 파일
    private Long postFileId;
    private String postFileName;
    private String postFileRoot;
    private String postFileUuid;
}
