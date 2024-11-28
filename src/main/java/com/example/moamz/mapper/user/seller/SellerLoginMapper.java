package com.example.moamz.mapper.user.seller;

import com.example.moamz.domain.dto.user.seller.SellerSessionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface SellerLoginMapper {

    Optional<Long> selectId(@Param("fgUserId")String fgUserId, @Param("fgUserPassword") String fgUserPassword);

    Optional<SellerSessionDTO> selectLoginInfo(@Param("fgUserId") String fgUserId,

                                                   @Param("fgUserPassword") String fgUserPassword);

    //로그인 아아디, 비밀번호 확인
    Optional<String> loginCheck(@Param("fgUserId") String fgUserId,
                                     @Param("fgUserPassword") String fgUserPassword);
}
