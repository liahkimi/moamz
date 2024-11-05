package com.example.moamz.service.file;

import com.example.moamz.domain.dto.file.PostFileDTO;
import com.example.moamz.mapper.file.PostFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostFileService {
    private final PostFileMapper postFileMapper;

    // 게시글 대표사진 등록 메서드
    public void registerFile(PostFileDTO postFileDTO) {
        postFileMapper.insertFile(postFileDTO);
    }

    // 게시글 대표사진 삭제 메서드
    public void removeFile(Long boardId) {
        postFileMapper.deleteFile(boardId);
    }

    // 게시글 대표사진 목록 가져오기 메서드
    public List<PostFileDTO> findFileList(Long boardId) {
        return postFileMapper.selectFileList(boardId);
    }
}
