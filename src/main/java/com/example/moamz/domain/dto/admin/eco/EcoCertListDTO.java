package com.example.moamz.domain.dto.admin.eco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EcoCertListDTO {
//  (진행중/종료된) 특정 한 에코 프로젝트의 인증글 목록 보기
    private Long fgPostId;                // 게시글 ID
    private Long fgUserCode;              //  회원번호
    private Long fgProjectId;             // 에코프로젝트 ID

    private String fgPostTitle;           // 게시글 제목
    private String fgNormalNickname;      // 사용자 닉네임
    private String fgPostCreatedAt;           // 작성일
    private int fgPostLikes;              // 좋아요 수

    private String fgPostType; //글 종류
}
