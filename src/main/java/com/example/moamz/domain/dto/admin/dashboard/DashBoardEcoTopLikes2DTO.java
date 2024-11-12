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
public class DashBoardEcoTopLikes2DTO {
    // top 좋아요수 list
    private int fgCertPostLikes;        // 에코프젝 인증글 좋아요 수
    private String fgNormalNickname;    // 작성자의 닉네임(일반회원)
    private int topLikes; // TOP 5 좋아요 수를 저장할 필드 추가
    private int fgPostLikes;

    private long fgUserCode;    //회원번호
    private long fgProjectId;   //에코프로젝트 id
}
