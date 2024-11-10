package com.example.moamz.service.user.normal;

import com.example.moamz.domain.dto.file.ProductFileDTO;
import com.example.moamz.domain.dto.file.UserFileDTO;
import com.example.moamz.domain.dto.user.normal.NormalCommonSignupDTO;
import com.example.moamz.domain.dto.user.normal.NormalFindIdDTO;
import com.example.moamz.domain.dto.user.normal.NormalPointDTO;
import com.example.moamz.domain.dto.user.normal.NormalUserSignupDTO;
import com.example.moamz.mapper.user.normal.NormalSignupMapper;
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
@RequiredArgsConstructor
@Slf4j
public class NormalSignupService {
    private final NormalSignupMapper normalSignupMapper;

    @Value("C:/upload_moamz/")
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

    public void userSignup(NormalCommonSignupDTO normalCommonSignupDTO,
                           NormalUserSignupDTO normalUserSignupDTO,
                           NormalPointDTO normalPointDTO,
                           MultipartFile file) throws IOException {
        log.info("😂서비스 실행 전 포인트dto : {}", normalCommonSignupDTO);

        normalSignupMapper.insertCommonUser(normalCommonSignupDTO);
        normalSignupMapper.insertNormalUser(normalUserSignupDTO);

        Long fgUserCode = normalCommonSignupDTO.getFgUserCode();
        log.info("😀😀😀😀fgUserCode : {}", fgUserCode);

        normalPointDTO.setFgUserCode(fgUserCode);
        normalSignupMapper.insertPoint(normalPointDTO);
        log.info("😂포인트dto : {}", normalCommonSignupDTO);
        log.info("😀😀😀😀noramlCommonSignupDTO", normalCommonSignupDTO);
        log.info("😀😀😀😀normalUserSignupDTO", normalUserSignupDTO);


        if(!file.isEmpty()) {
            UserFileDTO userFileDTO = saveFile(file);
            userFileDTO.setUserCode(fgUserCode);
            normalSignupMapper.insertUserFile(userFileDTO);
            log.info("😀😀😀😀userFileDTO", userFileDTO);
        }

    }



//    //MultipartFile : 업로드된 파일을 처리할 때 사용하는 인터페이스
//    public void insertUserFile(UserFileDTO userFileDTO, List<MultipartFile> files) {
//        normalSignupMapper.insertUserFile(userFileDTO);
//        Long fgUserFileId = userFileDTO.getUserFileId();
//
//        for(MultipartFile file : files){
//            if(file.isEmpty()){
//                break;
//            }
//
//            userFileDTO = saveFile(file);
//            fileDTO.setBoardId(boardId);
//            fileMapper.insertFile(fileDTO);
//
//        }
//    }

//    public void insertCommonUser(NormalCommonSignupDTO normalSignupDTO) {
//        normalSignupMapper.insertCommonUser(normalSignupDTO);
//    }
//
//    public void insertNormalUser(NormalUserSignupDTO normalUserSignupDTO) {
//        normalSignupMapper.insertNormalUser(normalUserSignupDTO);
//    }


//    public void insertPoint(NormalSignupDTO normalSignupDTO) {
//        normalSignupMapper.insertPoint(normalSignupDTO);
//    }

    // 아이디 중복확인
    public boolean checkedId(String fgUserId) {

        return normalSignupMapper.checkedId(fgUserId);
    }

    // 닉네임 중복확인
    public boolean checkedNickname(String fgNormalNickname){

        return normalSignupMapper.checkedNickname(fgNormalNickname);
    }

}
