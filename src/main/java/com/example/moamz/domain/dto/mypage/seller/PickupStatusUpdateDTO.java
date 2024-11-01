package com.example.moamz.domain.dto.mypage.seller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@NoArgsConstructor
public class PickupStatusUpdateDTO {
    //
    // 픽업상태 변경 DTO
    //

    private Long orderId;                // 주문 ID
    private String pickupStatus;         // 픽업 상태
    private String pickupCompletedTime;  // 픽업 완료 시간 (픽업 완료상태로 변경될 때만 update)
}
