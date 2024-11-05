package com.example.moamz.domain.dto.admin.page;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@EqualsAndHashCode
public class Criteria {
    private int page; //현재 사용자가 보고 있는 페이지 번호
    private int amount; //한 페이지에 표시할 게시글의 수

    public Criteria(){
        this(1, 3);
    }

    public Criteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }
}
