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
public class SocialingDetailDTO {
    private Long fgPostId;
    private String fgPostType;
    private String fgPostTitle;
    private String fgSocialingContent;
    private String fgSocialingCategory;
    private int fgSocialingMaxParticipants;
    private LocalDateTime fgSocialingStart;
    private LocalDateTime fgSocialingEnd;
    private String fgSocialingLocation;
    private int fgSocialingMinage;
    private int fgSocialingMaxage;
    private String fgSocialingGenderRes;
    private Long fgUserCode;
    private String fgNormalName;

    // 게시글 작성자 파일
    private Long userFileId;         // 파일ID
    private String userFileName;     // 파일명
    private String userFileRoot;     // 파일경로
    private String userFileUuid;     // UUID
}
