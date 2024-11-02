package com.example.moamz.domain.dto.admin.userMng;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SellerMngListDTO {
//    판매자 회원 관리 목록
    private Long userCode;  //회원번호
    private String userId;  //회원id
    private String userJoinDate;    //가입일
    private double averageReviewRating; //업체 평점
    private int likeCount;  //업체 좋아요 수
    private int productCount;   //총 상품 수
    private int salesCount; //총 판매건 수
}
