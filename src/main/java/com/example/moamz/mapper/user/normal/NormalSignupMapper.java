package com.example.moamz.mapper.user.normal;

import com.example.moamz.domain.dto.user.normal.NormalLoginDTO;
import com.example.moamz.domain.dto.user.normal.NormalSignupDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface NormalSignupMapper {
    void insertCommonUser(NormalSignupDTO normalSignupDTO);
    void insertNormalUser(NormalSignupDTO normalSignupDTO);
    void insertUserFile(NormalSignupDTO normalSignupDTO);
    void insertPoint(NormalSignupDTO normalSignupDTO);

    //아이디 중복확인
    boolean checkedId(String fgUerId);
    //닉네임 중복확인
    boolean checkedNickname(String fgNormalNickname);

}

