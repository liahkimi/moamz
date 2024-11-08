package com.example.moamz.domain.dto.mypage.normal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class WriteReviewDTO {
    private Long fgUserCode;            // 회원번호
    private String fgBusinessName;      // 업체명
    private String fgProductName;       // 상품명
    private Long fgReviewRating;        // 리뷰 별점
    private String fgReviewContent;     // 리뷰 내용
}
