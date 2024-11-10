package com.example.moamz.mapper.user.seller;

import com.example.moamz.domain.dto.file.UserFileDTO;
import com.example.moamz.domain.dto.user.seller.SellerBusinessDTO;
import com.example.moamz.domain.dto.user.seller.SellerCommonSignupDTO;
import com.example.moamz.domain.dto.user.seller.SellerUserSignupDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerSignupMapper {
    void insertCommonUser(SellerCommonSignupDTO sellerCommonSignupDTO);
    void insertSellerUser(SellerUserSignupDTO sellerUserSignupDTO);
    void insertBusiness(SellerBusinessDTO sellerBusinessDTO);
    void insertUserFile(UserFileDTO userFileDTO);

    //아이디 중복확인
    boolean checkedId(String fgUerId);
}
