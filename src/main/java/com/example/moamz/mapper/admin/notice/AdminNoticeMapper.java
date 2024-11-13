package com.example.moamz.mapper.admin.notice;

import com.example.moamz.domain.dto.admin.notice.AdminNoticeDetailDTO;
import com.example.moamz.domain.dto.admin.notice.AdminNoticeListDTO;
import com.example.moamz.domain.dto.admin.notice.AdminNoticeModifyDTO;
import com.example.moamz.domain.dto.admin.notice.AdminNoticeWriteDTO;
import com.example.moamz.domain.dto.page.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

//@Mapper
//public interface AdminNoticeMapper {
//    // 공지사항 글 작성하기1(공통게시글 테이블)
//    void insertNoticePost(AdminNoticeWriteDTO noticeWriteDTO);
//
//    // 공지사항 글 작성하기2(notice 테이블)
//    void insertNotice(AdminNoticeWriteDTO noticeWriteDTO);
//
//    // 공지사항 글 수정하기
//    void modifyNotice(@Param("AdminNoticeModifyDTO") AdminNoticeModifyDTO noticeModifyDTO);
//
//    // 공지사항 글 삭제하기
//    void deleteNotice(@Param("fgPostId") Long fgPostId);
//
//    // 공지사항 글 상세보기
//    Optional<AdminNoticeDetailDTO> selectNoticeById(@Param("fgPostId") Long fgPostId);
//
//    // 공지사항 목록 보기
//    List<AdminNoticeListDTO> selectNoticeAll();
//
//    // 공지사항 글 총 갯수 조회
//    int selectNoticeTotal();
//
//
//}
@Mapper
public interface AdminNoticeMapper {
    // 공지사항 글 작성하기1(공통게시글 테이블)
    void insertNoticePost(AdminNoticeWriteDTO adminNoticeWriteDTO);

    // 공지사항 글 작성하기2(notice 테이블)
    void insertNotice(AdminNoticeWriteDTO adminNoticeWriteDTO);

    // 공지사항 글 수정하기-게시글공통테이블 update
    void modifyNotice(AdminNoticeModifyDTO adminNoticeModifyDTO);

    //공지사항 글 수정하기-공지사항테이블 update
    void modifyNoticeReal(AdminNoticeModifyDTO adminNoticeModifyDTO);

    // 공지사항 글 삭제하기
    void deleteNotice(@Param("fgPostId") Long fgPostId);

    // 공지사항 글 상세보기
    Optional<AdminNoticeDetailDTO> selectNoticeById(@Param("fgPostId") Long fgPostId);

    // 공지사항 목록 보기
    List<AdminNoticeListDTO> selectNoticeAll();

    // 공지사항 글 총 갯수 조회
    int selectNoticeTotal();

    // 모든 공지사항 페이지 목록 보기
    List<AdminNoticeListDTO> selectAllNoticePage(Criteria criteria);
}
