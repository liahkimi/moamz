package com.example.moamz.service.user.seller;

import com.example.moamz.domain.dto.file.UserFileDTO;
import com.example.moamz.domain.dto.user.seller.SellerBusinessDTO;
import com.example.moamz.domain.dto.user.seller.SellerCommonSignupDTO;
import com.example.moamz.domain.dto.user.seller.SellerUserSignupDTO;
import com.example.moamz.mapper.user.seller.SellerSignupMapper;
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
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SellerSignupService {
    private final SellerSignupMapper sellerSignupMapper;

    @Value("C:/upload_moamz")
    private String fileDir;

    // 파일 업로드 경로를 생성 메서드
    private String getUploadPath() {
        // 날짜 형식으로 폴더 경로를 생성함
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    // 파일 저장 메서드
    public UserFileDTO saveFile(MultipartFile file) throws IOException {
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

        UserFileDTO userFileDTO = new UserFileDTO();
        userFileDTO.setUserFileUuid(uuid.toString());
        userFileDTO.setUserFileName(originalFileName);
        userFileDTO.setUserFileRoot(getUploadPath());
        return userFileDTO;
    }

    public void userSignup(SellerCommonSignupDTO sellerCommonSignupDTO,
                           SellerUserSignupDTO sellerUserSignupDTO,
                           SellerBusinessDTO sellerBusinessDTO,
                           MultipartFile file) throws IOException {
        log.info("😂서비스 실행 전 : {}",sellerCommonSignupDTO);

        sellerSignupMapper.insertCommonUser(sellerCommonSignupDTO);
        sellerSignupMapper.insertSellerUser(sellerUserSignupDTO);
//        sellerSignupMapper.insertBusiness(sellerBusinessDTO);

        Long fgUserCode = sellerCommonSignupDTO.getFgUserCode();
        log.info("😀😀😀😀fgUserCode : {}", fgUserCode);

        sellerBusinessDTO.setFgUserCode(fgUserCode);
        sellerSignupMapper.insertBusiness(sellerBusinessDTO);
        log.info("😂포인트dto : {}", sellerCommonSignupDTO);
        log.info("😀😀😀😀noramlCommonSignupDTO", sellerCommonSignupDTO);
        log.info("😀😀😀😀normalUserSignupDTO", sellerUserSignupDTO);


        if(!file.isEmpty()) {
            UserFileDTO userFileDTO = saveFile(file);
            userFileDTO.setUserCode(fgUserCode);
            sellerSignupMapper.insertUserFile(userFileDTO);
            log.info("😀😀😀😀userFileDTO", userFileDTO);
        }

    }

    // 아이디 중복확인
    public String checkedId(String fgUserId) {
        return sellerSignupMapper.checkedId(fgUserId)
                .orElse(null);
    }
}
