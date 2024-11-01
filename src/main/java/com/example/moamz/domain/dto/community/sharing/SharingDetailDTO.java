package com.example.moamz.domain.dto.community.sharing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class SharingDetailDTO {
    //
    // 나눔게시판 상세 DTO
    //

    private Long postId;               // 게시글ID
    private Long userCode;             // 회원CODE
    private String postTitle;          // 나눔글 제목
    private String normalNickname;         // 작성자 닉네임
    private String postCreateAt;       // 나눔글 작성일
    private int postViews;             // 조회수
    private String sharingContent;     // 나눔글 내용
    private String postEdit;           // 게시글 수정여부

}
