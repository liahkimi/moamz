package com.example.moamz.domain.dto.community.free;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class FreeCommentDTO {
    //
    // 자유게시판 댓글 DTO
    //

    private Long commentId;             // 댓글ID
    private Long userCode;              // 작성자CODE
    private Long postId;                // 게시글ID
    
    private String normalNickname;      // 작성자 닉네임
    private String commentDate;         // 댓글 작성일
    private String commentContent;      // 댓글 내용
    private String commentEdit;         // 댓글 수정 여부

}
