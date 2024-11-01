package com.example.moamz.domain.dto.community.receipe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ReceipeDetailDTO {
    private Long fgPostid;
    private String fgPostTitle;
    private Long fgCommonUser;
    private String fgNormalName;
    private String fgReceipeIngredients;
    private int fgReceipeTime;
    private String fgReceipeContent;
    private Long fgCommentId;
    private String fgCommentContent;
    private char fgCommentEdit;
}
