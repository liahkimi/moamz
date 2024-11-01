package com.example.moamz.domain.dto.community.free;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class FreeModifyDTO {
    //
    // 자유게시판 글 수정 DTO
    //

    //private Long userCode;          // 유저CODE
    private Long postId;            // 게시글ID
    private String postTitle;       // 게시글 제목
    private String freeContent;     // 게시글 내용
}
