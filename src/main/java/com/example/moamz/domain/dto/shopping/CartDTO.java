package com.example.moamz.domain.dto.shopping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

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
    private LocalDateTime fgProductExpTime;
    private String ProductFileName;
    private String ProductFileRoot;
    private String ProductFileUuid;
    private Long fgCartDetailId;
}
