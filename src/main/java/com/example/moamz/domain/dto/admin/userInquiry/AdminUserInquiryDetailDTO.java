package com.example.moamz.domain.dto.admin.userInquiry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminUserInquiryDetailDTO {
//  일반회원 문의글 상세보기  (미확인/답변완료 공통) -댓글은 따로..
    private Long fgPostId;                  // 게시글ID
    private Long fgUserCode;                //  회원번호

    private String fgPostTitle;             // 제목
    //작성자 프로필 사진
    private Long fgUserFileId;            // 작성자 플필사진 id
    private String fgUserFileRoot;          // 작성자 플필사진 파일경로
    private String fgUserFileName;          // 작성자 플필사진 파일이름
    private String fgUserFileUuid;          // 작성자 플필사진 파일UUID
    private String fgNormalNickname;         // 작성자 닉네임(일반회원)
    private String fgPostCreatedAt;           // 작성일
    private String fgInquiryStatus;          // 문의글 상태 (미확인/답변완료)
    private String fgInquiryContent;         // 글 내용
}
