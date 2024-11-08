package com.example.moamz.service.mypage.seller;

import com.example.moamz.domain.dto.file.ProductFileDTO;
import com.example.moamz.domain.dto.mypage.seller.ProductDetailDTO;
import com.example.moamz.domain.dto.mypage.seller.ProductListDTO;
import com.example.moamz.domain.dto.mypage.seller.ProductRegistDTO;
import com.example.moamz.mapper.file.ProductFileMapper;
import com.example.moamz.mapper.mypage.seller.SellerProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class SellerProductService {
    private final SellerProductMapper sellerProductMapper;
    private final ProductFileMapper productFileMapper;

    // fileDir 필드에 application.properties에 저장해둔 file.dir 프로퍼티 값 넣어줌
    @Value("C:/upload_moamz/")
    private String fileDir;

    // 파일 업로드 경로를 생성 메서드
    private String getUploadPath() {
        // 날짜 형식으로 폴더 경로를 생성함
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    // 파일 저장 메서드
    public ProductFileDTO saveFile(MultipartFile file) throws IOException {
        // 사용자가 올린 파일명과 UUID를 합쳐서 파일을 저장함
        String originalFileName = file.getOriginalFilename();
        UUID uuid = UUID.randomUUID();
        String systemName = uuid.toString() + "_" + originalFileName;

        // 상위 경로와 하위 경로를 합쳐서 파일이 저장될 경로 생성
        File uploadPath = new File(fileDir + getUploadPath());

        // 경로가 존재하지 않으면 폴더를 생성함
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        // 전체 경로와 파일 이름을 연결하여 최종 경로를 설정함
        File uploadFile = new File(uploadPath, systemName);

        // 매개변수로 받은 Multipart 객체가 가진 파일을 우리가 만든 경로와 이름으로 저장한다
        file.transferTo(uploadFile);

        ProductFileDTO productFileDTO = new ProductFileDTO();
        productFileDTO.setProductFileUuid(uuid.toString());
        productFileDTO.setProductFileName(originalFileName);
        productFileDTO.setProductFileRoot(getUploadPath());
        return productFileDTO;
    }

    // 1️⃣ 상품 등록 + 파일 등록하는 메서드
    public void registerProduct(ProductRegistDTO productRegistDTO, MultipartFile file) throws IOException {
        // 상품 데이터 삽입
        sellerProductMapper.insertProduct(productRegistDTO);
        // 상품ID값을 변수에 저장
        Long productId = productRegistDTO.getProductId();

        // 업로드된 파일이 존재할 경우, 파일을 저장함
        if (!file.isEmpty()) {
            ProductFileDTO productFileDTO = saveFile(file);     // 파일 저장 메서드 호출
            productFileDTO.setProductId(productId);             // 파일DTO의 productId값과 상품Id값 연결
            productFileMapper.insertFile(productFileDTO);       // 파일 데이터 삽입
        }
    }

    // 2️⃣ 판매중인 상품 목록 가져오기 메서드
    public List<ProductListDTO> findOnSales(Long businessId) {
        return sellerProductMapper.selectOnSales(businessId);
    }

    // 3️⃣ 판매 종료 상품 목록 가져오기 메서드
    public List<ProductListDTO> findNotOnSales(Long businessId) {
        return sellerProductMapper.selectNotOnSales(businessId);
    }

    // 4️⃣ 상품 판매상태 변경 메서드
    public void updateProductStatus(Long productId) {
        sellerProductMapper.modifyProductStatus(productId);
    }

    // 5️⃣ 상품 삭제 메서드
    public int removeProduct(Long productId) {
        return sellerProductMapper.deleteProduct(productId);
    }

    // 6️⃣ 상품 상세보기
    public ProductDetailDTO findProductDetail(Long productId) {
        return sellerProductMapper.selectProductDetail(productId)
                .orElseThrow(() -> new IllegalStateException("❌❌❌유효하지 않은 상품입니다."));
    }
}
