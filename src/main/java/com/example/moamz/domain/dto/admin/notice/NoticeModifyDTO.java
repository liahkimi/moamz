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
    private Long postId; // 게시글 ID
    private String postTitle; // 수정할 제목
    private String postContent; // 수정할 내용
    private String postEdit; // 수정 여부
}
