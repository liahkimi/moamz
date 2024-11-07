package com.example.moamz.domain.dto.admin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminInquiryStatusUpdateDTO {
//    회원/판매자 문의글 답변상태 변경버튼 DTO

    private Long fgPostId;           // 문의글 ID
    private String fgInquiryStatus;  // 문의 상태 (미확인->답변완료)

    private Long fgUserCode;              // 변경버튼 누른 회원번호(관리자)
}
