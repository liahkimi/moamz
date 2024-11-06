package com.example.moamz.domain.dto.admin.eco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AdminEcoCertPointBtnDTO {
//    좋아요 가장 많은 에코프로젝트 인증글 작성자에게 포인트 지급하기

    //포인트를 지급한 사람의 회원번호도 알아야 하나..? => 관리자 회원번호?

    private Long fgUserCode; //인증글 작성자 회원번호
    private Long fgPostId;   //좋아요 가장 많은 인증글 번호
    
    private int fgPointTotal; //인증글 작성자 회원의 보유 포인트

    private Long fgPointDetailId; //포인트 상세번호
    private String fgPointReceivedDate; //포인트 지급날짜
    private int fgPointReceived; //지급받은 포인트
    private Long fgPointId; //포인트 번호



}
