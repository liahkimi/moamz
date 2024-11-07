package com.example.moamz.domain.dto.main;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MainNoticeDetailDTO {
    private Long fgUserCode;
    private String fgPostTitle;              // 공지사항 제목
    private LocalDateTime fgPostCreatedAt;   // 작성일
    private Long fgPostViews;                // 조회수
    private Long fgPostId;                   // 공지 게시글 번호
    private String fgNoticeContent;          // 공지 내용
}
