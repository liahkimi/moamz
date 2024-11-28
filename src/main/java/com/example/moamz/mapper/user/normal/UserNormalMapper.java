package com.example.moamz.mapper.user.normal;

import com.example.moamz.domain.dto.user.normal.NormalLoginDTO;
import com.example.moamz.domain.dto.user.normal.NormalSessionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserNormalMapper {

    //@Param : MyBatis 에서 SQL 쿼리로 전달되는 파라미타에 이름을 지정하기 위해 사용한다
    //
    Optional<Long> selectId(@Param("fgUserId")String fgUserId, @Param("fgUserPassword") String fgUserPassword);

    Optional<NormalSessionDTO> selectLoginInfo(@Param("fgUserId") String fgUserId,
                                                   @Param("fgUserPassword") String fgUserPassword);

    //로그인 아아디, 비밀번호 확인
    Optional<String> idPasswordCheck(@Param("fgUserId") String fgUserId,
                                     @Param("fgUserPassword") String fgUserPassword);

}
