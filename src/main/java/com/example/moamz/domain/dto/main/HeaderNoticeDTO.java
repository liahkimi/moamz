package com.example.moamz.domain.dto.main;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class HeaderNoticeDTO {
    private Long fgUserCode;
    private String fgProductName;
    private String fgPickupStatus;

    // 상품 사진 파일
    private Long productFileId;            // 파일ID
    private String productFileName;        // 파일명
    private String productFileRoot;        // 파일경로
    private String productFileUuid;        // 파일UUID
}
