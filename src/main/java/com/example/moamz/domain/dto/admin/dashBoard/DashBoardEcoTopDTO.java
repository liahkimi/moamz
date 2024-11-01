package com.example.moamz.domain.dto.admin.dashBoard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DashBoardEcoTopDTO {
    // 대표사진
    private Long   postFileId;           // 파일 ID
    private String postFileRoot;         // 파일 경로
    private String postFileName;         // 파일 이름
    private String postFileUuid;         // 파일 UUID

    // 에코프젝 정보
    private String postTitle;            // 에코프젝 제목
    private int postLikes;               // 에코프젝 좋아요 수
    private String ecoStart;             // 에코 프로젝트 시작일
    private String ecoEnd;               // 에코 프로젝트 종료일
    private int ecoPoints;               // 에코 프로젝트 포인트
    private int ecoParticipation;        // 에코 프로젝트 참여 수

    // top 좋아요수 list
    private int certPostLikes;        // 에코프젝 인증글 좋아요 수
    private String normalNickname;    // 작성자의 닉네임
}
