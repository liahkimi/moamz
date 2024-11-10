package com.example.moamz.domain.dto.community.sharing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Clob;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class SharingDetailDTO {
    //
    // 나눔게시판 상세 DTO
    //

    private Long postId;               // 게시글ID
    private Long writerCode;           // 작성자CODE
    private boolean isMyPost;          // 내 게시글인지 여부
    private String postTitle;          // 나눔글 제목
    private String normalNickname;     // 작성자 닉네임
    private String postCreateAt;       // 나눔글 작성일
    private int postViews;             // 조회수
    private String sharingContent;     // 나눔글 내용
    private String postEdit;           // 게시글 수정여부

    // 게시글 작성자 파일
    private Long userFileId;         // 파일ID
    private String userFileName;     // 파일명
    private String userFileRoot;     // 파일경로
    private String userFileUuid;     // UUID

    // 게시글 대표파일
    private Long postFileId;        // 파일ID
    private String postFileName;    // 파일명
    private String postFileRoot;     // 파일경로
    private String postFileUuid;     // UUID

}
