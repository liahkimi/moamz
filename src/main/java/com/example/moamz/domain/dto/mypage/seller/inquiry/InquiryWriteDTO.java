package com.example.moamz.domain.dto.mypage.seller.inquiry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class InquiryWriteDTO {
    //
    // 관리자 문의 글 작성 DTO
    //

    private Long postId;                // 게시글ID
    private String postTitle;           // 문의글 제목
    private String inquiryContent;      // 문의글 내용
    private Long userCode;              // 작성자CODE

}
