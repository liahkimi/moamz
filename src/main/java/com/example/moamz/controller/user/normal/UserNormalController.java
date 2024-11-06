package com.example.moamz.controller.user.normal;


import com.example.moamz.domain.dto.user.normal.UserNomalSessionDTO;
import com.example.moamz.service.user.normal.UserNomalService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserNomalController {
    private final UserNomalService userNomalService;

    //get요청 처리, 회원가입 페이지 반환
//    @GetMapping("join")
//    public String join() {
//        return "user/join";
//    }
    //post 요청 처리, 입력된 회원정보를 받아서 UserService를 통해 사용자 등록하고 성공 후 다른 페이지로 리다이렉트
//    @PostMapping("join")
//    public String join(@ModelAttribute UserNomalSessionDTO userNomalSessionDTO){
//        //@ModelAttribute : 요청전에 모델에 특정 속성을 추가할 수 있음
//        //요청 매개변수를 모델 객체로 바인딩, 컨트롤러 메소드가 실행되기 전 모델에 데이터를 추가할 때(모델 추가)
//        //요청전에 모델 객체 초기화
//        log.info("userDTO = {}", userNomalSessionDTO);
//        userNomalService.registerUser(userNomalSessionDTO);
//        return "redirect:/user/login";
//    }

    //get 요청처리, 로그인 페이지 반환
    @GetMapping("regular/userLogin")
    public String login(){
        return "userLogin";
    }

    //post 요청 처리, 로그인 완료되면 board리스트 페이지 반환
    @PostMapping("/regular/userLogin")
    public RedirectView login(@RequestParam("FgUserId") String loginId,
                              @RequestParam("FgUserPassword") String password,
                              HttpSession session){
        log.info("로그인 시도 : {}", loginId);

        UserNomalSessionDTO loginInfo = userNomalService.findLoginInfo(loginId, password);

        session.setAttribute("loginId", loginInfo.getFgUserId());
        session.setAttribute("userId", loginInfo.getFgUserCode());

        return new RedirectView("/main/main/mainPage");
        //RedirectView는 클라이언트에게 HTTP 302 Redirect 응답을 보내고 클라이언트 새로운 URL로 이동하게 된다
        //특정 URL로 리다이렉트 시키기 위해 사용되며 주로 컨트롤러 메소드에서 리다이렉트 응답을 만들 때 사용된다
    }
//
//    @GetMapping("/logout")
//    public RedirectView logout(HttpSession session){
//        session.invalidate();
//        return new RedirectView("/user/login");
//    }
}
