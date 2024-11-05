package com.example.moamz.domain.dto.shopping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PickupDTO {
    private Long fgPickupId;
    private String fgPickupSchedule;
    private String fgPickupRequest;
    private String fgPickupStatus;
    private Long fgOrderId;
}
