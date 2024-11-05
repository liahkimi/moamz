package com.example.moamz.domain.dto.community.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CommunityCommentDTO {
    private Long fgCommentId;
    private Long fgPostId;
    private String fgCommentContent;
    private long fgCommonUserCode;
    private char fgCommentEdit;
    private String fgNormalName;
}
