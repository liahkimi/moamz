package com.example.moamz.mapper.user.normal;

import com.example.moamz.domain.dto.user.normal.UserResetPasswordDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserResetPasswordMapper {

    //회원Session
//    Optional<Long> normalSession(@Param("fgUserId")String fgUserId);

    //아이디, 휴대폰 조회
    Optional<UserResetPasswordDTO> selectPassword(@Param("fgUserId") String fgUserId,
                                   @Param("fgNormalPhone") String fgNormalPhone);

    //비밀번호 변경
//    int updatePassword(UserResetPasswordDTO userResetPasswordDTO);

}
