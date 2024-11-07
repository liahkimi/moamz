package com.example.moamz.domain.dto.mypage.normal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class WriteReviewInsertDTO {
    private Long fgUserCode;            // 회원번호
    private Long fgReviewId;            // 리뷰 id
    private Long fgBusinessId;          // 업체번호
    private Long fgOrderId;             // 주문 id

}
