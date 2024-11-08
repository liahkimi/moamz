package com.example.moamz.mapper.user.seller;

import com.example.moamz.domain.dto.user.seller.SellerResetPasswordDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface SellerFindIdMapper {

    Optional<String> selectPassword(@Param("fgUSerId") String fgUSerId,
                                    @Param("fgSellerPhone") String fgSellerPhone);

    int updatePassword(SellerResetPasswordDTO sellerResetPasswordDTO);



}
