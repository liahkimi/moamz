package com.example.moamz.domain.dto.admin.notice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeModifyDTO {
//  공지사항 글 수정하기

    //게시글공통테이릅 수정
    private String fgPostEdit; // 수정 여부
    private String fgPostTitle; // 수정할 제목
    private Long fgPostId; // 게시글 ID

    //공지사항테이블 수정
    private String fgNoticeContent; // 수정할 내용
    private Long fgUserCode;  // 회원번호

}
