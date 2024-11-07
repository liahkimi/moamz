package com.example.moamz.service.admin.user;

import com.example.moamz.mapper.admin.user.AdminUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

//@SprinBootTest  <- 서비스 테스트에서는 안써야 함.
@Slf4j
@ExtendWith(MockitoExtension.class)//Mockito + Junit
class AdminUserServiceTest {
    //관계 : UserService는 UserMapper를 주입받는다.
    //사용 : UserService를 테스트하기 위해서는 UserMapper가 주입되어야 하는데,UserMapper는 개발자가 테스트하고자하는 대상 아님.
    //=> 그래서 UserMapper를 Mock객체로 만들어서 UserService에 주입하여 테스트한다.

    @Mock //가짜객체 생성해준다.
    AdminUserMapper adminUserMapper;

    @InjectMocks //mock객체를 주입해준다.
    AdminUserService adminUserService;

    //Stubbing:Mock객체의 메소드를 실행했을때의 행위를 미리 정의하는것(Mock객체의 특정메소드를 실행시키면 특정 값을 반환하거나 예외 발생등을 설정한다.)
    //Stub:stubbing으로 새롭게 정의된 메소드
    // when(mock객체.스터빙할메서드()).ongoingStubbing()
    // *when의 매개변수로 반환타입이 void인 메서드 사용 불가
    //when(): 실행되었을때 할 행위를 정하는 메소드.
    //@Spy - stub하지 않은 메소드는 실제 객체에 정의된건을 사용하는 객체



    @DisplayName("로그인 서비스")
    @Test
   void findUserCode(){
        //given
        doReturn(Optional.of(0L)).when(adminUserMapper).selectUserCode(any(), any());
        //stubber메소드 사용 -> doReturn(): 스텁이 반환할 객체를 정의 => Optional.of():값을 저장하고 있는 객체 생성(확실히 null이 아닌경우에만)
        // => 메소드가 실행되면 Optional.of(1L)를 반환하도록 설정 / 1L은 임의로 fgUserCode 1번이 나오도록 설정한 것
        
        //when
        Long fgUserCode = adminUserService.findUserCode("admin", "1234");
        log.info("fgUserCode: {}" , fgUserCode);// 결과로 반환된 fgUserCode 확인용 로그 (플레이스홀더 역할)

        //then;
        assertThat(fgUserCode).isEqualTo(0L);
        // AssertJ라이브러리 : assertThat().isEqualTo(A) : A값과 같은지 검증

    }



}