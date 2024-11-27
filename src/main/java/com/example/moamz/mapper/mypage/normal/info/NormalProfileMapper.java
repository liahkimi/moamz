package com.example.moamz.mapper.mypage.normal.info;

import com.example.moamz.domain.dto.mypage.normal.info.NormalProfileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NormalProfileMapper {
    List<NormalProfileDTO> selectProfile(Long fgUserCode);
}
