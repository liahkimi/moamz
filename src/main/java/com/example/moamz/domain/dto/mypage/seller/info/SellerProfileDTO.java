package com.example.moamz.domain.dto.mypage.seller.info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class SellerProfileDTO {
    //
    // 판매자 회원 프로필 DTO
    //

    private Long businessId;
    private String isTopBusiness;      // 우수 업체 여부
    private String businessName;        // 업체명
    private Double businessRating;      // 업체 평점
    private int totalWeight;            // 음식물 중량 누적 합계
    private Double totalWeightToKg;     // 음식물 중량 합계 kg 단위로 변환
    private Double carbonReduction;     // 탄소감축량(totalWeight 값으로 계산)
    private Double treeCount;           // 나무 수(탄소감축량으로 계산)

    private Long userFileId;            // 파일ID
    private String userFileName;        // 파일명
    private String userFileRoot;        // 파일경로
    private String userFileUuid;        // 파일UUID


}
