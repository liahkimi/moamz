package com.example.moamz.mapper.main;

import com.example.moamz.domain.dto.main.NoticeDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeDetailMapper {
    List<NoticeDetailDTO> selectNoticeDetail();
}
