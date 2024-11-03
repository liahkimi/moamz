package com.example.moamz.service.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryCommentDTO;
import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryDetailDTO;
import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryListDTO;
import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryWriteDTO;
import com.example.moamz.mapper.mypage.seller.SellerInquiryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class SellerInquiryService {
    public final SellerInquiryMapper sellerInquiryMapper;

    // 문의글 등록 메서드
    public void registerInquiry(InquiryWriteDTO inquiryWriteDTO) {
        sellerInquiryMapper.insertInquiry(inquiryWriteDTO);
    }

    // 문의글 삭제 메서드
    public void removeInquiry(Long postId) {
        sellerInquiryMapper.deleteInquiry(postId);
    }

    // 문의글 목록 가져오기 메서드
    public List<InquiryListDTO> findInquiryList(Long userCode) {
        return sellerInquiryMapper.selectInquiryList(userCode);
    }

    // 문의글 상세보기 메서드
    public InquiryDetailDTO findInquiryDetail(Long postId) {
        return sellerInquiryMapper.selectInquiryDetail(postId)
                .orElseThrow(() -> new IllegalStateException("❌❌❌유효하지 않은 게시글입니다."));
    }

    // 문의글 댓글 가져오기 메서드
    public List<InquiryCommentDTO> findInquiryComment(Long postId) {
        return sellerInquiryMapper.selectInquiryComment(postId);
    }



}
