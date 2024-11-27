package com.example.moamz.service.mypage.normal;

import com.example.moamz.domain.dto.mypage.normal.inquiry.NormalInquiryDetailCommentDTO;
import com.example.moamz.domain.dto.mypage.normal.inquiry.NormalInquiryDetailDTO;
import com.example.moamz.domain.dto.mypage.normal.inquiry.NormalInquiryListDTO;
import com.example.moamz.domain.dto.mypage.normal.inquiry.NormalInquiryWriteDTO;
import com.example.moamz.mapper.mypage.normal.inquiry.NormalInquiryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class NormalInquiryService {
    public final NormalInquiryMapper normalInquiryMapper;

    // 문의글 등록 메서드
    public void normalRegistInquiry(NormalInquiryWriteDTO normalInquiryWriteDTO) {
        // fg_post에 데이터 삽입
        normalInquiryMapper.insertInquiryPost(normalInquiryWriteDTO);
        // FG_inquiry 에 데이터 삽입
        normalInquiryMapper.insertInquiryWrite(normalInquiryWriteDTO);
    }

    // 문의글 삭제 메서드
    public void normalRemoveInquiry(Long fgPostId) {normalInquiryMapper.normalDeleteInquiry(fgPostId);}


    // 문의글 내역 조회 (회원 코드로 조회)
    public List<NormalInquiryListDTO> getNormalInquiryList(Long fgUserCode){
//        List<NormalInquiryListDTO> list = normalInquiryMapper.selectNormalInquiryList(fgUserCode);
        return normalInquiryMapper.selectNormalInquiryList(fgUserCode);
    }

    // 문의글 상세보기 메서드
    public NormalInquiryDetailDTO findNormalInquiryDetail(Long fgPostId) {
        return normalInquiryMapper.selectNormalInquiryDetail(fgPostId)
                .orElseThrow(() -> new IllegalStateException("유효하지 않은 게시글입니다."));
    }

    // 회원이 작성한 문의글 수
    public int findNormalTotal(Long fgUserCode) {
        return normalInquiryMapper.selectNormalTotal(fgUserCode);
    }

    // 문의글 댓글 가져오기 메서드
    public List<NormalInquiryDetailCommentDTO> findNormalInquiryDetailComment(Long fgPostId) {
        return normalInquiryMapper.selectInquiryDetailComment(fgPostId);
    }
}
