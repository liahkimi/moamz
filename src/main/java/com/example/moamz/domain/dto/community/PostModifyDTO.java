package com.example.moamz.domain.dto.community;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PostModifyDTO {
    private Long fgPostId;
    private String fgPostTitle;
}
