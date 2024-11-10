package com.example.moamz.service.community;

import com.example.moamz.domain.dto.community.PostDTO;
import com.example.moamz.domain.dto.community.PostModifyDTO;
import com.example.moamz.mapper.community.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;


    public void writePost(PostDTO postDTO) {
        postMapper.insertPost(postDTO);
    }

    public void modifyPost(PostModifyDTO postModifyDTO) {
        postMapper.updateFgPostTitleAndEdit(postModifyDTO);
    }
}
