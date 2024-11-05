package com.example.moamz.domain.dto.admin;

import java.time.LocalDateTime;

public class adminCommentDTO {
//    관리자 페이지 공통 댓글 (에코인증글 / 회원문의글)

    private Long fgCommentId;             // 댓글ID
    private Long fgUserCode;              // 작성자CODE
    private Long fgPostId;          // 댓글이 달린 게시글 ID

    private String fgNormalNickname;      // 작성자 닉네임 (일반회원 작성자)
    private String fgUserType;      // 작성자 회원타입 (관리자 작성자 - id대신 씀)
    private LocalDateTime fgCommentDate;         // 댓글 작성일
    private String fgCommentContent;      // 댓글 내용
    private String fgCommentEdit;         // 댓글 수정 여부 (" " 또는 "수정됨")
    private String  isEdited; //댓글수정여부 case문 alias

}
