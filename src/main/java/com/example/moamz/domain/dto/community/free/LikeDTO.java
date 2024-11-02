package com.example.moamz.domain.dto.community.free;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class LikeDTO {
    //
    // 자유게시판 좋아요 DTO
    //

    private Long userCode;    // 사용자CODE
    private Long postId;      // 게시물ID
    private boolean isLiked;  // 좋아요 여부 반환 필드
}
