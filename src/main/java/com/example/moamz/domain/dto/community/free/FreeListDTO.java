package com.example.moamz.domain.dto.community.free;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class FreeListDTO {
    //
    // 자유게시판 글 목록 DTO
    //

    private Long postId;            // 게시글ID
    private String postTitle;       // 게시글 제목
    private String normalNickname;  // 작성자 닉네임
    private String postCreateAt;    // 게시글 작성일
    private int postViews;          // 조회수
    private int postLikes;          // 좋아요수
    private int commentCount;       // 댓글수

}
