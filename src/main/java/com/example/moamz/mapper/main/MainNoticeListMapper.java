package com.example.moamz.mapper.main;

import com.example.moamz.domain.dto.main.MainNoticeListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainNoticeListMapper {
    List<MainNoticeListDTO> selectMainNoticeList();
}
