package com.example.moamz.domain.dto.admin.dashBoard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DashBoardAggregationDTO {
//    대시보드 상단 - 4가지 집계 부분
    private int newUserCount;         // 오늘 가입한 사용자 수
    private int totalUserCount;       // 전체 사용자 수
    private int ecoCertPostCount;     // 오늘 작성된 ecoCert 게시글 수
    private int pendingInquiryCount;   // 미답변인 문의글 수 (상태가 '0'인 문의 수)

}
