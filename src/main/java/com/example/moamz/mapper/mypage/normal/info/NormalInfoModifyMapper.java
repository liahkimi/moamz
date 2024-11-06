package com.example.moamz.mapper.mypage.normal.info;

import com.example.moamz.domain.dto.mypage.normal.info.NormalInfoModifyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NormalInfoModifyMapper {
    List<NormalInfoModifyDTO> selectNormalInfoModify();

    void updateNormalPassword(NormalInfoModifyDTO normalInfoModifyDTO);
}
