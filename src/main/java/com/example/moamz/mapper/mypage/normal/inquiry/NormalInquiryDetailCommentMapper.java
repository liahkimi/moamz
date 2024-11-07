package com.example.moamz.mapper.mypage.normal.inquiry;

import com.example.moamz.domain.dto.mypage.normal.inquiry.NormalInquiryDetailCommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NormalInquiryDetailCommentMapper {
    List<NormalInquiryDetailCommentDTO> selectInquiryDetailComment();
}
