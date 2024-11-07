package com.example.moamz.domain.dto.mypage.normal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ShareStatusUpdateDTO {
    // 나눔 상태 변경

    private Long fgUserCode;
    private String fgSharingStatus;  // 나눔 상태 (나눔가능, 예약중, 나눔완료)
}
