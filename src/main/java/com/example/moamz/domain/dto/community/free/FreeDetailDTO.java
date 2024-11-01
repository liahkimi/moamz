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
    // 자유게시판 상세 DTO (댓글X)
    //
    
    private Long postId;            // 게시글ID
    private Long userCode;          // 유저ID
    private String postTitle;       // 게시글 제목
    private String normalNickname;  // 작성자 닉네임
    private String postCreatedAt;   // 게시글 작성일
    private int postViews;          // 조회수
    private int postLikes;          // 좋아요수
    private String postEdit;        // 게시글 수정여부
    private String freeContent;     // 게시글 내용
    
}
