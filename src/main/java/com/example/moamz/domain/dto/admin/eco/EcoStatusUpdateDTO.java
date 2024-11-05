package com.example.moamz.domain.dto.admin.eco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EcoStatusUpdateDTO {
//    에코프로젝트 진행중->종료  상태변경 버튼 클릭하기

    private Long fgUserCode;      // 버튼 클릭한 회원번호(관리자)
    private String fgEcoStatus;    // 에코프로젝트 상태 (진행중/종료)
    private Long fgPostId;          //글 번호

//    종료된 에코프로젝트로 변경시키면 moamz 측에서도 종료되게 보여야 하고, 댓글 막아야 함..
//    관리자 페이지에서는 종료된 에코프젝 목록으로 옮겨지기만 하면 됨..



}
