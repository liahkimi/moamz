package com.example.moamz.domain.dto.mypage.seller.inquiry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class InquiryDetailDTO {
    //
    // 관리자 문의 상세 DTO
    // 문의 게시글에 대한 내용만 있음(댓글X)
    //

    private Long postId;                // 게시글ID
    private String postTitle;           // 문의글 제목
    private String businessName;        // 업체명(내 업체명)
    private String postCreatedAt;        // 문의글 작성일
    private String inquiryContent;      // 문의글 내용
    private Long userCode;              // 회원Code

}
