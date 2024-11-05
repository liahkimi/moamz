package com.example.moamz.mapper.admin.notice;

import com.example.moamz.domain.dto.admin.notice.NoticeDetailDTO;
import com.example.moamz.domain.dto.admin.notice.NoticeListDTO;
import com.example.moamz.domain.dto.admin.notice.NoticeModifyDTO;
import com.example.moamz.domain.dto.admin.notice.NoticeWriteDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NoticeMapper {
    // 공지사항 글 작성하기1(공통게시글 테이블)
    void insertNoticePost(@Param("NoticeWriteDTO") NoticeWriteDTO noticeWriteDTO);

    // 공지사항 글 작성하기2(notice 테이블)
    void insertNotice(@Param("NoticeWriteDTO") NoticeWriteDTO noticeWriteDTO);

    // 공지사항 글 수정하기
    void modifyNotice(@Param("NoticeModifyDTO") NoticeModifyDTO noticeModifyDTO);

    // 공지사항 글 삭제하기
    void deleteNotice(@Param("fgPostId") Long fgPostId);

    // 공지사항 글 상세보기
    Optional<NoticeDetailDTO> selectNoticeById(@Param("fgPostId") Long fgPostId);

    // 공지사항 목록 보기
    List<NoticeListDTO> selectNoticeAll();

    // 공지사항 글 총 갯수 조회
    int selectNoticeTotal();


}
