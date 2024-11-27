package com.example.moamz.controller.mypage.normal;

import com.example.moamz.domain.dto.mypage.normal.info.NormalResetPasswordDTO;
import com.example.moamz.domain.dto.mypage.seller.info.StoreInfoDTO;
import com.example.moamz.domain.dto.mypage.seller.info.StoreModifyDTO;
import com.example.moamz.service.mypage.normal.NormalMyService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/normal/my")
public class NormalMyController {
    private final NormalMyService normalMyService;

    //
    // 유저 정보 확인 <GET 요청>
    //
    @GetMapping("/infoAuth/{requestPage}")
    public String getInfoAuth(@SessionAttribute(value="fgUserCode", required = false) Long fgUserCode,
                              @PathVariable(value = "requestPage") String requestPage,
                              Model model) {
        // 세션에 fgUserCode가 null이면 로그인 페이지로 이동
        if(fgUserCode == null) {
            return "redirect:/normal/regular/userLogin";
        }

        // 일반회원 id 찾아서 전송하기
        String fgUserId = normalMyService.findNormalId(fgUserCode);
        model.addAttribute("fgUserId", fgUserId);

        // 회원정보 변경 요청인지, 비밀번호 변경 요청인지를 모델에 담아서 전송해야 할 듯.
        model.addAttribute("requestPage", requestPage);

        return "/mypage/regular/userInfoAuth";
    }

    //
    // 유저 정보 확인 <POST 요청>
    //
    @PostMapping("/infoAuth")
    public String getInfoAuth(@SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode,
                              @RequestParam(value = "requestPage") String requestPage,
                              @RequestParam(name = "input-password") String inputPassword,
                              RedirectAttributes redirectAttributes) {

        // 로그인한 계정의 비밀번호
        String fgUserPassword = normalMyService.findNormalPw(fgUserCode);

        // 사용자가 입력한 비밀번호와 일치하는지 확인
        if(!fgUserPassword.equals(inputPassword)) {
            // 비밀번호가 일치하지 않으면 alertMessage를 담아서 다시 infoAuth로 리다이렉트
            redirectAttributes.addFlashAttribute("Message", "비밀번호가 일치하지 않습니다.");
            return "redirect:/normal/my/infoAuth/" + requestPage;
        } else {
            // 일치하면 requestPage에 따라 알맞은 정보 수정 페이지로 리다이렉트
            if ("resetPw".equals(requestPage)) {
                return "redirect:/normal/my/resetPw"; //비밀번호 변경 페이지 (resetPw)
            } else if ("resetInfo".equals(requestPage)) {
                return "redirect:/normal/my/resetInfo"; //회원정보 변경 페이지 (resetInfo)
            }
        }

        // 기본 반환값
        redirectAttributes.addFlashAttribute("Message", "잘못된 요청입니다.");
        return "redirect:/normal/my/infoAuth";
    }



    //
// 비밀번호 변경 페이지 <GET 요청>
//
    @GetMapping("/resetPw")
    public String resetPassword(@SessionAttribute(value="fgUserCode", required = false) Long fgUserCode,
                           NormalResetPasswordDTO normalResetPasswordDTO,
                           Model model) {

        // 세션에 userCode가 null이면 로그인 페이지로 이동
        if(fgUserCode == null) {
            return "redirect:/normal/regular/userLogin";
        }

        return "/mypage/regular/userResetPassword";
    }

//
// 비밀번호 변경 <POST 요청>
//
//@PostMapping("/resetPw")
//public String resetPassword(HttpSession session, @SessionAttribute(value="fgUserCode", required = false) Long fgUserCode,
//                            NormalResetPasswordDTO normalResetPasswordDTO,
//                            RedirectAttributes redirectAttributes,
//                            Model model) {
//
//
//    // 업체 정보 변경하기 메서드 호출
//    normalMyService.changeNormalPassword(normalResetPasswordDTO);
//    session.invalidate();
//
//    return "redirect:/seller/my/storeModify";
//}




}


