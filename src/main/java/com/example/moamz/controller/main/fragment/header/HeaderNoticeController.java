//package com.example.moamz.controller.main.fragment.header.HeaderNoticeController;
//
//import java.util.List;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/header")
//public class HeaderNoticeController {
//
//    private final HeaderNoticeService headerNoticeService;
//
//    @GetMapping("/notice")
//    public ResponseEntity<List<HeaderNoticeResponse>> getHeaderNotices(
//            @RequestBody HeaderNoticeRequest headerNoticeRequest
//    ) {
//        return ResponseEntity.ok(headerNoticeService.getHeaderNotice(headerNoticeRequest));
//    }
//}
