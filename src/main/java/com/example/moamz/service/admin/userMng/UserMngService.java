package com.example.moamz.service.admin.userMng;

import com.example.moamz.domain.dto.admin.userMng.SellerMngListDTO;
import com.example.moamz.domain.dto.admin.userMng.UserMngListDTO;
import com.example.moamz.mapper.admin.userMng.UserMngMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserMngService {
    private final UserMngMapper userMngMapper;

    //일반회원 관리 목록 조회
    public List<UserMngListDTO> findUserMngList(){
        return userMngMapper.selectUserMngList();
    }


    // 판매자회원 관리 목록 조회
    public List<SellerMngListDTO> findSellerMngList(){
        return userMngMapper.selectSellerMngList();
    }
}
