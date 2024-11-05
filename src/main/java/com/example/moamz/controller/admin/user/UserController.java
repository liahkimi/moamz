package com.example.moamz.controller.admin.user;


import com.example.moamz.domain.dto.admin.user.UserSessionDTO;
import com.example.moamz.service.admin.user.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin") //contextPath

public class UserController {
    private final UserService userService;

    //get요청 처리, 로그인 화면 보여주기만
    @GetMapping("login")
    public String login(){
        return "admin/adminLogin"; //html파일명
    }

    //post요청 처리, 로그인 성공 후 대시보드 페이지로 리다이렉트시키기
    @PostMapping("login")
    //로그인 풀리지 않게 세션이 생겨야 한다. (세션클래스도 매개변수로 넣기)
    public RedirectView login(@RequestParam("fgUserId") String fgUserId,
                              @RequestParam("fgUserPassword") String fgUserPassword,
                              HttpSession session){
        log.info("로그인 시도 : {}", fgUserId);

        UserSessionDTO loginInfo = userService.findLoginInfo(fgUserId, fgUserPassword);
        //서비스, 서비스의 매퍼 , 매퍼xml까지 실행되는 것
        //세션이 브라우저창url에 보이지 않아 log로 확인함.
        if (loginInfo != null) {
            session.setAttribute("fgUserId", loginInfo.getFgUserId());
            session.setAttribute("fgUserCode", loginInfo.getFgUserCode());

            // 세션 ID와 속성을 로그로 출력
            log.info("세션 ID: {}", session.getId());
            log.info("세션 fgUserId: {}", session.getAttribute("fgUserId"));
            log.info("세션 fgUserCode: {}", session.getAttribute("fgUserCode"));
        } else {
            log.warn("로그인 실패: 사용자 ID 또는 비밀번호가 잘못되었습니다.");
        }

        return new RedirectView("/admin/dashboard"); //성공하면 이동되는 페이지 (dashboard getMapping생기면 이름바꿔주기)
        //특정 url로 리다이렉트 시키기 위해서 사용되며, 주로 컨트롤러 메소드에서 리다이렉트 응답을 만들때 사용된다.
    }

    // 로그아웃 - 세션 끊기
    @GetMapping("/logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/admin/login"); //로그인 페이지 반환
    }

}
