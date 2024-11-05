package com.example.moamz.domain.dto.mypage.seller.inquiry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class InquiryCommentDTO {
    //
    // 관리자 문의 상세 댓글 DTO
    //

    private Long postId;
    private String commentDate;     // 댓글 작성일
    private String commentContent;  // 댓글 내용
    private String commentEdit;     // 수정 여부 (수정됨 여부)

    // 테스트 코드 위한 생성자
    public InquiryCommentDTO(String s, String thisIsAComment, String space) {
    }
}
