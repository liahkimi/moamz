package com.example.moamz.mapper.mypage.normal.info;

import com.example.moamz.domain.dto.mypage.normal.info.NormalWithdrawDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NormalWithdrawMapper {
    void deleteWithdraw(Long fgUserCode);
}
