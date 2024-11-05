package com.example.moamz.service.admin.notice;

import com.example.moamz.domain.dto.admin.notice.NoticeDetailDTO;
import com.example.moamz.domain.dto.admin.notice.NoticeListDTO;
import com.example.moamz.domain.dto.admin.notice.NoticeWriteDTO;
import com.example.moamz.mapper.admin.notice.NoticeMapper;
import com.example.moamz.mapper.file.PostFileMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class NoticeService {
    private final NoticeMapper noticeMapper;

    //공지사항 작성하기
    public void registerNotice(NoticeWriteDTO noticeWriteDTO){
        //공통 post테이블에 데이터 삽입
        noticeMapper.insertNoticePost(noticeWriteDTO);
        //notice테이블에 데이터 삽입
        noticeMapper.insertNotice(noticeWriteDTO);

    }

    //공지사항 글 상세보기
    public NoticeDetailDTO findNoticeById(Long fgPostId){
        return noticeMapper.selectNoticeById(fgPostId).orElseThrow(() -> new IllegalStateException("유효하지 않은 게시물"));
    }

    //공지사항 목록 보기
    public List<NoticeListDTO> findNoticeAll(){
        return noticeMapper.selectNoticeAll();
    }

    //공지사항 글 총갯수 구하기
    public int findNoticeTotal(){
        return noticeMapper.selectNoticeTotal();
    }
}
