//package com.example.moamz.controller.user.normal;
//import com.example.moamz.service.user.normal.AuthService;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class AuthController {
//
//    private final AuthService authService;
//
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @GetMapping("/send-auth-code")
//    public String requestAuthCode(@RequestParam String phone) {
//        return authService.requestAuthCode(phone);
//    }
//
//    @PostMapping("/verify-auth-code")
//    public String verifyAuthCode(@RequestParam String phone, @RequestParam String code) {
//        return authService.verifyAuthCode(phone, code);
//    }
//}
