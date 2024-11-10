package com.example.moamz.domain.dto.admin.eco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminEcoWriteDTO {
//    에코프로젝트 작성하기 insert dto

//    // 썸네일 - 게시글파일관리테이블 isnert <- file>PostFileDTO로 처리 예정
    private Long   postFileId;           // 파일 ID
    private String postFileRoot;         // 파일 경로
    private String postFileName;         // 파일 이름
    private String postFileUuid;         // 파일 UUID

    //공통게시글 테이블 insert
    private Long fgPostId;                  // 게시글 ID
    private String fgPostType;               // 게시글 타입
    private String fgPostTitle;          // 에코 프로젝트 제목
    private String fgPostCreatedAt;          //글 작성일
    private Long fgUserCode;                 //글 작성자 회원번호(관리자)

    //에코프로젝트 테이블 insert
//    private String fgEcoStart;           // 시작일
//    private String fgEcoEnd;             // 종료일
    private LocalDateTime fgEcoStart;  // 또는 LocalDate
    private LocalDateTime fgEcoEnd;    // 또는 LocalDate
    private String fgEcoParticipation;     // 참여횟수
    private String fgEcoInfo;          // 프로젝트 소개
    private String fgCertInfo;         // 인증 사항
    private int fgEcoPoints;           // 지급할 포인트


}
