package com.example.moamz.domain.dto.shopping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CartDTO {
    private Long fgCartId;
    private Long fgUserCode;
    private String fgNormalName;
    private Long fgProductId;
    private String fgProductName;
    private int fgProductPrice;
    private String fgProductWeight;
    private String fgProductExpTime;
    private String fgProductFileName;
    private String fgProductFileRoot;
    private String fgProductFileUuid;
    private Long fgCartDetailId;
}
