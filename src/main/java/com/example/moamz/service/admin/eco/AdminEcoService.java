package com.example.moamz.service.admin.eco;

import com.example.moamz.domain.dto.admin.AdminCommentDTO;
import com.example.moamz.domain.dto.admin.eco.*;
import com.example.moamz.domain.dto.file.PostFileDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.mapper.admin.eco.AdminEcoMapper;
import com.example.moamz.mapper.file.PostFileMapper;
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
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AdminEcoService {
    private final AdminEcoMapper adminEcoMapper;
    private final PostFileMapper postFileMapper;

    @Value("C:/upload_moamz/") //application.properties에 저장해둔 file.dir프로퍼티값을 넣어줌
    private String fileDir; //위의 값을 fileDir에 저장

    //    에코프로젝트 글 작성하기 (게시글+파일 등록 처리)
    // MultipartFile: 업로드된 파이를 처리할때 사용하는 인터페이스
    public void registerEco(AdminEcoWriteDTO adminEcoWriteDTO, List<MultipartFile> files) throws IOException {
        adminEcoMapper.insertEcoPost(adminEcoWriteDTO);//공통게시글테이블 insert
        adminEcoMapper.insertEcoReal(adminEcoWriteDTO);//에코게시글테이블 insert
        Long fgPostId = adminEcoWriteDTO.getFgPostId(); //공통게시글테이블에 insert된 게시글번호

        for(MultipartFile file : files){
            if(file.isEmpty()){
                break;
            }
            PostFileDTO postFileDTO = saveFile(file);
            postFileDTO.setPostId(fgPostId);
            postFileMapper.insertFile(postFileDTO);
        }

    }
    
    //파일을 저장하는 메소드
    public PostFileDTO saveFile(MultipartFile files) throws IOException {
        String originalFileName = files.getOriginalFilename(); //사용자가 올린 파일명(확장자 포함)
        UUID uuid = UUID.randomUUID(); //파일이름에 붙여줄 uuid 생성
        String systemName = uuid.toString() + "_" + originalFileName; //uuid와 파일이름을 합쳐준다.
        File uploadPath = new File(fileDir + getUploadPath());//상위 경로와 하위경로를 합쳐준다

        //만약 경로가 존재하지 않는다면 (폴더가 만들어지지 않았다면)
        if(!uploadPath.exists()){
            uploadPath.mkdirs();//경로에 필요한 모든 폴더를 생성한다.
        }
        File uploadFile = new File(uploadPath, systemName);//전체경로와 파일이름을 연결한다.
        files.transferTo(uploadFile);//매개변수로 받은 Multipart객체가 가진 파일을 우리가 만든 경로와 이름으로 저장한다.
        PostFileDTO postFileDTO  = new PostFileDTO();
        postFileDTO.setPostFileUuid(uuid.toString());
        postFileDTO.setPostFileName(originalFileName);
        postFileDTO.setPostFileRoot(getUploadPath());

        return postFileDTO;
    }

    private String getUploadPath() {
        return new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    }

    //      진행중인 에코프로젝트 목록 가져오기
    public List<AdminIngEcoListDTO> findAllIngEcoList(Criteria criteria){
        return adminEcoMapper.selectAllIngEcoList(criteria);
    }

    //  에코프로젝트 총 갯수 구하기
    public int findEcoTotal(){return adminEcoMapper.selectEcoTotal();}

    //    종료된 에코프로젝트 목록 가져오기
    public List<AdminFinEcoListDTO> findFinEcoList(){
        return adminEcoMapper.selectFinEcoList();
    }

    // 특정 에코프로젝트 1개만 조회하기
    public AdminIngEcoListDTO findEcoProjectById(Long fgPostId){
        return adminEcoMapper.selectEcoProjectById(fgPostId)
                .orElseThrow(() -> new IllegalStateException("유효하지 않은 게시물"));
    }

    // 특정 한 에코프로젝트만 삭제하기
    public void removeEcoProject(Long fgPostId){
        adminEcoMapper.deleteEcoProject(fgPostId);
    }

    //    에코프젝  글 수정하기
    public void updateEco(AdminEcoModifyDTO adminEcoModifyDTO ,List<MultipartFile> files)throws IOException{
        adminEcoMapper.modifyEco(adminEcoModifyDTO); //공통게시글테이블 update
        Long fgPostId = adminEcoModifyDTO.getFgPostId();

        postFileMapper.deleteFile(fgPostId);

        for(MultipartFile file : files){
            if(file.isEmpty()){
                break;
            }
            PostFileDTO postFileDTO = saveFile(file); //예외던지기o
            postFileDTO.setPostId(fgPostId);
            postFileMapper.insertFile(postFileDTO);
        }

        adminEcoMapper.modifyEcoReal(adminEcoModifyDTO);//에코게시글테이블 update
    }


    //   에코프젝 종료시키기 버튼
    public void changeStatusBtn(Long fgPostId){
        adminEcoMapper.finishBtn(fgPostId);

    }


    //    (진행중/종료된) 특정 한 에코 프로젝트의 인증글 목록보기
    public List<AdminEcoCertListDTO> findEcoCertList(Long fgProjectId ){
        return adminEcoMapper.selectEcoCertList(fgProjectId);
    }

    //    에코프젝 인증글 상세 보기
    public AdminEcoCertDetailDTO findEcoCertDetail(Long fgPostId, Long fgProjectId){
        return adminEcoMapper.selectEcoCertDetail(fgPostId, fgProjectId)
                .orElseThrow(() -> new IllegalStateException("유효하지 않은 게시물"));
    }

    //  에코프젝 인증글 상세보기 - 댓글보기
    public List<AdminCommentDTO> findEcoCertDetailComment(Long fgPostId){
        return adminEcoMapper.selectEcoCertDetailComment(fgPostId);
    }

//    //  에코프젝 인증글 - 포인트 지급하기 버튼 서비스
//    public void giveEcoCertPoints(Long fgPostId) throws IOException {
//        // 1. 인증 글 작성자의 회원번호를 조회
//        Optional<AdminEcoCertPointBtnDTO> ecoPointReceiverOpt = adminEcoMapper.selectEcoPointReceiver(fgPostId);
//
//        if (ecoPointReceiverOpt.isPresent()) {
//            AdminEcoCertPointBtnDTO ecoPointReceiver = ecoPointReceiverOpt.get();
//            //.get() : Optional에 값이 존재할 때 그 값을 반환하는 Optional 메서드
//
//            // 2. 해당 유저의 포인트 업데이트
//            adminEcoMapper.updateUserEcoPoint(fgPostId);
//
//            // 3. 포인트 지급 내역을 기록
//            adminEcoMapper.insertEcoPointLog(ecoPointReceiver);
//        } else {
//            throw new IllegalArgumentException("해당 게시글에 대한 인증글 작성자가 존재하지 않습니다.");
//        }
//    }

    //   에코프젝 포인트 지급하기 버튼
    public void giveUserEcoPointAndLog(AdminEcoCertPointBtnDTO adminEcoCertPointBtnDTO){
        adminEcoMapper.updateUserEcoPointAndLog(adminEcoCertPointBtnDTO);

    }





















}
