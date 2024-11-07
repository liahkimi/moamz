package com.example.moamz.domain.dto.admin.eco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminEcoListDTO {
//  (진행중/완료된) 에코프로젝트 목록 DTO

    // 썸네일 보여주기
    private Long   fgPostFileId;           // 파일 ID
    private String fgPostFileRoot;         // 파일 경로
    private String fgPostFileName;        // 파일 이름
    private String fgPostFileUuid;        // 파일 UUID

    private String fgPostTitle;            // 에코 프로젝트 제목
    private int fgPostLikes;                // 에코 프로젝트 좋아요 수
    private LocalDateTime fgEcoStart;               // 에코 프로젝트 시작일
    private LocalDateTime fgEcoEnd;                 // 에코 프로젝트 종료일
    private int fgEcoPeriod;                    //에코 기간(몇일)
    private int fgEcoPoints;                 // 에코 프로젝트 지급될 포인트
    private String fgEcoInfo;                // 에코 프로젝트 소개
    private String fgCertInfo;              // 에코 프로젝트 인증사항
    private int fgEcoParticipation;        // 에코 프로젝트 참여횟수

    private String fgEcoStatus;             // 에코 프로젝트 종료 여부 (진행중 / 종료)
    private Long fgPostId;                  // 게시글 ID
    private String fgPostType; //글 종류


}
