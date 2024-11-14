package com.example.moamz.service.community.receipe;

import com.example.moamz.domain.dto.community.receipe.ReceipeDetailDTO;
import com.example.moamz.domain.dto.community.receipe.ReceipeListDTO;
import com.example.moamz.domain.dto.community.receipe.ReceipeModifyDTO;
import com.example.moamz.domain.dto.community.receipe.ReceipeWriteDTO;
import com.example.moamz.domain.dto.file.PostFileDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.mapper.community.PostMapper;
import com.example.moamz.mapper.community.receipe.ReceipeMapper;
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

@Service
@Transactional
@RequiredArgsConstructor
public class ReceipeService {
    private final ReceipeMapper receipeMapper;
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


    //레시피 리스트
    public List<ReceipeListDTO> showReceipes(){
        return receipeMapper.selectRecipePostList();
    }

//    레시피 디테일
    public ReceipeDetailDTO showReceipeDetail(Long fgPostId){
        return receipeMapper.selectRecipePost(fgPostId);
    }

//    레시피 insert
    public void writeReceipe(ReceipeWriteDTO receipeWriteDTO, MultipartFile file) throws IOException {

        receipeMapper.insertFgPostRecipe(receipeWriteDTO);

        Long fgPostId = receipeWriteDTO.getFgPostId();

        if (!file.isEmpty()) {
            PostFileDTO postFileDTO = saveFile(file);   // 파일 저장 메서드 호출
            postFileDTO.setPostId(fgPostId);              // 파일DTO의 postId값 연결
            postFileMapper.insertFile(postFileDTO);     // 파일 테이블에 데이터 삽입
        }

    }

//    레시피 update
    public void modifyReceipe(ReceipeModifyDTO receipeModifyDTO){
        receipeMapper.updateFgRecipeDetails(receipeModifyDTO);
    }

// 레시피 삭제
    public void deleteReceipe(Long fgPostId){
        receipeMapper.deleteFgRecipe(fgPostId);
    }

    public List<ReceipeListDTO> showRecipePage(Criteria criteria){
        return receipeMapper.selectRecipePostListPage(criteria);
    }

    public int totalRecipe(){
        return receipeMapper.countRecipe();
    }
}
