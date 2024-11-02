package com.example.moamz.domain.dto.admin.eco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EcoWriteDTO {
//    에코프로젝트 작성하기 insert dto

    // 썸네일 <- 파일처리..어떻게 할지
    private Long   postFileId;           // 파일 ID
    private String postFileRoot;         // 파일 경로
    private String postFileName;         // 파일 이름
    private String postFileUuid;         // 파일 UUID

    private Long postId;                  // 게시글 ID
    private String postType;               // 게시글 타입
    private String postCreatedAt;          //글 작성일
    private Long userCode;                 //글 작성자 회원번호(관리자)

    private String postTitle;          // 에코 프로젝트 제목
    private String ecoStart;           // 시작일
    private String ecoEnd;             // 종료일
    private String participation;     // 참여횟수
    private String ecoInfo;          // 프로젝트 소개
    private String certInfo;         // 인증 사항
    private int ecoPoints;           // 지급할 포인트



}
