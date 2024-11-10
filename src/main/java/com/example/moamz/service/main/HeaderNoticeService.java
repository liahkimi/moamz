package com.example.moamz.service.main;

import com.example.moamz.domain.dto.main.HeaderNoticeDTO;
import com.example.moamz.mapper.main.HeaderNoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HeaderNoticeService {

    private final HeaderNoticeMapper headerNoticeMapper;

    // HeaderNotice 정보를 조회하는 메서드
    public List<HeaderNoticeDTO> getHeaderNotices() {
        // MyBatis 매퍼를 통해 DB에서 알림 정보를 조회
        return headerNoticeMapper.selectHeaderNotice();
    }
}
