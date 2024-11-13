package com.example.moamz.controller.user.normal;

import com.example.moamz.domain.dto.user.normal.NormalCommonSignupDTO;
import com.example.moamz.domain.dto.user.normal.NormalPointDTO;
import com.example.moamz.domain.dto.user.normal.NormalUserSignupDTO;
import com.example.moamz.service.user.normal.NormalSignupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/normal")
public class NormalSignupController {
    private final NormalSignupService normalSignupService;

    @GetMapping("regular/userSignup")
    public String join() {
        return "/user/regular/userSignup";
    }

    @PostMapping("regular/userSignup")
    public String join(@ModelAttribute NormalCommonSignupDTO normalCommonSignupDTO,
                       @ModelAttribute NormalUserSignupDTO normalUserSignupDTO,
                       @ModelAttribute NormalPointDTO normalPointDTO,
                       @RequestParam("file") MultipartFile file) throws IOException {
        //@ModelAttribute : 요청전에 모델에 특정 속성을 추가할 수 있음
        //요청 매개변수를 모델 객체로 바인딩, 컨트롤러 메소드가 실행되기 전 모델에 데이터를 추가할 때(모델 추가)
        //요청전에 모델 객체 초기화
        normalSignupService.userSignup(normalCommonSignupDTO,
                normalUserSignupDTO,
                normalPointDTO,
                file);

        return "redirect:/normal/regular/userLogin";
    }

    //아이디 중복체크
    @PostMapping("/regular/checkId")
    @ResponseBody
    public String checkedId(@RequestParam("checkedId") String fgUserId) {
        log.info("😀😀😀😀😀😀userId:{}", fgUserId);
        String userId = normalSignupService.checkedId(fgUserId);
        if (userId != null) {
            return userId + "는 이미 존재하는 아이디입니다";  // 아이디 확인
        } else {
            return "사용할 수 있는 아이디입니다.";  // 실패 시 메시지
        }
    }

    //닉네임 중복체크
    @PostMapping("/regular/checkNickname")
    @ResponseBody
    public String checkedNickname(@RequestParam("checkedNickname") String fgNormalNickname) {
        log.info("😀😀😀😀😀😀userId:{}", fgNormalNickname);
        String userNickname = normalSignupService.checkedNickname(fgNormalNickname);
        if (userNickname != null) {
            return userNickname + "는 이미 존재하는 닉네임입니다";  // 아이디 확인
        } else {
            return "사용할 수 있는 닉네임입니다.";  // 실패 시 메시지
        }
    }

}
