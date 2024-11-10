package com.example.moamz.service.main;

import com.example.moamz.domain.dto.main.MainNoticeDetailDTO;
import com.example.moamz.mapper.main.MainNoticeDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainNoticeDetailService {
    private final MainNoticeDetailMapper mainNoticeDetailMapper;

    // 공지사항 상세 조회
    public MainNoticeDetailDTO getNoticeDetail(Long fgPostId) {
        // Mapper에서 fgPostId에 해당하는 공지사항 상세 조회
        return mainNoticeDetailMapper.selectMainNoticeDetail(fgPostId);
    }
}
