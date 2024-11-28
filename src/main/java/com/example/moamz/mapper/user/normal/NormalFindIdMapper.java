package com.example.moamz.mapper.user.normal;

import com.example.moamz.domain.dto.user.normal.NormalFindIdDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface NormalFindIdMapper {

//    Optional<String> selectFindId(@Param("fgUserId") String fgUSerId, @Param("fgUserPassword") String fgUserPassword);
    Optional<String> selectFindId(@Param("fgNormalName")String fgNormalName,
                                           @Param("fgNormalPhone") String fgNormalPhone);
}
