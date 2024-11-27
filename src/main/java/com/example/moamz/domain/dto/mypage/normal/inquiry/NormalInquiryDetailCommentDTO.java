package com.example.moamz.domain.dto.mypage.normal.inquiry;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NormalInquiryDetailCommentDTO {
//    private Long fgUserCode;
//    private Long fgCommentId;
    private Long fgPostId;
    private String fgCommentDate;
    private String fgCommentContent;
    private String fgCommentEdit;
}
