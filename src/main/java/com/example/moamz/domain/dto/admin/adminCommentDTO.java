package com.example.moamz.domain.dto.admin;

public class adminCommentDTO {
//    관리자 페이지 공통 댓글 (에코인증글 / 회원문의글)

    private Long commentId;             // 댓글ID
    private Long userCode;              // 작성자CODE
    private Long postId;          // 댓글이 달린 게시글 ID

    private String normalNickname;      // 작성자 닉네임 (일반회원 작성자)
    private String userType;      // 작성자 회원타입 (관리자 작성자 - id대신 씀)
    private String commentDate;         // 댓글 작성일
    private String commentContent;      // 댓글 내용
    private String commentEdit;         // 댓글 수정 여부 (" " 또는 "수정됨")


}
