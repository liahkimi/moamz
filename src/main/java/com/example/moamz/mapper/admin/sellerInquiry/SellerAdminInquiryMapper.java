package com.example.moamz.mapper.admin.sellerInquiry;

import com.example.moamz.domain.dto.admin.adminCommentDTO;
import com.example.moamz.domain.dto.admin.sellerInquiry.AdminSellerInquiryDetailDTO;
import com.example.moamz.domain.dto.admin.sellerInquiry.AdminSellerInquiryListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SellerAdminInquiryMapper {
    //판매자 미확인 문의목록 보여주기
    List<AdminSellerInquiryListDTO> selectUncheckedInquiryList();

    //판매자 답변완료 문의목록 보여주기
    List<AdminSellerInquiryListDTO>selectAnsweredInquiryList();

    //판매자 특정 문의글 상세보기
    Optional<AdminSellerInquiryDetailDTO> selectUserInquiryDetailById(@Param("fgPostId") Long fgPostId);

    //판매자 특정 문의글 상세보기의 댓글보기
    Optional<adminCommentDTO> selectUserInquiryDetailCommentById(@Param("fgPostId") Long fgPostId);

}
