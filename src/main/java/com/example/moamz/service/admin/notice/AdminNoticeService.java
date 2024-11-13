package com.example.moamz.service.admin.notice;

import com.example.moamz.domain.dto.admin.notice.AdminNoticeDetailDTO;
import com.example.moamz.domain.dto.admin.notice.AdminNoticeListDTO;
import com.example.moamz.domain.dto.admin.notice.AdminNoticeModifyDTO;
import com.example.moamz.domain.dto.admin.notice.AdminNoticeWriteDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.mapper.admin.notice.AdminNoticeMapper;
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
public class AdminNoticeService {
    private final AdminNoticeMapper adminNoticeMapper;

    //공지사항 작성하기
    public void registerNotice(AdminNoticeWriteDTO adminNoticeWriteDTO){
        //공통 post테이블에 데이터 삽입
        adminNoticeMapper.insertNoticePost(adminNoticeWriteDTO);
        //notice테이블에 데이터 삽입
        adminNoticeMapper.insertNotice(adminNoticeWriteDTO);
    }

    //공지사항 글 상세보기
    public AdminNoticeDetailDTO findNoticeById(Long fgPostId){
        return adminNoticeMapper.selectNoticeById(fgPostId).orElseThrow(() -> new IllegalStateException("유효하지 않은 게시물"));
    }

    //공지사항 목록 보기
    public List<AdminNoticeListDTO> findNoticeAll(){
        return adminNoticeMapper.selectNoticeAll();
    }

    //공지사항 글 총갯수 구하기
    public int findNoticeTotal(){
        return adminNoticeMapper.selectNoticeTotal();
    }

    //공지사항 글 수정하기
    public void modifyNotice(AdminNoticeModifyDTO adminNoticeModifyDTO)throws IOException {
        adminNoticeMapper.modifyNotice(adminNoticeModifyDTO);
        adminNoticeMapper.modifyNoticeReal(adminNoticeModifyDTO);
        Long fgPostId = adminNoticeModifyDTO.getFgPostId();
    }

    //공지사항 글 삭제하기
    public void removeNotice(Long fgPostId){
        adminNoticeMapper.deleteNotice(fgPostId);
    }


    //모든 공지사항 페이지 목록 보기
    public List<AdminNoticeListDTO> findAllNoticePage(Criteria criteria){
        return adminNoticeMapper.selectAllNoticePage(criteria);
    }







}
