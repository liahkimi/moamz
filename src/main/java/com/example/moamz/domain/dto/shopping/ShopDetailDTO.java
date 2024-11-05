package com.example.moamz.domain.dto.shopping;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ShopDetailDTO {
    private Long fgBusinessId;
    private String fgBusinessName;
    private String fgBusinessAddress;
    private String fgBusinessAddressDetail;
    private String fgBusinessPhone;
    private String fgBusinessRationg;
    private String fgBusinessLikes;
}
