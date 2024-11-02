package com.example.moamz.domain.dto.admin.eco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EcoListDTO {
//  (진행중/완료된) 에코프로젝트 목록 DTO

    // 썸네일 <- 파일처리..어떻게 할지
    private Long   postFileId;           // 파일 ID
    private String postFileRoot;         // 파일 경로
    private String postFileName;         // 파일 이름
    private String postFileUuid;         // 파일 UUID

    private String EcoStatus;             // 에코 프로젝트 종료 여부 (진행중 / 종료)
    private Long postId;                  // 게시글 ID

    private String postTitle;              // 에코 프로젝트 제목
    private int postLikes;                 // 에코 프로젝트 좋아요 수
    private String ecoStart;               // 에코 프로젝트 시작일
    private String ecoEnd;                 // 에코 프로젝트 종료일
    private int ecoPoints;                 // 에코 프로젝트 지급될 포인트
    private String ecoInfo;                // 에코 프로젝트 소개
    private String certInfo;               // 에코 프로젝트 인증사항
    private String ecoParticipation;        // 에코 프로젝트 참여횟수

}
