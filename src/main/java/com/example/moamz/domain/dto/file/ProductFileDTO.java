package com.example.moamz.domain.dto.file;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductFileDTO {
    //
    // 상품 파일 DTO
    //

    private Long productFileId;            // 파일ID
    private String productFileName;        // 파일명
    private String productFileRoot;        // 파일경로
    private String productFileUuid;        // 파일UUID

    private Long productId;             // 상품ID
    private String thumbnailPath;       // 썸네일 경로
}
