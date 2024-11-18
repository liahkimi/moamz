package com.example.moamz.mapper.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryCommentDTO;
import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryDetailDTO;
import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryListDTO;
import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryWriteDTO;
import com.example.moamz.domain.dto.page.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SellerInquiryMapper {
    // 문의글 작성(POST)
    void insertPost(InquiryWriteDTO inquiryWriteDTO);

    // 문의글 작성(inquiry)
    void insertInquiry(InquiryWriteDTO inquiryWriteDTO);

    // 문의글 삭제
    void deleteInquiry(Long postId);

    // 문의글 목록
    List<InquiryListDTO> selectInquiryList(Long userCode);

    // 문의글 목록 (페이지네이션O)
    List<InquiryListDTO> selectInquiryListAll(@Param("criteria") Criteria criteria, @Param("userCode") Long userCode);

    // 회원이 작성한 문의글 수
    int selectTotal(Long userCode);

    // 문의글 상세
    Optional<InquiryDetailDTO> selectInquiryDetail(Long postId);

    // 문의글 댓글
    List<InquiryCommentDTO> selectInquiryComment(Long postId);
}
