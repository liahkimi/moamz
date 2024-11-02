package com.example.moamz.domain.dto.admin.dashBoard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DashBoardGraphDTO {
//    대시보드 하단 - 등락추이 그래프
    private int monthlyTotalOrders;  // 총 구매건수
    private int monthlyEcoCertPosts;   // 10월 에코 프로젝트 인증 게시물 수
}
