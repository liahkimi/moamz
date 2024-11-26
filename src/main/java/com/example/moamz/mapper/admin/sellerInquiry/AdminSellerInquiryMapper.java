package com.example.moamz.mapper.admin.sellerInquiry;

import com.example.moamz.domain.dto.admin.AdminCommentDTO;
import com.example.moamz.domain.dto.admin.sellerInquiry.AdminSellerInquiryDetailDTO;
import com.example.moamz.domain.dto.admin.sellerInquiry.AdminSellerInquiryListDTO;
import com.example.moamz.domain.dto.admin.userInquiry.AdminUserInquiryListDTO;
import com.example.moamz.domain.dto.page.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminSellerInquiryMapper {
    //판매자 미확인 문의목록 보여주기
    List<AdminSellerInquiryListDTO> selectInquiryList();

//    //판매자 답변완료 문의목록 보여주기
//    List<AdminSellerInquiryListDTO>selectAnsweredInquiryList();

    //판매자 특정 문의글 상세보기
    Optional<AdminSellerInquiryDetailDTO> selectUserInquiryDetailById(@Param("fgPostId") Long fgPostId);

    //판매자 특정 문의글 상세보기의 댓글보기
    Optional<AdminCommentDTO> selectUserInquiryDetailCommentById(@Param("fgPostId") Long fgPostId);


    // 판매자 답변상태 변경시키기
    void changeStatusBtn(@Param("fgPostId") Long fgPostId);

    // 판매자 문의글 총 갯수 조회
    int selectSellerInquiryTotal();

    // 모든 판매자 문의 페이지 목록 보기
    List<AdminSellerInquiryListDTO> selectAllSellerInquiryPage(Criteria criteria);


}
