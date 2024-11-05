package com.example.moamz.service.file;

import com.example.moamz.domain.dto.file.PostFileDTO;
import com.example.moamz.mapper.file.PostFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostFileService {
    private final PostFileMapper postFileMapper;

    // 게시글 대표사진 등록 메서드
    public void registerFile(PostFileDTO postFileDTO) {
        postFileMapper.insertFile(postFileDTO);
    }
}
