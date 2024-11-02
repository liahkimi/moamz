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
    private Long postId;                // 게시글 ID
    private Long userCode;              //  회원번호
    private Long projectId;             // 에코프로젝트 ID

    private String postTitle;           // 게시글 제목
    private String normalNickname;      // 사용자 닉네임
    private String createdAt;           // 작성일
    private int postLikes;              // 좋아요 수
}
