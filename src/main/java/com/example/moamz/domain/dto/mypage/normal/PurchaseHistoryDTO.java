package com.example.moamz.domain.dto.mypage.normal;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @ToString
@AllArgsConstructor
public class PurchaseHistoryDTO {
//    private LocalDateTime fgOrderDate;      // 주문 날짜
//    private String fgProductFilePath;       // 상품 사진 경로 (파일 루트 + 파일명)
    private String fgProductName;           // 상품명
    private Long fgProductPrice;            // 상품 가격
    private String fgPickupSchedule;        // 픽업 예정 시간
    private String fgBusinessName;          // 업체명
    private String fgPickupRequest;         // 요청 사항
    private String fgPickupStatus;          // 픽업 여부



    // 상품 사진 파일
    private Long fgProductFileId;            // 상품 파일ID
//    private String fgProductFileName;        // 파일명
//    private String fgProductFileRoot;        // 파일경로
//    private String fgProductFileUuid;        // 파일UUID


}

