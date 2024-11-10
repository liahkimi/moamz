package com.example.moamz.domain.dto.user.seller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SellerBusinessDTO {
    private Long fgBusinessId;
    private String fgBusinessOpenTime;
    private String fgBusinessCloseTime;
    private String fgBusinessDetail;
    private String fgBusinessPostcode;
    private String fgBusinessAddress;
    private String fgBusinessAddressDetail;
    private String fgBusinessNumber;
    private String fgBusinessName;
    private String fgBusinessPhone;
    private Long fgUserCode;
}
