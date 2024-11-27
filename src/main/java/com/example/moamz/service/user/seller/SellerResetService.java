package com.example.moamz.service.user.seller;

import com.example.moamz.domain.dto.user.seller.SellerResetPasswordDTO;
import com.example.moamz.mapper.user.seller.SellerResetPasswordMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SellerResetService {
    private final SellerResetPasswordMapper sellerResetPasswordMapper;

    public SellerResetPasswordDTO selectPassword(String fgUserID, String fgSellerPhone){
        return sellerResetPasswordMapper.selectPassword(fgUserID, fgSellerPhone)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원"));
    }

    public void updatePassword(SellerResetPasswordDTO sellerResetPasswordDTO) {
        sellerResetPasswordMapper.updatePassword(sellerResetPasswordDTO);
    }

}
