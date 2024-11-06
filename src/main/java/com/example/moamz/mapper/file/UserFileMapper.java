package com.example.moamz.mapper.file;

import com.example.moamz.domain.dto.file.PostFileDTO;
import com.example.moamz.domain.dto.file.UserFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserFileMapper {

    // 파일 등록
    void insertFile(UserFileDTO userFileDTO);

    // 파일 삭제
    void deleteFile(Long userCode);

    // 파일 목록 가져오기
    List<PostFileDTO> selectFileList(Long userCode);
}
