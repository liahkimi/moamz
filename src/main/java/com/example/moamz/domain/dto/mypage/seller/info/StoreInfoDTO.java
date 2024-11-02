package com.example.moamz.domain.dto.mypage.seller.info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class StoreInfoDTO {
    //
    // 업체 정보 DTO
    // 정보 수정 페이지에서 이 내용들 보여짐
    //

    private Long userCode;          // 회원CODE (수정불가)
    private String businessName;    // 업체명 (수정불가)
    private String businessNumber;  // 사업자번호 (수정불가)
    private String postcode;        // 우편번호
    private String address;         // 업체주소
    private String addressDetail;   // 상세주소
    private String businessPhone;   // 업체 대표번호
    private String openTime;        // 오픈시간
    private String closeTime;       // 마감시간
    private String businessDetail;  // 업체 상세정보

    private Long userFileId;         // 파일ID
    private String userFileName;     // 파일명
    private String userFileRoot;     // 파일경로
    private String userFileUuid;     // UUID
}
