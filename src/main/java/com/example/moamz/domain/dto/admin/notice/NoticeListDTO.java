package com.example.moamz.domain.dto.admin.notice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeListDTO {
//    공지사항 목록 보여주기
    private Long postId;//글 번호
    private String postTitle;//글 제목
    private String postCreatedAt;//글 작성일
    private int postViews;//글 조회수
}
