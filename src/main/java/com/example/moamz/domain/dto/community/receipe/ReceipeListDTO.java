package com.example.moamz.domain.dto.community.receipe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReceipeListDTO {
    private Long fgPostId;
    private String fgPostType;
    private Long fgPostFileId;
    private String fgPostTitle;
    private int fgReceipeTime;
    private int fgLikes;

    private Long postFileId;        // 파일ID
    private String postFileName;    // 파일명
    private String postFileRoot;    // 파일경로
    private String postFileUuid;    // 파일UUID
}
