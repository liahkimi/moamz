package com.example.moamz.domain.dto.admin.dashboard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DashBoardEcoTop2DTO {
    //    대시보드 중앙 - 에코프로젝트배너 + 에코프로젝트 인증글 좋아요 top5리스트 부분

    // 썸네일
    private Long   fgPostFileId;           // 파일 ID
    private String fgPostFileRoot;         // 파일 경로
    private String fgPostFileName;         // 파일 이름
    private String fgPostFileUuid;         // 파일 UUID

    // 에코프젝 정보
    private String fgPostTitle;            // 에코프젝 제목
    private int fgPostLikes;               // 에코프젝 좋아요 수
    private String fgEcoStart;             // 에코 프로젝트 시작일
    private String fgEcoEnd;               // 에코 프로젝트 종료일
    private int fgEcoPoints;               // 에코 프로젝트 포인트
    private String fgEcoParticipation;        // 에코 프로젝트 참여 수

    private Long fgPostId;              //게시글 번호
    private String fgPostType;          //게시글 종류
    private String fgEcoStatus;         //에코프로젝트 상태

    // top 좋아요수 list
    private int fgCertPostLikes;        // 에코프젝 인증글 좋아요 수
    private String fgNormalNickname;    // 작성자의 닉네임(일반회원)
    private List<DashBoardEcoTopDTO> topLikes; // TOP 5 좋아요 수를 저장할 필드 추가

    private long fgUserCode;    //회원번호
    private long fgProjectId;   //에코프로젝트 id
}
