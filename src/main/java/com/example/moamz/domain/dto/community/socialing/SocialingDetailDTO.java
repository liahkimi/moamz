package com.example.moamz.domain.dto.community.socialing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SocialingDetailDTO {
    private Long fgPostId;
    private String fgPostType;
    private String fgPostTitle;
    private String fgSocialingContent;
    private String fgSocialingCategory;
    private int fgSocialingMaxParticipants;
    private String fgSocialingStart;
    private String fgSocialingEnd;
    private String fgSocialingLocation;
    private int fgSocialingMinage;
    private int fgSocialingMaxage;
    private Long fgUserCode;
    private String fgNormalName;
}
