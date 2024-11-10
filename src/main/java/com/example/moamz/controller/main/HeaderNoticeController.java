package com.example.moamz.controller.main;

import com.example.moamz.domain.dto.main.HeaderNoticeDTO;
import com.example.moamz.service.main.HeaderNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/main/header")
public class HeaderNoticeController {

    private final HeaderNoticeService headerNoticeService;

    // GET /main/fragment/header/notices
    @GetMapping("/notification")
    public ResponseEntity<List<HeaderNoticeDTO>> getHeaderNotices() {
        // 서비스에서 알림 데이터를 조회
        List<HeaderNoticeDTO> headerNotices = headerNoticeService.getHeaderNotices();
        // 조회된 데이터를 응답으로 반환
        return ResponseEntity.ok(headerNotices);
    }
}
