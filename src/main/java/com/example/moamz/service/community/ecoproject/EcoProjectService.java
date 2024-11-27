package com.example.moamz.service.community.ecoproject;

import com.example.moamz.domain.dto.community.ecoproject.EcoCertDetailDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoCertListDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoCertWriteDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoProjectListDTO;
import com.example.moamz.domain.dto.file.PostFileDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.page.EcoCertCriteria;
import com.example.moamz.mapper.community.PostMapper;
import com.example.moamz.mapper.community.ecoproject.EcoProjectMapper;
import com.example.moamz.mapper.file.PostFileMapper;
import lombok.RequiredArgsConstructor;
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

@Transactional
@Service
@RequiredArgsConstructor
public class EcoProjectService {
    private final EcoProjectMapper ecoProjectMapper;
    private final PostMapper postMapper;
    private final PostFileMapper postFileMapper;

    // fileDir 필드에 application.properties에 저장해둔 file.dir 프로퍼티 값 넣어줌
    @Value("C:/upload_moamz/")
    private String fileDir;

    // 파일 업로드 경로를 생성 메서드
    private String getUploadPath() {
        // 날짜 형식으로 폴더 경로를 생성함
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }


    // 파일 저장 메서드
    public PostFileDTO saveFile(MultipartFile file) throws IOException {
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

        PostFileDTO postFileDTO = new PostFileDTO();
        postFileDTO.setPostFileUuid(uuid.toString());
        postFileDTO.setPostFileName(originalFileName);
        postFileDTO.setPostFileRoot(getUploadPath());
        return postFileDTO;
    }

    // 프로젝트 리스트
    public List<EcoProjectListDTO> showProjectList() {
        return ecoProjectMapper.ecoProjectList();
    }

    // 완료 프로젝트 리스트
    public List<EcoProjectListDTO> showEndProjectList() {
        return ecoProjectMapper.ecoProjectEndList();
    }

    // 인증글 리스트
    public List<EcoCertListDTO> showCertList(Long fgProjectId) {
        return ecoProjectMapper.ecoCertList(fgProjectId);
    }

    // 인증글 디테일
    public EcoCertDetailDTO showCertDetail(Long fgPostId){
        return ecoProjectMapper.ecoCertDetail(fgPostId);
    }

    // 인증글에 insert
    public void writeCert(EcoCertWriteDTO ecoCertWriteDTO){
        ecoProjectMapper.ecoCertInsert(ecoCertWriteDTO);
    }

//    인증글 삭제
    public void deleteCert(Long fgPostId){
        ecoProjectMapper.ecoCertDelete(fgPostId);
    }

    public List<EcoProjectListDTO> showEcoPage(Criteria criteria){
        return ecoProjectMapper.ecoProjectListPage(criteria);
    }

    public List<EcoProjectListDTO> showEndEcoPage(Criteria criteria){
        return ecoProjectMapper.endecoProjectListPage( criteria );
    }

    public List<EcoCertListDTO> showEcoCertPage(EcoCertCriteria ecoCertCriteria){
        return ecoProjectMapper.ecoCertListPage(ecoCertCriteria);
    }

    public int totalEco(){
        return ecoProjectMapper.countEco();
    }

    public int totalCert(){
        return ecoProjectMapper.countCert();
    }
}













