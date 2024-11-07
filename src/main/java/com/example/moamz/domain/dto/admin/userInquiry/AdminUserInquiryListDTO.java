package com.example.moamz.domain.dto.admin.userInquiry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminUserInquiryListDTO {
//   일반회원 문의목록 (미확인/답변완료 공통)
    private String fgPostTitle;   //문의글 제목
    private String fgNormalNickname;  //일반회원 닉네임
    private String fgPostCreatedAt;   //글 작성일

    private Long fgPostId;                  // 게시글ID
    private Long fgUserCode;                //  회원번호
    private String fgInquiryStatus; // 답변 상태
}
