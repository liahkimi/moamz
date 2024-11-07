package com.example.moamz.mapper.mypage.normal.inquiry;

import com.example.moamz.domain.dto.mypage.normal.inquiry.NormalInquiryWriteDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NormalInquiryWriteMapper {
    void insertInquiryWrite(NormalInquiryWriteDTO adminInquiryWriteDTO);
}
