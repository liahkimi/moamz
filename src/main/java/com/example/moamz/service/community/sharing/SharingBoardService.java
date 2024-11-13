package com.example.moamz.service.community.sharing;

import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.community.sharing.SharingDetailDTO;
import com.example.moamz.domain.dto.community.sharing.SharingListDTO;
import com.example.moamz.domain.dto.community.sharing.SharingModifyDTO;
import com.example.moamz.domain.dto.community.sharing.SharingWriteDTO;
import com.example.moamz.domain.dto.file.PostFileDTO;
import com.example.moamz.mapper.community.PostMapper;
import com.example.moamz.mapper.community.sharing.SharingBoardMapper;
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
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SharingBoardService {
    private final SharingBoardMapper sharingBoardMapper;
    private final PostFileMapper postFileMapper;
    private final PostMapper postMapper;

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


    // 1️⃣ 게시글 등록 + 파일 등록하는 메서드
    public void registerSharing(SharingWriteDTO sharingWriteDTO, MultipartFile file) throws IOException {
        // 게시글 삽입
        sharingBoardMapper.insertPost(sharingWriteDTO);
        sharingBoardMapper.insertSharing(sharingWriteDTO);

        // 생성된 postId를 변수에 저장해줌
        Long postId = sharingWriteDTO.getPostId();

        // 업로드된 파일이 존재할 경우, 파일을 저장함
        if (!file.isEmpty()) {
            PostFileDTO postFileDTO = saveFile(file);   // 파일 저장 메서드 호출
            postFileDTO.setPostId(postId);              // 파일DTO의 postId값 연결
            postFileMapper.insertFile(postFileDTO);     // 파일 테이블에 데이터 삽입
        }
    }

    // 2️⃣ 게시글, 파일 수정 메서드
    public void updateSharing(SharingModifyDTO sharingModifyDTO,
                              MultipartFile file,
                              boolean fileChanged) throws IOException {
        // 게시글 수정
        sharingBoardMapper.modifyPost(sharingModifyDTO);
        sharingBoardMapper.modifySharing(sharingModifyDTO);

        // postId값 변수에 저장
        Long postId = sharingModifyDTO.getPostId();

        log.info("💛💛💛 파일 수정여부 {}", fileChanged);

        // 이미지 파일이 변경되었을 때만 파일 삭제 후 재등록 한다.
        if (fileChanged) {
            System.out.println("💛💛💛 여기 실행됨???");
            postFileMapper.deleteFile(postId);  // 기존 파일 삭제

            if (!file.isEmpty()) {              // 새 파일이 있을 때만 삽입
                PostFileDTO postFileDTO = saveFile(file);   // 파일 등록 메서드 호출
                postFileDTO.setPostId(postId);              // 파일DTO에 postId 연결
                postFileMapper.insertFile(postFileDTO);     // 파일 테이블에 새로운 파일 삽입
            }
        }


    }// updateSharing 메서드 끝


    // 3️⃣ 게시글 삭제 메서드
    public Boolean removeSharing(Long userCode, Long postId) {

        // 게시글 작성자
        Long postWriter = postMapper.selectWriterCode(postId);

        // 삭제를 요청한 userCode와 게시글 작성자 userCode가 일치할 때만 삭제 가능
        if(postWriter.equals(userCode)) {
            sharingBoardMapper.deleteSharing(postId);
            return true;
        } else {
            return false;
        }
    }

    // 4️⃣ 게시글 목록 가져오기 메서드
    public List<SharingListDTO> findAvailableList() {
        return sharingBoardMapper.selectAvailableList();
    }
    public List<SharingListDTO> findReservedList() {
        return sharingBoardMapper.selectReservedList();
    }
    public List<SharingListDTO> findCompletedList() {
        return sharingBoardMapper.selectCompletedList();
    }

    // 5️⃣ 게시글 목록 가져오기 메서드 (페이지네이션 포함!!)
    public List<SharingListDTO> findAvailableListAll(Criteria criteria) {
        return sharingBoardMapper.selectAvailableListAll(criteria);
    }
    public List<SharingListDTO> findReservedListAll(Criteria criteria) {
        return sharingBoardMapper.selectReservedListAll(criteria);
    }
    public List<SharingListDTO> findCompletedListAll(Criteria criteria) {
        return sharingBoardMapper.selectCompletedListAll(criteria);
    }

    // 6️⃣ 나눔글 상태별 전체 게시글 수 반환 메서드
    public int findAvailableTotal() {
        return sharingBoardMapper.selectAvailableTotal();
    }
    public int findReservedTotal() {
        return sharingBoardMapper.selectReservedTotal();
    }
    public int findCompletedTotal() {
        return sharingBoardMapper.selectCompletedTotal();
    }

    // 7️⃣ 게시글 상세보기 메서드
    public SharingDetailDTO findSharingDetail(Long postId, Long userCode) {

        // 작성자 Code
        Long writerCode = postMapper.selectWriterCode(postId);

        // 작성자 Code랑 세션의 userCode 다를때 조회수 +1
        if(!writerCode.equals(userCode)) {
            postMapper.updateViewCount(postId);
        }

        return sharingBoardMapper.selectSharingDetail(postId)
                .orElseThrow(() -> new IllegalStateException("❌❌❌유효하지 않은 게시글입니다."));
    }



}//service class 끝




