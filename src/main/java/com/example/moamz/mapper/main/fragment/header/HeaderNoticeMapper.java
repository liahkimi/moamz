package com.example.moamz.mapper.main.fragment.header;

import com.example.moamz.domain.dto.main.HeaderNoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HeaderNoticeMapper {
    List<HeaderNoticeDTO> selectHeaderNotice();
}
