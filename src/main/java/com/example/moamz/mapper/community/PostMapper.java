package com.example.moamz.mapper.community;

import com.example.moamz.domain.dto.community.PostDTO;
import com.example.moamz.domain.dto.community.PostModifyDTO;

public interface PostMapper {
    void insertFgPost(PostDTO postDTO);

    void updateFgPostTitleAndEdit(PostModifyDTO postModifyDTO);

    // 게시글 작성자 userCode 조회
    Long selectWriterCode(Long postId);

    // 조회수 증가
    void updateViewCount(Long postId);
}
