//package com.example.moamz.controller.user.normal;
//
//import com.example.moamz.service.user.normal.CoolSmsService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@Slf4j
//@RequestMapping("/normal")
//public class CoolSmsController {
//    private final CoolSmsService coolSmsService;
//
//    public CoolSmsController(CoolSmsService coolSmsService) {
//        this.coolSmsService = coolSmsService;
//    }
//
//    @GetMapping("/send-auth-code")
//    public String sendAuthCode(@RequestParam String phone) {
//        return coolSmsService.sendAuthCode(phone);
//    }
//
////    // coolSMS 테스트 화면
////    @GetMapping("/sms")
////    public String mySms() {
////        return "order/sms";
////    }
////
////    // coolSMS 구현 로직 연결
////    @GetMapping("/check/sendSMS")
////    public @ResponseBody String sendSMS(@RequestParam(value="to") String to) throws CoolsmsException {
////        return coolSmsService.PhoneNumberCheck(to);
////    }
//
//}
