package com.example.moamz.domain.dto.mypage.seller.info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class StoreModifyDTO {
    private Long userCode;             // 회원 CODE
    private String postcode;           // 우편번호
    private String address;            // 업체주소
    private String addressDetail;      // 상세주소
    private String businessPhone;      // 업체 대표번호
    private String openTime;           // 오픈시간
    private String closeTime;          // 마감시간
    private String businessDetail;     // 업체 상세정보
}
