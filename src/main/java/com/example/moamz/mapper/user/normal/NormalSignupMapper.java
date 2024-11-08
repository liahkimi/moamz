package com.example.moamz.mapper.user.normal;

import com.example.moamz.domain.dto.file.UserFileDTO;
import com.example.moamz.domain.dto.user.normal.NormalCommonSignupDTO;
import com.example.moamz.domain.dto.user.normal.NormalPointDTO;
import com.example.moamz.domain.dto.user.normal.NormalUserSignupDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NormalSignupMapper {
    void insertCommonUser(NormalCommonSignupDTO normalCommonSignupDTO);
    void insertNormalUser(NormalUserSignupDTO normalUserSignupDTO);
    void insertUserFile(UserFileDTO userFileDTO);
    void insertPoint(NormalPointDTO normalPointDTO);

    //아이디 중복확인
    boolean checkedId(String fgUerId);
    //닉네임 중복확인
    boolean checkedNickname(String fgNormalNickname);

}

