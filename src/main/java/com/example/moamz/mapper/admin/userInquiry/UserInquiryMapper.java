package com.example.moamz.mapper.admin.userInquiry;

import com.example.moamz.domain.dto.admin.adminCommentDTO;
import com.example.moamz.domain.dto.admin.userInquiry.AdminUserInquiryDetailDTO;
import com.example.moamz.domain.dto.admin.userInquiry.AdminUserInquiryListDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserInquiryMapper {
    //일반회원 미확인 문의목록 보여주기
    List<AdminUserInquiryListDTO> selectUncheckedInquiryList();

    //일반회원 답변완료한 문의목록 보여주기
    List<AdminUserInquiryListDTO> selectAnsweredInquiryList();

    //일반회원 특정 문의글 상세보기
    Optional<AdminUserInquiryDetailDTO> selectUserInquiryDetailById(@Param("fgPostId") Long fgPostId);

    //일반회원 특정 문의글 상세보기에 있는 댓글 보기
    Optional<adminCommentDTO> selectUserInquiryDetailCommentById(@Param("fgPostId") Long fgPostId);
}
