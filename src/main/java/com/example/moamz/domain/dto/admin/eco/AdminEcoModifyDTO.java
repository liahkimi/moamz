package com.example.moamz.domain.dto.admin.eco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminEcoModifyDTO {
    
    private Long fgUserCode;      // 작성자 회원번호
    
    // 공통게시글 테이블 수정 필드
    private String fgPostEdit; //게시글 수정여부
    private Long fgPostId; //게시글 번호
    private String fgPostTitle; //게시글 제목

    // 에코프로젝트 테이블 수정 필드
    private String fgEcoStart; //시작일
    private String fgEcoEnd;    //종료일
    private String fgEcoInfo;   //프로젝트 소개
    private String fgCertInfo;  //인증사항
    private String fgEcoParticipation; // 참여횟수

    // 대표 사진 수정 필드 <-file>PostFileDTO로 파일 삭제한뒤 새로 insert 예정
    private String fgPostFileName;
    private String fgPostFileRoot;
    private String fgPostFileUuid;

}
