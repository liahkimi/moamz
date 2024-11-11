package com.example.moamz.mapper.community;

import com.example.moamz.domain.dto.community.PostDTO;
import com.example.moamz.domain.dto.community.PostModifyDTO;

public interface PostMapper {
    void insertFgPost(PostDTO postDTO);

    void updateFgPostTitleAndEdit(PostModifyDTO postModifyDTO);
}
