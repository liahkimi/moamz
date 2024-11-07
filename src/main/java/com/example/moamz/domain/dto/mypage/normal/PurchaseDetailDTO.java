package com.example.moamz.domain.dto.mypage.normal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@NoArgsConstructor
public class PurchaseDetailDTO {
    private Long fgUserCode;
    private LocalDateTime fgOrderDate;
    private Long fgOrderId;
    private LocalDateTime fgPickupSchedule;
    private LocalDateTime fgPickupCompleted;
    private String fgPickupRequest;
    private String fgPickupStatus;

    private String fgBusinessName;
    private String fgBusinessAddress;
    private String fgBusinessAddressDetail;
    private String fgBusinessOpenTime;
    private String fgBusinessPhone;

    private String fgProductName;
    private LocalDateTime fgProductExpDate;
    private int productWeight;      // 중량(탄소감축량 계산)
    private Long fgOrderQuantity;
    private Long fgProductPrice;

    private Long fgOrderPerPrice;
    private Long fgOrderUsedPoint;
    private Long fgOrderAmount;

    // 상품 사진 파일
    private Long fgProductFileId;            // 상품 파일ID
    private String fgProductFileName;        // 파일명
    private String fgProductFileRoot;        // 파일경로
    private String fgProductFileUuid;        // 파일UUID


    // 업체 사진 파일
    private Long fgBusinessId;
    private Long fgUserFileId;            // 업체 파일ID
    private String fgUserFileName;        // 파일명
    private String fgUserFileRoot;        // 파일경로
    private String fgUserFileUuid;        // 파일UUID

}
