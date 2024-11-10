package com.example.moamz.domain.dto.community.sharing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class SharingModifyDTO {
    //
    // 나눔게시판 글 수정 DTO
    // 수정 가능한 항목만 넣기.. 근데 이제 다 수정 가능한..
    //

    //private Long userCode;            // 유저CODE
    private Long postId;                // 게시글ID
    private String postTitle;           // 나눔글 제목
    private String sharingContent;      // 나눔글 내용
    private Boolean fileChanged;        // 파일 변경 여부 감지 필드

}
