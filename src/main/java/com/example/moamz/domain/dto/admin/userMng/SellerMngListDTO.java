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
    private Long fgUserCode;  //회원번호
    private String fgUserId;  //회원id
    private String fgUserJoinDate;    //가입일

    private double fgAverageReviewRating; //업체 평점 (NVL(AVG(r.FG_REVIEW_RATING), 0))
     private int fgLikeCount;  //업체 좋아요 수 ( COUNT(DISTINCT l.FG_LIKE_ID),)
     private int fgProductCount;   //총 상품 수 ( COUNT(p.FG_PRODUCT_ID))
     private int fgSalesCount; //총 판매건 수 9 COUNT(CASE WHEN o.FG_PAYMENT_STATUS = '결제완료' THEN o.FG_PRODUCT_ID END) )

    private int fgReviewRating; //리뷰 평점
    private Long fgLikeId;   //좋아요수 <-Long타입 맞나..?
    private Long fgProductId; //상품 id
    private String fgPaymentStatus; //상품 결제여부 -ERDCLOUD 필드명 fgOrderStats임
    private Long fgBusinessId; //업체id


}
