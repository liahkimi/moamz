package com.example.moamz.domain.dto.admin.eco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EcoCertDetailDTO {
//    에코프젝 인증글 상세보기 (댓글은 따로)
    
    private Long fgPostId; //글 번호
    private Long fgUserCode; //작성자 회원번호
    private String fgPostTitle; //글 제목
    private String fgPostType; //글 종류
    private Long fgProjectId;    //에코프로젝트 번호

    // 회원 대표 사진
    private Long   fgPostFileId;           // 파일 ID
    private String fgPostFileRoot;         // 파일 경로
    private String fgPostFileName;        // 파일 이름
    private String fgPostFileUuid;        // 파일 UUID

    private String fgNormalNickname;    //작성자 닉네임
    private String fgPostCreatedAt;     //작성일
    private int fgPostLikes;            //글 좋아요 수
    private String fgCertContent;       //인증글 내용 (글내용에 사진 포함해서 올 수 있음)

}
