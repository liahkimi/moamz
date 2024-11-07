package com.example.moamz.mapper.mypage.normal.info;

import com.example.moamz.domain.dto.mypage.normal.info.NormalInfoAuthDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NormalInfoAuthMapper {
    List<NormalInfoAuthDTO> selectInfoAuth();
}
