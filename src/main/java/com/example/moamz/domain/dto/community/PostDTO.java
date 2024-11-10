package com.example.moamz.domain.dto.community;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostDTO {
    private Long fgPostId;
    private String fgPostType;
    private String fgPostTitle;
    private LocalDateTime fgPostcreatedAt;
    private int fgPostlikes;
    private int fgPostviews;
    private char fgPostEdit;
    private Long fgUserCode;
}
