package com.example.moamz.mapper.file;

import com.example.moamz.domain.dto.file.PostFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostFileMapper {
    // 파일 등록
    void insertFile(PostFileDTO postFileDTO);

    // 파일 삭제
    void deleteFile(Long boardId);

    // 파일 목록 가져오기
    List<PostFileDTO> selectFileList(Long boardId);
}

