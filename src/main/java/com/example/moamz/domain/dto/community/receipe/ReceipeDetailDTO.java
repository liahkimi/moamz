package com.example.moamz.domain.dto.community.receipe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReceipeDetailDTO {
    private Long fgPostid;
    private String fgPostTitle;
    private Long fgUserCode;
    private String fgNormalName;
    private LocalDateTime fgPostCreatedAt;
    private String fgReceipeIngredients;
    private int fgReceipeTime;
    private String fgReceipeContent;
    private Long fgCommentId;
    private String fgCommentContent;
    private char fgCommentEdit;
    private String fgPostViews;

    // 게시글 작성자 파일
    private Long userFileId;         // 파일ID
    private String userFileName;     // 파일명
    private String userFileRoot;     // 파일경로
    private String userFileUuid;     // UUID
}
