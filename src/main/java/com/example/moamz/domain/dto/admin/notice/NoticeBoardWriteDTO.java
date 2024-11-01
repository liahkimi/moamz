package com.example.moamz.domain.dto.admin.notice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeBoardWriteDTO {
    private Long postId; //글 번호
    private String postType; //글 타입
    private String postTitle; //글 제목
    private String postCreatedAt; //글 작성일
    private Long userCode; //글 작성자 회원번호(관리자)
}
