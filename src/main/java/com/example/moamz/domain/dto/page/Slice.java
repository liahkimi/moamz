package com.example.moamz.domain.dto.page;

import lombok.*;

import java.util.List;

@Setter @Getter @NoArgsConstructor
@AllArgsConstructor
public class Slice<T> {
    //
    // 현재 페이지의 데이터 내용(목록),
    // 다음 페이지가 있는지 여부를 담는 DTO
    //

    boolean hasNext;            // 다음페이지 존재 여부 (true -> 더 불러올 데이터가 있다)
    List<T> contentList;        // 현재 페이지의 데이터 목록
}