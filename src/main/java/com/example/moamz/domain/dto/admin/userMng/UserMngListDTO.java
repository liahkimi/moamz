package com.example.moamz.domain.dto.admin.userMng;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserMngListDTO {
//    일반회원 관리 목록
    private Long userCode;    //회원번호
    private String normalNickname;  //일반회원 닉네임
    private String userId;      //회원 id
    private String userJoinDate;    //가입일
    private int pointTotal;     //총 포인트 합계
    private int postCount;      //총 게시글 수
    private int purchaseCount;  //총 구매건 수
}
