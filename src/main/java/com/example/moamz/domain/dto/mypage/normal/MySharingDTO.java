package com.example.moamz.domain.dto.mypage.normal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class MySharingDTO {
    private Long fgUserCode;
    private String fgPostTitle;
    private String fgPostCreatedAt;
    private String fgSharingStatus;

    // 나눔 사진 파일
    private Long fgPostFileId;            // 파일ID
    private String fgPostFileName;        // 파일명
    private String fgPostFileRoot;        // 파일경로
    private String fgPostFileUuid;        // 파일UUID
}
