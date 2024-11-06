package com.example.moamz.domain.dto.main;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeListDTO {
    private Long fgUserCode;
    private Long fgPostId;
    private String fgPostTitle;
    private LocalDateTime fgPostCreatedAt;
    private Long fgPostViews;
}
