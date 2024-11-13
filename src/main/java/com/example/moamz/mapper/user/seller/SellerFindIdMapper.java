package com.example.moamz.mapper.user.seller;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface SellerFindIdMapper {

    Optional<String> selectFindId(@Param("fgSellerName") String fgSellerName,
                                    @Param("fgSellerPhone") String fgSellerPhone);

}
