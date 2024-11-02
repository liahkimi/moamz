package com.example.moamz.service.file;

import com.example.moamz.domain.dto.file.ProductFileDTO;
import com.example.moamz.mapper.file.ProductFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProudctFileService {
    private final ProductFileMapper productFileMapper;

    // 상품 파일 사진 등록 서비스
    public void registerFile(ProductFileDTO productFileDTO) {
        productFileMapper.insertFile(productFileDTO);
    }
}
