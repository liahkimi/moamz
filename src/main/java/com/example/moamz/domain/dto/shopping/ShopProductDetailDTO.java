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
public class ShopProductDetailDTO {
    private Long fgProductId;
    private String fgProductName;
    private int fgProductPrice;
    private int fgProductStock;
    private String fgProductWeight;
    private String fgProductContent;
    private String fgProductExpDate;
    private LocalDateTime fgProductTime;
    private String fgSubCategoryId;
    private String fgSubCategoryName;
    private Long fgBusinessId;
    private String fgBusinessName;
}
