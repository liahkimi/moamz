package com.example.moamz.domain.dto.shopping;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StoreListDTO {
    private Long fgBusinessId;
    private String fgBusinessName;
    private String fgBusinessAddress;
    private String fgBusinessPhone;
    private String fgBusinessAddressDetail;
    private String fgBusinessDetail;
}
