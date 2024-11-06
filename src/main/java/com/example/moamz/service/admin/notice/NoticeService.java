package com.example.moamz.service.admin.notice;

import com.example.moamz.domain.dto.admin.notice.AdminNoticeDetailDTO;
import com.example.moamz.domain.dto.admin.notice.AdminNoticeListDTO;
import com.example.moamz.domain.dto.admin.notice.AdminNoticeModifyDTO;
import com.example.moamz.domain.dto.admin.notice.AdminNoticeWriteDTO;
import com.example.moamz.mapper.admin.notice.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class NoticeService {
    private final NoticeMapper noticeMapper;

    //공지사항 작성하기
    public void registerNotice(AdminNoticeWriteDTO adminNoticeWriteDTO){
        //공통 post테이블에 데이터 삽입
        noticeMapper.insertNoticePost(adminNoticeWriteDTO);
        //notice테이블에 데이터 삽입
        noticeMapper.insertNotice(adminNoticeWriteDTO);
    }

    //공지사항 글 상세보기
    public AdminNoticeDetailDTO findNoticeById(Long fgPostId){
        return noticeMapper.selectNoticeById(fgPostId).orElseThrow(() -> new IllegalStateException("유효하지 않은 게시물"));
    }

    //공지사항 목록 보기
    public List<AdminNoticeListDTO> findNoticeAll(){
        return noticeMapper.selectNoticeAll();
    }

    //공지사항 글 총갯수 구하기
    public int findNoticeTotal(){
        return noticeMapper.selectNoticeTotal();
    }

    //공지사항 글 수정하기
    public void modifyNotice(AdminNoticeModifyDTO adminNoticeModifyDTO)throws IOException {
        noticeMapper.modifyNotice(adminNoticeModifyDTO);
        noticeMapper.modifyNoticeReal(adminNoticeModifyDTO);
        Long fgPostId = adminNoticeModifyDTO.getFgPostId();
    }

    //공지사항 글 삭제하기
    public void removeNotice(Long fgPostId){
        noticeMapper.deleteNotice(fgPostId);
    }









}
