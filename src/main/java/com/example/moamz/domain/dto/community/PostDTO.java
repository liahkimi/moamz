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
    private Long postId;
    private String postType;
    private String postTitle;
    private LocalDateTime createdAt;
    private int likes;
    private int views;
    private boolean isEdited;
    private Long userCode;
}
