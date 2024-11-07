package com.example.moamz.controller.user.normal;

import com.example.moamz.domain.dto.user.normal.NormalSignupDTO;
import com.example.moamz.service.user.normal.NormalSignupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String join(@ModelAttribute NormalSignupDTO normalSignupDTO) {
        //@ModelAttribute : 요청전에 모델에 특정 속성을 추가할 수 있음
        //요청 매개변수를 모델 객체로 바인딩, 컨트롤러 메소드가 실행되기 전 모델에 데이터를 추가할 때(모델 추가)
        //요청전에 모델 객체 초기화
        log.info("userDTO = {}", normalSignupDTO);
        normalSignupService.insertCommonUser(normalSignupDTO);
        normalSignupService.insertNormalUser(normalSignupDTO);
        normalSignupService.insertUserFile(normalSignupDTO);
        normalSignupService.insertPoint(normalSignupDTO);
        return "redirect:/normal/regular/userLogin";
    }
}
