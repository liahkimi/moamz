package com.example.moamz.controller.user.normal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/normal")
public class NormalResetPasswordController {

    @GetMapping("/resetPassword")
    public String resetPassword() {return "/user/regular/userFindPassword";}

}
