package com.example.moamz.domain.dto.community.ecoproject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EcoProjectListDTO {
    private Long fgPostId;
    private Long fgPostFileid;
    private String fgPostTitle;
    private String fgEcoInfo;
    private LocalDateTime fgEcoStart;
    private LocalDateTime fgEcoEnd;
    private String fgEcoParticipation;
    private String fgCertInfo;
    private int fgPostLikes;
    private int fgEcoPoints;
    private char fgEcoStatus;
    private String formattedEcoStart;
    private String formattedEcoEnd;
    private int fgEcoDaysElapsed;
}
