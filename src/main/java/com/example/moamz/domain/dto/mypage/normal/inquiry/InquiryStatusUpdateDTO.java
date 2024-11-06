package com.example.moamz.domain.dto.mypage.normal.inquiry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class InquiryStatusUpdateDTO {

    // 관리자 문의 내역 답변 상태 변경

    private String fgPostId;
    private String fgInquiryStatus;
}
