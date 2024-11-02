package com.example.moamz.mapper.file;

import com.example.moamz.domain.dto.file.ProductFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductFileMapper {
    // 상품파일 등록 메서드
    void insertFile(ProductFileDTO productFileDTO);
}
