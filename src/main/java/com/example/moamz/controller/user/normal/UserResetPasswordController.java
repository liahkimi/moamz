package com.example.moamz.controller.user.normal;

import com.example.moamz.domain.dto.user.normal.UserResetPasswordDTO;
import com.example.moamz.service.user.normal.UserResetPasswordService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/normal")
public class UserResetPasswordController {
    private final UserResetPasswordService userResetPasswordService;

    @GetMapping("/resetPassword")
    public String resetPassword() {return "/user/regular/userFindPassword";}

    //아이디 휴대폰 인증 후 새 비밀번호 페이지 반환
    @PostMapping("/resetPassword")
    public RedirectView findPassword(@RequestParam("fgUserId") String fgUserId,
                                     @RequestParam("fgNormalPhone") String fgNormalPhone,
                                     HttpSession session) {
        log.info("😀😀😀😀아이디,휴대폰번호 : {}, :{}", fgUserId, fgNormalPhone);

        // 아이디 휴대폰 정보 확인
        UserResetPasswordDTO idPasswordInfo = userResetPasswordService.checkedPassword(fgUserId, fgNormalPhone);

        if (idPasswordInfo == null) {
            log.warn("인증 실패 : 잘못된 아이디 또는 휴대폰번호");
            return new RedirectView("/user/regular/userPassword?error=true");  // 에러 메시지를 URL에 전달
        }

        log.info("😀😀😀😀아이디,휴대폰번호 : {}, :{}", fgUserId, fgNormalPhone);

        // 로그인 성공 시 세션에 사용자 정보 저장 (fgUserId, fgUserCode)
        session.setAttribute("fgUserId", idPasswordInfo.getFgUserId());
        session.setAttribute("fgNormalPhone", idPasswordInfo.getFgNormalPhone());

        return new RedirectView("/normal/changePassword?fgUserId=" + fgUserId);
    }

    @GetMapping("/changePassword")
    public String changePassword(@RequestParam("fgUserId") String fgUserId,
                                 Model model) {
        model.addAttribute("fgUserId", fgUserId);
        return "/user/regular/userResetPassword";
    }

}
