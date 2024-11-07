package com.example.moamz.service.user.normal;

import com.example.moamz.domain.dto.user.normal.NormalSignupDTO;
import com.example.moamz.mapper.user.normal.NormalSignupMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class NormalSignupService {
    private final NormalSignupMapper normalSignupMapper;

    public void insertCommonUser(NormalSignupDTO normalSignupDTO) {
        normalSignupMapper.insertCommonUser(normalSignupDTO);
    }

    public void insertNormalUser(NormalSignupDTO normalSignupDTO) {
        normalSignupMapper.insertNormalUser(normalSignupDTO);
    }

//    public void insertUserFile(NormalSignupDTO normalSignupDTO) {
//        normalSignupMapper.insertUserFile(normalSignupDTO);
//    }
//
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
