package com.example.moamz.domain.dto.mypage.normal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class MyPostRecipeDTO {
    private Long fgUserCode;
    private String fgPostTitle;

    // 사진 파일
    private Long fgPostFileId;            // 파일ID
    private String fgPostFileName;        // 파일명
    private String fgPostFileRoot;        // 파일경로
    private String fgPostFileUuid;        // 파일UUID
}
