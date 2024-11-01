package com.example.moamz.domain.dto.community.sharing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class SharingListDTO {
    //
    // 나눔게시판 목록 DTO
    //

    private Long postId;            // 게시글ID
    private String postTitle;       // 나눔글 제목
    private String normalNickname;  // 작성자 닉네임
    private String sharingStatus;   // 나눔상태

    private Long postFileId;        // 파일ID
    private String postFileName;    // 파일명
    private String postFileRoot;    // 파일경로
    private String postFileUuid;    // 파일UUID
}
