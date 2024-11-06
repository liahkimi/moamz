package com.example.moamz.mapper.user.normal;

import com.example.moamz.domain.dto.user.normal.NormalResetPasswordDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface NormalResetPasswordMapper {

    //아이디, 비밀번호 조회
    Optional<String> selectPassword(@Param("fgUserId") String fgUserId,
                                   @Param("fgNormalPhone") String fgNormalPhone);

    //비밀번호 변경
    int updatePassword(NormalResetPasswordDTO normalResetPasswordDTO);

}
