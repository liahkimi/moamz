//package com.example.moamz.service.user.normal;
//
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import net.nurigo.java_sdk.api.Message;
//import net.nurigo.java_sdk.exceptions.CoolsmsException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Random;
//
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//@AllArgsConstructor
//public class CoolSmsService {
//
//    @Value("${NCSHY7GOUORRBG7D}")
//    private String apiKey;
//
//    @Value("${ATX63JHOP6SNVCJAWPFHZXHMYI8ULYBO}")
//    private String apiSecret;
//
//    @Value("${01071286831}")
//    private String fromPhone;
//
//    public String sendVerificationMessage(String to) throws CoolsmsException {
//        Message coolsms = new Message(apiKey, apiSecret);
//
//        String verificationCode = generateVerificationCode();
//        String message = String.format("인증번호 [%s]를 입력해주세요.", verificationCode);
//
//        // Cool SMS 메시지 발송
//        HashMap<String, String> params = new HashMap<>();
//        params.put("to", to);
//        params.put("from", fromPhone);
//        params.put("type", "SMS");
//        params.put("text", message);
//
//        coolsms.send(params);
//
//        return verificationCode;
//    }
//
//    //  랜덤으로 인증번호 생성 코드
//    private String generateVerificationCode() {
//        Random random = new Random();
//        return String.format("%06d", random.nextInt(1000000));
//    }
//
//
////    @Value("${coolsms.api.key}")
////    private String apiKey;
////
////    @Value("${coolsms.api.secret}")
////    private String apiSecret;
////
////    @Value("${coolsms.from.phone}")
////    private String fromPhone;
////
////    public void smsTest(String apiKey, String fromPhone){
////        System.out.println("======== sms확인 ==== : " + apiKey + ", fromPhone: " + fromPhone);
////    }
////    public String sendSms(String toPhone, String message) {
////        Coolsms coolsms = new Coolsms(apiKey, apiSecret);
////        String result = coolsms.send(fromPhone, toPhone, message);
////        return result;
////    }
////
////    public String sendAuthCode(String toPhone) {
////        String authCode = generateAuthCode();  // 인증 코드 생성
////        String message = "인증 코드: " + authCode;
////        return sendSms(toPhone, message);
////    }
////
////    private String generateAuthCode() {
////        // 인증 코드 생성 로직 (예: 랜덤한 6자리 숫자)
////        return String.format("%06d", (int) (Math.random() * 1000000));
////    }
//
////    public String PhoneNumberCheck(String to) throws CoolsmsException {
////
////        String api_key = "NCSHY7GOUORRBG7D";
////        String api_secret = "ATX63JHOP6SNVCJAWPFHZXHMYI8ULYBO";
////        Message coolsms = new Message(api_key, api_secret);
////
////        Random rand  = new Random();
////        String numStr = "";
////        for(int i=0; i<4; i++) {
////            String ran = Integer.toString(rand.nextInt(10));
////            numStr+=ran;
////        }
////
////        HashMap<String, String> params = new HashMap<String, String>();
////        params.put("to", to);    // 수신전화번호 (ajax로 화면에서 받아온 값으로 넘김)
////        params.put("from", "01072791324");    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
////        params.put("type", "sms");
////        params.put("text", "인증번호는 [" + numStr + "] 입니다.");
////
////        coolsms.send(params); // 메시지 전송
////
////        return numStr;
////
////    }
//
//}
