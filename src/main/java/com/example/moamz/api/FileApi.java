package com.example.moamz.api;


import com.example.moamz.domain.dto.file.ProductFileDTO;
import com.example.moamz.service.file.ProductFileService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
public class FileApi {
    private final ProductFileService productFileService;

    @Value("C:/upload_moamz/")
    private String fileDir;

    /**
     * 특정 상품에 대한 파일 목록을 반환하는 메서드
     * @param productId 파일 목록을 조회할 상품의 ID
     * @return 해당 상품의 파일 목록
     */
    @GetMapping("/v1/products/{productId}/files")
    public List<ProductFileDTO> productFileList(@PathVariable("productId") Long productId) {
        return productFileService.findFileList(productId);
    }

    /**
     * 파일을 byte[]로 반환하여 브라우저에 표시하는 메서드
     * @param productFileName 표시할 파일의 이름 (파일 경로 포함)
     * @return 파일의 byte[] 데이터 (이미지 표시 등에 사용)
     * @throws IOException 파일 입출력 예외
     */
    @GetMapping("/v1/files")
    public byte[] display(@RequestParam("productFileName") String productFileName) throws IOException {
        // 요청 파라미터에서 fileName을 추출할 때 @RequestParam 어노테이션 사용
        File file = new File(fileDir + productFileName);
        return FileCopyUtils.copyToByteArray(file);
    }


}
