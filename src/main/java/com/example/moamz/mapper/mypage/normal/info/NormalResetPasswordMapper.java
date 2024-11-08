package com.example.moamz.mapper.mypage.normal.info;

import com.example.moamz.domain.dto.mypage.normal.info.NormalResetPasswordDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NormalResetPasswordMapper {
    void updateNormalPassword(NormalResetPasswordDTO normalResetPasswordDTO);
}
