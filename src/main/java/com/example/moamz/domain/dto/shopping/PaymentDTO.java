package com.example.moamz.domain.dto.shopping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PaymentDTO {
    private Long fgOrderId;
    private Long fgProductId;
    private int fgProductQuantity;
    private int fgProductPrice;
    private String fgBusinessId;
    private String fgBusinessName;
    private String fgBusinessAddress;
    private String fgBusinessAddressDetail;
    private String fgPickUpSechedule;
    private Long fgUserCode;
    private int fgOrderAmount;
}
