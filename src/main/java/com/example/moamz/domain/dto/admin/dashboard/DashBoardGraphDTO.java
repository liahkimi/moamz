package com.example.moamz.domain.dto.admin.dashboard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DashBoardGraphDTO {
//    대시보드 하단 - 등락추이 그래프

    // 월별 총 구매건 수
    private int  orderMonth;
    private int monthlyTotalOrders;

    // 월별 총 인증글 수
    private int postMonth;
    private int monthlyEcoCertPosts;

    // 공통으로 where절에 들어가는 필드
    private long fgProductId; //상품 id
    private String fgPaymentStatus; //결제상태
    private LocalDateTime fgOrderDate; //주문일


}
