package com.example.moamz.domain.dto.community;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class CommentDTO {
    //
    // 자유게시판 댓글 DTO
    //

    private Long fgCommentId;             // 댓글ID
    private Long fgUserCode;              // 작성자CODE
    private Long fgPostId;                // 게시글ID
    
    private String fgNormalNickname;      // 작성자 닉네임
    private String fgCommentDate;         // 댓글 작성일
    private String fgCommentContent;      // 댓글 내용
    private String fgCommentEdit;         // 댓글 수정 여부


}
