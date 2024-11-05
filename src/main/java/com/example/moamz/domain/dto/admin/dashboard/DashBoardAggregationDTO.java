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
public class DashBoardAggregationDTO {
//    대시보드 상단 - 4가지 집계 부분

    // 오늘 가입한 회원 수
    private int newUserCount; // 오늘가입회원수 count문 alias
    private LocalDateTime fgUserJoinDate; //회원가입일

    // 총 회원 수
    private int totalUserCount;// 총회원수 count문 alias
    private Long fgUserCode; //회원번호

    //오늘 에코프로젝트 인증글 수
    private int ecoCertPostCount; // 오늘에코프젝인증글수 count문 alias
    private LocalDateTime fgPostCreatedAt; // 게시글 등록일
    private String fgPostType; //게시글 타입


    // 미해결된 문의글 수
    private int pendingInquiryCount; // 미해결된 문의글수 count문 alias
    private String fgInquiryStatus;

}
