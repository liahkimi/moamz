package com.example.moamz.domain.dto.admin.userMng;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminSearchDTO {
    //    판매자 회원 관리 목록
    private Long fgUserCode;  //회원번호
    private String fgUserId;  //회원id
    private String fgUserJoinDate;    //가입일
    private String fgBusinessName; // 업체명

    private double fgAverageReviewRating; //업체 평점 (NVL(AVG(r.FG_REVIEW_RATING), 0))
    private int fgLikeCount;  //업체 좋아요 수 ( COUNT(DISTINCT l.FG_LIKE_ID),)
    private int fgProductCount;   //총 상품 수 ( COUNT(p.FG_PRODUCT_ID))
    private int fgSalesCount; //총 판매건 수 9 COUNT(CASE WHEN o.FG_PAYMENT_STATUS = '결제완료' THEN o.FG_PRODUCT_ID END) )

    private int fgReviewRating; //리뷰 평점
    private Long fgLikeId;   //좋아요수 <-Long타입 맞나..?
    private Long fgProductId; //상품 id
    private String fgPaymentStatus; //상품 결제여부 -ERDCLOUD 필드명 fgOrderStats임
    private Long fgBusinessId; //업체id

    //    일반회원 관리 목록
//    private Long fgUserCode;    //회원번호
    private String fgNormalNickname;  //일반회원 닉네임
//    private String fgUserId;      //회원 id
//    private String fgUserJoinDate;    //가입일

    private int fgPointTotal;     //총 포인트 합계
    private int fgPostCount;      //총 게시글 수 (COUNT(ps.FG_POST_ID))
    private int fgPurchaseCount;  //총 구매건 수 ( COUNT(CASE WHEN o.FG_PAYMENT_STATUS='결제완료' THEN o.FG_ORDER_ID END))
    //                                    주문테이블에서 결제상테가 결제완료인것만 구매한 것으로 간주하기로 함.
    private Long fgPostId; //게시글id
//    private String fgPaymentStatus; //상품 결제여부 -ERDCLOUD 필드명 fgOrderStatus
    private Long fgOrderId; //주문(결제)id




}
