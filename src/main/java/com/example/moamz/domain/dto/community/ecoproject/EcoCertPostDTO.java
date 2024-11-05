package com.example.moamz.domain.dto.community.ecoproject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EcoCertPostDTO {
    private Long fgPostId;
    private String fgPostType;
    private String fgPostTitle;
    private LocalDateTime fgPostCreatedAt;
    private int fgPostLikes;
    private int fgPostViews;
    private Long fgUserCode;
}
