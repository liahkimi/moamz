package com.example.moamz.domain.dto.admin.sellerInquiry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminSellerInquiryListDTO {
//   판매자 문의목록 (미확인/답변완료 공통)
    private String fgPostTitle;   //문의글 제목
    private String fgUserId;  //판매자 id
    private String fgBusinessName;    //업체명
    private String fgPostCreatedAt;   //글 작성일

    private Long fgPostId;                  // 게시글ID
    private Long fgUserCode;                //  회원번호
    private String fgInquiryStatus; // 답변 상태


}
