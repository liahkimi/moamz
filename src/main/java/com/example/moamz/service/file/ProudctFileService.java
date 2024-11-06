package com.example.moamz.service.file;

import com.example.moamz.domain.dto.file.ProductFileDTO;
import com.example.moamz.mapper.file.ProductFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProudctFileService {
    private final ProductFileMapper productFileMapper;

    // 상품 파일 사진 등록 메서드
    public void registerFile(ProductFileDTO productFileDTO) {
        productFileMapper.insertFile(productFileDTO);
    }

    // 상품 파일 목록 가져오기 메서드
    public List<ProductFileDTO> findFileList(Long productId) {
        return productFileMapper.selectFileList(productId);
    }
}
