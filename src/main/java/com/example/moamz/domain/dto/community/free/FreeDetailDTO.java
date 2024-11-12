package com.example.moamz.domain.dto.community.free;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class FreeDetailDTO {
    //
    // 자유게시판 상세 DTO
    //
    
    private Long postId;            // 게시글ID
    private Long writerCode;        // 작성자CODE
    private boolean isMyPost;       // 내 게시글인지 여부
    private String postTitle;       // 게시글 제목
    private String normalNickname;  // 작성자 닉네임
    private String postCreatedAt;   // 게시글 작성일
    private int postViews;          // 조회수
    private int postLikes;          // 좋아요수
    private String postEdit;        // 게시글 수정여부
    private String freeContent;     // 게시글 내용

    // 회원 프로필사진 정보
    private Long userFileId;        // 파일ID
    private String userFileRoot;    // 파일경로
    private String userFileUuid;    // 파일UUID
    private String userFileName;    // 파일명

}
