package com.example.moamz.domain.dto.user.seller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SellerSignupDTO {
    private Long fgUserCode;
    private String fgUserId;
    private String fgUserPassword;
    private String fgUserJoinDate;
    private String fgUserType;
    private String fgSellerName;
    private String fgSellerPhone;
    private Long fgBusinessID;
    private String fgBusinessOpenTime;
    private String fgBusinessCloseTime;
    private String fgBusinessDetail;
    private String fgBusinessPostcode;
    private String fgBusinessAddress;
    private String fgBusinessAddressDetail;
    private String fgBusinessNumber;
    private String fgBusinessName;
    private String fgBusinessPhone;
    private String fgBusinessRating;
    private String fgBusinessLikes;
}
