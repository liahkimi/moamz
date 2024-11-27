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
    private int fgPointTotal;          // 총 포인트 //Long -> int 변경 문제시 다시 넣을 것
    private int totalWeight;            // 음식물 중량 누적 합계
    private Double carbonReduction;     // 탄소감축량(totalWeight 값으로 계산)
    private Double treeCount;           // 나무 수(탄소감축량으로 계산)

    private Long fgUserFileId;            // 파일ID
    private String fgUserFileName;        // 파일명
    private String fgUserFileRoot;        // 파일경로
    private String fgUserFileUuid;        // 파일UUID
}
