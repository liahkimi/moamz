package com.example.moamz.mapper.file;

import com.example.moamz.domain.dto.file.ProductFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductFileMapper {
    // 상품 파일 등록
    void insertFile(ProductFileDTO productFileDTO);

    // 상품 파일 목록
    List<ProductFileDTO> selectFileList(Long productId);
}
