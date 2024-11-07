package com.example.moamz.domain.dto.mypage.normal.inquiry;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NormalInquiryWriteDTO {
    private Long fgUserCOde;
    private Long fgPostId;
    private String fgPostTitle;
    private String fgInquiryContent;
}

