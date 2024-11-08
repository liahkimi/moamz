package com.example.moamz.mapper.user.normal;

import com.example.moamz.domain.dto.user.normal.NormalFindIdDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface NormalFindIdMapper {

//    Optional<String> selectFindId(@Param("fgUserPassword") String fgUSerId, @Param("fgUserPassword") String fgUserPassword);
    Optional<NormalFindIdDTO> selectFindId(@Param("fgNormalName")String fgNormalName,
                                           @Param("fgNormalPhone") String fgNormalPhone,
                                           @Param("fgUserId") String fgUserId);
}
