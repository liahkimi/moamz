package com.example.moamz.domain.dto.shopping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CartDetailDTO {
    private Long fgCartDetailId;
    private int fgCartDetailQuantity;
    private Long fgProductId;
    private Long fgCartId;
}
