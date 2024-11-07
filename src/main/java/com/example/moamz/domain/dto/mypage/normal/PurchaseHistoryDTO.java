package com.example.moamz.domain.dto.mypage.normal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class PurchaseHistoryDTO {
    private Long fgUserCode;
    private String fgProductName;
    private Long fgProductPrice;
    private String fgPickupCompleted;
    private String fgBusinessName;
    private String fgPickupRequest;
    private String fgPickupStatus;

    // 상품 사진 파일
    private Long fgProductFileId;            // 상품 파일ID
    private String fgProductFileName;        // 파일명
    private String fgProductFileRoot;        // 파일경로
    private String fgProductFileUuid;        // 파일UUID
}

