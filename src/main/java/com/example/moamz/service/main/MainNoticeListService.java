package com.example.moamz.service.main;

import com.example.moamz.domain.dto.main.MainNoticeListDTO;
import com.example.moamz.mapper.main.MainNoticeListMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainNoticeListService {
    private final MainNoticeListMapper mainNoticeListMapper;

    // 공지사항 목록 조회
    public List<MainNoticeListDTO> getMainNoticeList() {
        return mainNoticeListMapper.selectMainNoticeList();
    }

}
