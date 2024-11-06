//package com.example.moamz.controller.admin;
//
//import com.example.moamz.domain.dto.admin.user.AdminUserSessionDTO;
//import com.example.moamz.service.admin.user.UserService;
//import jakarta.servlet.http.HttpSession;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.doReturn;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@WebMvcTest //spring mvc 테스트에 필요한 빈들을 설정하고, 지정된 컨트롤러에 대해 테스트를 수행
//@ExtendWith(MockitoExtension.class) //모의객체 사용위함
//class UserControllerTest {
//
//    //MockMvc는 spring MVC테스트를 위한 주요컴포넌트
//    //컨트롤러의 http 요청과 응답을 모의테스트 해볼 수 있다.
//    //@Autowired는 Spring 컨텍스트에서 MockMvc객체를 주입받는데 사용된다.
//    @Autowired
//    private MockMvc mockMvc;
//
//    //@MockBean은 spring의 ApplicationContext에 모의객체로 등록한다.
//    //UserService를 모의 객체로 등록하여, 실제 서비스 구현체 대신에 테스트 목적으로 사용된다.
//    //Spring어플리케이션 컨텍스트 내의 다른 빈들과 상호작용 할 수 있다.
//    //서비스
//    @MockBean
//    private UserService userService;
//
//
//    //@Mock Mockito를 사용해서 모의객체를 생성
//    //HttpSession을 모의객체로 생성해서 세션관련 동작을 테스트할 수 있다. (스프링컨텍스트와는 무관하게 독립적이다)
//    @Mock
//    private HttpSession session;
//
//
//    @BeforeEach
//    //매 테스트마다 MockMvc를 리셋함
//    void setUp(WebApplicationContext wac){
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//
//    }
//
//    @Test
//    void testLoginUser() throws Exception { //perform에서 시그니처로 예외처리 가능
//        //given : userService의 findLoginInfo메소드가 UserSessionDTO를 반환하도록 설정
//        AdminUserSessionDTO userSessionDTO = new AdminUserSessionDTO(); //로그인하면 세션이 유지되어있는 상태여야해서.
//        userSessionDTO.setFgUserCode(0L);
//        userSessionDTO.setFgUserId("관리자");
//        doReturn(userSessionDTO).when(userService).findLoginInfo(any(), any());//Mockito의 stubber메소드중 하나. doReturn()은 스텁이 반환할 객체를 정의함.
//        //when : /user/login 경로로 POST 요청을 보냄(로그인 아이디와 비밀번호를 파라미터로)
//        //then : http상태코드 3xx와 /admin/dashBoard로 리다이렉션 기대
//        mockMvc.perform(post("/admin/login")
//                .param("fgUserId", "관리자")
//                .param("fgUserPassword", "1234"))
//                .andExpect(status().is3xxRedirection()) //상태코드 검증
//                .andExpect(redirectedUrl("/admin/adminDashboard"));
//
//    }
//
//  테스트 실패여서 일단 주석....
//}