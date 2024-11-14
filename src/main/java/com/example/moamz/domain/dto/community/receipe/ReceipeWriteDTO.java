package com.example.moamz.domain.dto.community.receipe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReceipeWriteDTO {
    private Long fgPostId;
    private String fgPostType;
    private Long fgUserCode;
    private String fgPostTitle;
    private String fgReceipeContent;
    private String fgReceipeIngredients;
    private LocalDateTime fgPostCreatedAt;
    private String fgReceipeTime;
    private char fgPostEdit;
}
