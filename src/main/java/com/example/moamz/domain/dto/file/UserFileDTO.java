package com.example.moamz.domain.dto.file;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserFileDTO {
    //
    // 회원 파일 DTO
    //

    private Long userFileId;            // 파일ID
    private String userFileName;        // 파일명
    private String userFileRoot;        // 파일경로
    private String userFileUuid;        // 파일UUID

    private Long userCode;              // 회원CODE
    private String thumbnailPath;       // 썸네일 경로

}