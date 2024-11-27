package com.example.moamz.mapper.mypage.normal.inquiry;

import com.example.moamz.domain.dto.mypage.normal.inquiry.NormalInquiryDetailCommentDTO;
import com.example.moamz.domain.dto.mypage.normal.inquiry.NormalInquiryDetailDTO;
import com.example.moamz.domain.dto.mypage.normal.inquiry.NormalInquiryListDTO;
import com.example.moamz.domain.dto.mypage.normal.inquiry.NormalInquiryWriteDTO;

import java.util.List;
import java.util.Optional;

public interface NormalInquiryMapper {
    // 문의글 작성 (inquiry)
    void insertInquiryWrite(NormalInquiryWriteDTO normalInquiryWriteDTO);

    // 문의글 작성 (post)
    void insertInquiryPost(NormalInquiryWriteDTO normalInquiryWriteDTO);

    // 문의글 삭제
    void normalDeleteInquiry(Long fgPostId);

    // 문의글 목록
    List<NormalInquiryListDTO> selectNormalInquiryList(Long fgUserCode);

    // 회원이 작성한 문의글 수
    int selectNormalTotal(Long fgUserCode);

    // 문의글 상세
    Optional<NormalInquiryDetailDTO> selectNormalInquiryDetail(Long fgPostId);

    // 문의글 댓글
    List<NormalInquiryDetailCommentDTO> selectInquiryDetailComment(Long fgPostId);
}
