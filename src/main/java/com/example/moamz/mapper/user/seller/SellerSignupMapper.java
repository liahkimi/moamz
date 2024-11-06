package com.example.moamz.mapper.user.seller;

import com.example.moamz.domain.dto.user.normal.NormalSignupDTO;
import com.example.moamz.domain.dto.user.seller.SellerSignupDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerSignupMapper {
    void insertCommonUser(SellerSignupDTO sellerSignupDTO);
    void insertSeller(SellerSignupDTO sellerSignupDTO);
    void insertBusiness(SellerSignupDTO sellerSignupDTO);
    void insertUserFile(SellerSignupDTO sellerSignupDTO);

    //아이디 중복확인
    boolean checkedId(String fgUerId);
}
