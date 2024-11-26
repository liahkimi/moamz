package com.example.moamz.domain.dto.admin.userMng;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserMngListDTO {
//    일반회원 관리 목록
    private Long fgUserCode;    //회원번호
    private String fgNormalNickname;  //일반회원 닉네임
    private String fgUserId;      //회원 id
    private String fgUserJoinDate;    //가입일

    private int fgPointTotal;     //총 포인트 합계 
    private int fgPostCount;      //총 게시글 수 (COUNT(ps.FG_POST_ID))
    private int fgPurchaseCount;  //총 구매건 수 ( COUNT(CASE WHEN o.FG_PAYMENT_STATUS='결제완료' THEN o.FG_ORDER_ID END))
//                                    주문테이블에서 결제상테가 결제완료인것만 구매한 것으로 간주하기로 함.
    private Long fgPostId; //게시글id
    private String fgPaymentStatus; //상품 결제여부 -ERDCLOUD 필드명 fgOrderStatus
    private Long fgOrderId; //주문(결제)id


    

}
