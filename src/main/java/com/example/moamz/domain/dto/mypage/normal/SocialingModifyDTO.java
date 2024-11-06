package com.example.moamz.domain.dto.mypage.normal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SocialingModifyDTO {
    private Long fgUserCode;
    private String fgPostTitle;
    private String fgSocialingCategory;
    private String fgSocialingMaxParticipants;
    private String fgSociailingStart;
    private String fgSociailingEnd;
    private String fgSociailingLocation;
    private String fgSocialingGenderRes;
    private String fgSocialingMinage;
    private String fgSocialingMaxAge;
    private String fgSocialingContent;
}
