package com.example.moamz.domain.dto.mypage.seller.inquiry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class InquiryListDTO {
    //
    // 관리자 문의 목록 DTO
    //

    private Long postId;            // 게시글ID
    private String postTitle;       // 문의글 제목
    private String postCreatedAt;    // 문의글 작성일
    private String inquiryStatus;   // 답변 상태
    private Long userCode;          // 사용자CODE
}
