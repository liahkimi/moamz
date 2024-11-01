package com.example.moamz.domain.dto.admin.notice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeBoardViewDTO {
    private Long postId; //글 번호
    private String postTitle; //글 제목
    private Long userType; //글 작성자 타입(관리자)
    private String postCreatedAt;//글 작성일
    private String noticeContent;//글 내용
}
