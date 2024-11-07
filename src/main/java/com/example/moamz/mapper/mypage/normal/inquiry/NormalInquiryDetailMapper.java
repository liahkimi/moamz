package com.example.moamz.mapper.mypage.normal.inquiry;

import com.example.moamz.domain.dto.mypage.normal.inquiry.NormalInquiryDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NormalInquiryDetailMapper {
    List<NormalInquiryDetailDTO> selectInquiryDetail();
}
