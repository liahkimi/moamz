package com.example.moamz.mapper.mypage.normal.inquiry;

import com.example.moamz.domain.dto.mypage.normal.inquiry.AdminInquiryWriteDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminInquiryWriteMapper {
    void insertInquiryWrite(AdminInquiryWriteDTO adminInquiryWriteDTO);
}
