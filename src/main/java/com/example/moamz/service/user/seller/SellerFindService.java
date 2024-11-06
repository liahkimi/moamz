package com.example.moamz.service.user.seller;

import com.example.moamz.mapper.user.seller.SellerFindIdMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SellerFindService {
    private final SellerFindIdMapper sellerFindIdMapper;

}
