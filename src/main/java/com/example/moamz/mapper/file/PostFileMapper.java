package com.example.moamz.mapper.file;

import com.example.moamz.domain.dto.file.PostFileDTO;
import com.example.moamz.domain.dto.file.ProductFileDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostFileMapper {
    // 파일 등록
    void insertFile(PostFileDTO postFileDTO);
}

