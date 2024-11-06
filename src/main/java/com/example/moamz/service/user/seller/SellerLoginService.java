package com.example.moamz.service.user.seller;

import com.example.moamz.domain.dto.user.seller.SellerLoginDTO;
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

    public long login(String fgUserID, String fgUserPassword) {
        return sellerLoginMapper.selectId(fgUserID, fgUserPassword)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다"));
    }

    public SellerLoginDTO findLoginInfo(String fgUserID, String fgUserPassword) {
        return sellerLoginMapper.selectLoginInfo(fgUserID, fgUserPassword)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다"));
    }
}
