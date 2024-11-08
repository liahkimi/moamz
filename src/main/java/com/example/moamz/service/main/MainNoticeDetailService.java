package com.example.moamz.service.main;

import com.example.moamz.domain.dto.main.MainNoticeDetailDTO;
import com.example.moamz.domain.dto.main.MainNoticeListDTO;
import com.example.moamz.mapper.main.MainNoticeDetailMapper;
import com.example.moamz.mapper.main.MainNoticeDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainNoticeDetailService {
    private final MainNoticeDetailMapper mainNoticeDetailMapper;

    // 공지사항 상세보기 페이지로 이동
//    MainNoticeDetailDTO selectMainNoticeDetail(Long fgPostId);


    // 공지사항 상세 조회
    public List<MainNoticeDetailDTO> getMainNoticeDetail() {
        return mainNoticeDetailMapper.selectMainNoticeDetail();
    }
//    BoardDTO selectBoardDetail(Long boardId, CustomOAuth2User customUser);
}
