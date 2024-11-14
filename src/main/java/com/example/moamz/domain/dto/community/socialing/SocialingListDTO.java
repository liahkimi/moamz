package com.example.moamz.domain.dto.community.socialing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SocialingListDTO {
    private Long fgPostId;
    private String fgPostType;
    private String fgPostTitle;
    private String fgSocialingContent;
    private String fgSocialingCategory;
    private int fgSocialingMaxParticipants;
    private LocalDateTime fgSocialingStart;
    private LocalDateTime fgSocialingEnd;
    private String fgSocialingLocation;
    private String fgSocialingGenderRes;
    private int fgSocialingMinage;
    private int fgSocialingMaxage;

    private Long postFileId;        // 파일ID
    private String postFileName;    // 파일명
    private String postFileRoot;    // 파일경로
    private String postFileUuid;    // 파일UUID
}
