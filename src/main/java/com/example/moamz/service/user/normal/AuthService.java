//package com.example.moamz.service.user.normal;
//
//import org.springframework.stereotype.Service;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class AuthService {
//
//    private final CoolSmsService coolSmsService;
//    private Map<String, String> authCodeMap = new HashMap<>();  // 전화번호별 인증 코드 저장
//
//    public AuthService(CoolSmsService coolSmsService) {
//        this.coolSmsService = coolSmsService;
//    }
//
//    public String requestAuthCode(String phone) {
//        // 인증 코드 전송
//        String authCode = coolSmsService.sendAuthCode(phone);
//        authCodeMap.put(phone, authCode);  // 인증 코드 저장
//        return "인증 코드가 전송되었습니다.";
//    }
//
//    public String verifyAuthCode(String phone, String inputCode) {
//        String actualCode = authCodeMap.get(phone);
//        if (actualCode != null && actualCode.equals(inputCode)) {
//            return "인증 성공";
//        } else {
//            return "인증 실패";
//        }
//    }
//}
