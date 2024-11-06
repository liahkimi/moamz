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
public class EcoCertListDTO {
    private Long fgPostId;
    private Long fgProjectId;
    private Long fgCommonUserCode;
    private String fgNormalName;
    private String fgPostTitle;
    private LocalDateTime fgPostCreatedAt;
    private int fgPostCommentCount;
    private int fgPostViews;
    private int fgPostLikes;
}
