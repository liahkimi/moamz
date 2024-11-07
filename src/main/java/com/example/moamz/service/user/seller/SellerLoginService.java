package com.example.moamz.service.user.seller;

import com.example.moamz.domain.dto.user.seller.SellerSessionDTO;
import com.example.moamz.mapper.user.seller.SellerLoginMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SellerLoginService {
    private final SellerLoginMapper sellerLoginMapper;

    //유저코드
    public long findCode(String fgUserID, String fgUserPassword) {
        return sellerLoginMapper.selectId(fgUserID, fgUserPassword)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다"));
    }

    public SellerSessionDTO findLoginInfo(String fgUserID, String fgUserPassword) {
        return sellerLoginMapper.selectLoginInfo(fgUserID, fgUserPassword)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다"));
    }
}
