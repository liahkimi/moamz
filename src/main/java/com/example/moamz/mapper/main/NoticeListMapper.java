package com.example.moamz.mapper.main;

import com.example.moamz.domain.dto.main.NoticeListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeListMapper {
    List<NoticeListDTO> selectNoticeList();
}
