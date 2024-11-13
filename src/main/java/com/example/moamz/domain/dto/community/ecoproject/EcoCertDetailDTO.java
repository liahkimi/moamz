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

    private Long postFileId;        // 파일ID
    private String postFileName;    // 파일명
    private String postFileRoot;    // 파일경로
    private String postFileUuid;    // 파일UUID

    // 게시글 작성자 파일
    private Long userFileId;         // 파일ID
    private String userFileName;     // 파일명
    private String userFileRoot;     // 파일경로
    private String userFileUuid;     // UUID
}
