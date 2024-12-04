package com.example.moamz.controller.admin.sessionCheck;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("/api")
public class AdminSessionController {

    @GetMapping("/checkSession")
    public ResponseEntity<Void> checkSession(@SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode) {
//        // 세션에서 로그인 정보를 확인 (세션에 "user"가 없다면 로그인되지 않은 상태)
//        Object user = session.getAttribute("user");
        if (fgUserCode == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // 401 Unauthorized 반환
        }
        return ResponseEntity.ok().build(); // 세션이 있으면 200 OK 반환
    }
}

