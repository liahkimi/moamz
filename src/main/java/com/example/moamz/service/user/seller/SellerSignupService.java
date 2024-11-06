package com.example.moamz.service.user.seller;

import com.example.moamz.domain.dto.user.seller.SellerSignupDTO;
import com.example.moamz.mapper.user.seller.SellerSignupMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SellerSignupService {
    private final SellerSignupMapper sellerSignupMapper;

//    public void insertCommonUser(NormalSignupDTO normalSignupDTO) {
//        normalSignupMapper.insertCommonUser(normalSignupDTO);
//    }

    public void insertCommonUser(SellerSignupDTO sellerSignupDTO){
        sellerSignupMapper.insertCommonUser(sellerSignupDTO);
    }

    public void insertSeller(SellerSignupDTO sellerSignupDTO){
        sellerSignupMapper.insertSeller(sellerSignupDTO);
    }

    public void insertBusiness(SellerSignupDTO sellerSignupDTO){
        sellerSignupMapper.insertBusiness(sellerSignupDTO);
    }

    public void insertUserFile(SellerSignupDTO sellerSignupDTO){
        sellerSignupMapper.insertUserFile(sellerSignupDTO);
    }

    // 닉네임 중복확인
    public boolean checkedNickname(String fgUserId){

        return sellerSignupMapper.checkedId(fgUserId);
    }
}
