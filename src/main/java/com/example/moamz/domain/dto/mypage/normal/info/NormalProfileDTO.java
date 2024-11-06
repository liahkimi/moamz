package com.example.moamz.domain.dto.mypage.normal.info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class NormalProfileDTO {
    private Long fgUserCode;            // 유저 코드
    private String fgNormalNickname;    // 회원 닉네임
    private Long fgPointId;             // 포인트 번호
    private Long fgPointTotal;          // 총 포인트
    private int totalWeight;            // 음식물 중량 누적 합계
    private Double carbonReduction;     // 탄소감축량(totalWeight 값으로 계산)
    private Double treeCount;           // 나무 수(탄소감축량으로 계산)

    private Long userFileId;            // 파일ID
    private String userFileName;        // 파일명
    private String userFileRoot;        // 파일경로
    private String userFileUuid;        // 파일UUID
}
