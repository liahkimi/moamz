package com.example.moamz.domain.dto.page;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode //같은 객체인지 비교위해
public class EcoCertCriteria {
    private Long fgProjectId;
    private int page;
    private int amount;

    public EcoCertCriteria(){
        this(1, 12);
    } //1페이지에 2개씩 표시

    // 새롭게 1페이지에 몇개씩 표시할지 정할땐 여기서
    public EcoCertCriteria(int page, int amount) {
        this.page = page;
        this.amount = amount;
    }
}
