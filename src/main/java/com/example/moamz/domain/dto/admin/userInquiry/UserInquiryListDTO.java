package com.example.moamz.domain.dto.admin.userInquiry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserInquiryListDTO {
//   일반회원 문의목록 (미확인/답변완료 공통)
    private String postTitle;   //문의글 제목
    private String normalNickname;  //일반회원 닉네임
    private String postCreatedAt;   //글 작성일
    private String inquiryStatus; // 답변 상태
}
