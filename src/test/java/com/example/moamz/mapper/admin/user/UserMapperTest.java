package com.example.moamz.mapper.admin.user;

import com.example.moamz.domain.dto.admin.user.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//스프링 컨텍스트를 로드하고, 스프링부트 어플리케이션의 모든 설정을 이용해서 통합 테스트를 실행할 수 있도록 도와줌
// mapper테스트에 항상 있어야 함.
@Transactional
//테스트 메소드에서 수행된 데이터베이스 작업이 테스트가 끝나면 자동 롤백되도록 한다.
@Sql(statements = {
        "INSERT INTO FG_COMMON_USER (FG_USER_CODE, FG_USER_ID, FG_USER_PASSWORD, FG_USER_TYPE) VALUES (0, 'admin', '1234', '관리자')"
})
//=> insert할 메서드 없을때 직접 sql에 넣는 어노테이션
class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    UserDTO userDTO;

    @BeforeEach
    //@BeaforeEach의 setUp메소드
    void setUp(){
        userDTO = new UserDTO();
        userDTO.setFgUserCode(0L);
        userDTO.setFgUserId("admin");
        userDTO.setFgUserPassword("1234");
//      관리자는 회원가입 기능이 없음..
    }

//    로그인 테스트
    @Test
    void selectUserCode(){
        //given
        String fgUserId = "admin";
        String fgUserPassword = "1234";

        //when
        //selectUserCode메서드로 반환될 fgUserCode는 Optional<Long> 타입이여서
        //.orElseThrow()와 같은 예외처리 메서드 사용이 가능하다.
        //->null인경우 람다식으로 지정한 특정 예외를 발생시킨다.
        Long fgUserCode = userMapper.selectUserCode(fgUserId, fgUserPassword)
                .orElseThrow(()-> new AssertionError("유저 id를 찾을 수 없습니다."));

        //then -검증
        //selectUserCode메서드로 조회된 fgUserCode가 userDTO에 있는 fgUserCode와 같은지 검증
        assertThat(fgUserCode).isEqualTo(userDTO.getFgUserCode());
    }
}