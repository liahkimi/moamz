package com.example.moamz.domain.dto.community.ecoproject;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EcoCertDetailDTO {
    private Long fgPostId;
    private Long fgProjectId;
    private String fgPostTitle;
    private LocalDateTime fgPostCreatedAt;
    private String fgCertContent;
    private int fgPostViews;
    private Long fgCommonUserCode;
    private String fgNormalName;
    private String fgCommentCount;
    private String fgUserProfile;
    private int fgLikes;
}
