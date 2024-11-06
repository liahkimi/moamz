package com.example.moamz.mapper.user.normal;

import com.example.moamz.domain.dto.user.normal.UserNomalSessionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserNomalMapper {
    void insertUser(UserNomalSessionDTO userNomalSessionDTO);

    //@Param : MyBatis 에서 SQL 쿼리로 전달되는 파라미타에 이름을 지정하기 위해 사용한다
    //
    Optional<Long> selectId(@Param("FgUserId")String loginId, @Param("FgUserPassword") String password);

    Optional<UserNomalSessionDTO> selectLoginInfo(@Param("FgUserPassword") String loginId, @Param("FgUserPassword") String password);

}
