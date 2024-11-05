package com.example.moamz.domain.dto.admin.notice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeWriteDTO {
//    공지사항 글 작성하기

    //공통게시글테이블 insert
    private Long fgPostId; //글 번호
    private String fgPostType; //글 타입
    private String fgPostTitle; //글 제목
    private String fgPostCreatedAt; //글 작성일
    private Long fgUserCode; //글 작성자 회원번호(관리자)

    //공지사항테이블 insert
    private String fgNoticeContent; //공지사항 내용
}
