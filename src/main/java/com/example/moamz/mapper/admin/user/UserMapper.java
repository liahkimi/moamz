package com.example.moamz.mapper.admin.user;
import com.example.moamz.domain.dto.admin.user.AdminUserSessionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserMapper {
//    로그인
    //Optional은 NPE null값 처리를 위한 방어하기 위해 사용(예외처리 하려고)
    //@param은 MyBatis에서 SQl쿼리로 전달되는 파라미터에 이름을 지정하기 위해 사용
    //실제로 selectUserCode 메서드가 어떤 sql쿼리를 실행할지에 대한 구체적인 내용은 myBatis매퍼 xml파일 또는 어노테이션을 통해 설정된다.
    //구체적인 sql 실행은 myBatis가 자동으로 바인딩 한다.
    Optional<Long> selectUserCode(@Param("fgUserId")String fgUserId, @Param("fgUserPassword")String fgUserPassword);
//    세션 가져오기
    Optional<AdminUserSessionDTO> selectLoginInfo(@Param("fgUserId")String fgUserId, @Param("fgUserPassword")String fgUserPassword);
}
