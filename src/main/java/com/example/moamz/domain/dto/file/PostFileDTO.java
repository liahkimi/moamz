package com.example.moamz.domain.dto.file;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostFileDTO {
    //
    // 게시글 파일 DTO
    //

    private Long postFileId;            // 파일ID
    private String postFileName;        // 파일명
    private String postFileRoot;        // 파일경로
    private String postFileUuid;        // 파일UUID

    private Long postId;                // 게시글ID
    private String thumbnailPath;       // 썸네일 경로
}
