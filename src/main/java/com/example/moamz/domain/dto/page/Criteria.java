package com.example.moamz.domain.dto.page;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@EqualsAndHashCode //같은 객체인지 비교위해
public class Criteria {
    private int page; //현재 사용자가 보고 있는 페이지 번호
    private int amount; //한 페이지 당 게시물 수

    //기본 생성자
    public Criteria(){
        this(1, 12);
    } //1페이지에 2개씩 표시

    // 새롭게 1페이지에 몇개씩 표시할지 정할땐 여기서
    public Criteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }
}
