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
    private String fgOrderDate;
    private Long fgOrderId;
    private String fgPickupSchedule;
    private String fgPickupCompleted;
    private String fgPickupRequest;
    private String fgPickupStatus;

    // 업체 사진 파일
    private Long fgBusinessId;
    private Long fgUserFileId;            // 업체 파일ID
    private String fgUserFileRoot;        // 파일경로
    private String fgUserFileName;        // 파일명
    private String fgUserFileUuid;        // 파일UUID

    private String fgBusinessName;
    private String fgBusinessAddress;
    private String fgBusinessAddressDetail;
    private String fgBusinessOpenTime;
    private String fgBusinessCloseTime;
    private String fgBusinessPhone;

    // 상품 사진 파일
    private Long fgProductFileId;            // 상품 파일ID
    private String fgProductFileName;        // 파일명
    private String fgProductFileUuid;        // 파일UUID
    private String fgProductFileRoot;        // 파일경로

    private String fgProductName;
    private String fgProductExpDate;
    private int fgProductWeight;      // 중량(탄소감축량 계산)
    private int fgProductStock;
    //private int fgOrderQuantity;
    private int fgProductPrice;

    private int fgOrderPerPrice;
    private int fgOrderUsedPoint;
    private int fgOrderAmount;





}
