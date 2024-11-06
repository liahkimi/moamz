package com.example.moamz.domain.dto.admin.notice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminNoticeDetailDTO {
//    공지사항 상세보기
    private Long fgPostId; //글 번호
    private String fgPostTitle; //글 제목
    private String fgUserType; //글 작성자 타입(관리자)
    private String fgPostCreatedAt;//글 작성일
    private String fgNoticeContent;//글 내용
    private int fgPostViews; //글 조회수

    private Long fgUserCode;  // 회원번호
    private String fgPostType; // 글 종류
}
