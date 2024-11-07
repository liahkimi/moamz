package com.example.moamz.domain.dto.mypage.normal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class MyReviewDTO {
    private Long fgUserCode;
    private String fgBusinessName;
    private String fgReviewContent;
    private Long fgReviewRating;
    private String fgReviewCreatedAt;
    private String fgProductName;
}
