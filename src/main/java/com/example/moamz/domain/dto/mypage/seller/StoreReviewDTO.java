package com.example.moamz.domain.dto.mypage.seller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class StoreReviewDTO {
    //
    // 업체 리뷰 DTO
    //

    private String normalNickname;      // 작성자 닉네임
    private String reviewContent;       // 리뷰 내용
    private String productName;         // 상품명
    private Double reviewRating;        // 리뷰 별점
    private String reviewCreatedAt;     // 리뷰 작성일
}
