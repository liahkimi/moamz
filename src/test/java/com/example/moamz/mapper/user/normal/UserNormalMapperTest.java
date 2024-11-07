package com.example.moamz.mapper.user.normal;

import com.example.moamz.domain.dto.user.normal.NormalLoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
// 스프링 컨텍스트를 로드하고 스프링부트 어플리케이션의 모든 설정을 이용해 통합 테스트를 실행할 수 있도록 한다
@Transactional
// 테스트 메소드에서 수행된 데이터베이스 작업이 테스트가 끝나면 자동으로 롤백되도록 한다
// 테스트에서 삽입한 데이터는 테스트가 끝난 후 실제 데이터베이스에 반영되지 않는다
//@Sql(statements = {
//        "INSERT INTO FG_COMMON_USER (FG_USER_CODE, FG_USER_ID, FG_USER_PASSWORD, FG_USER_JOIN_DATE, FG_USER_TYPE)\n" +
//                "VALUES (SEQ_USER.NEXTVAL, 'user01', 'password01', SYSDATE, '일반회원')"
//})
@Slf4j
class UserNormalMapperTest {
    @Autowired
    UserNormalMapper userNormalMapper;
    NormalLoginDTO normalLoginDTO;

    @BeforeEach
    void setUp() {
        normalLoginDTO = new NormalLoginDTO();
        normalLoginDTO.setFgUserCode(5L);
        normalLoginDTO.setFgUserId("user05@gmail.com");
        normalLoginDTO.setFgUserPassword("password05");
//        userNormalMapper.insertUser(normalLoginDTO);
//        log.info("😑😑😑😑😑😑😑😑😑" + normalLoginDTO.toString());
    }

    @Test
    void  selectId(){
        //given
        String fgUserId = "user05@gmail.com";
        String fgUserPassword = "password05";

        //when
        Long fgUserCode = userNormalMapper.selectId(fgUserId, fgUserPassword)
                .orElseThrow(() -> new AssertionError("유저 ID를 찾을 수 없습니다"));

        //then
        assertThat(fgUserCode).isEqualTo(normalLoginDTO.getFgUserCode());

    }

}