package com.example.moamz.domain.dto.shopping;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReviewDTO {
    private Long fgReviewId;
    private Long fgOrderId;
    private Long fgBusinessId;
    private Long fgUserCode;
    private String fgNormalName;
    private String fgReviewContent;
    private LocalDateTime fgReviewCreatedAt;
}
