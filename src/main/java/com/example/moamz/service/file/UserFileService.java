package com.example.moamz.service.file;

import com.example.moamz.domain.dto.file.PostFileDTO;
import com.example.moamz.domain.dto.file.UserFileDTO;
import com.example.moamz.mapper.file.UserFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserFileService {
    private final UserFileMapper userFileMapper;

    // 유저 사진 등록 메서드
    public void registerFile(UserFileDTO userFileDTO) {
        userFileMapper.insertFile(userFileDTO);
    }

    // 유저 사진 삭제 메서드
    public void removeFile(Long userCode) {
        userFileMapper.deleteFile(userCode);
    }

    // 유저 사진 목록 가져오기 메서드
    public List<PostFileDTO> findFileList(Long userCode) {
        return userFileMapper.selectFileList(userCode);
    }

}
