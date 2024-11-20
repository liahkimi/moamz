package com.example.moamz.domain.dto.community.free;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class FreeLikeDTO {
    //
    // 자유게시판 좋아요 DTO
    //

    private Long likeId;      // 좋아요ID
    private Long userCode;    // 사용자CODE
    private Long postId;      // 게시물ID

}
