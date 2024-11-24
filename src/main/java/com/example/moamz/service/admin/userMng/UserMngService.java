package com.example.moamz.service.admin.userMng;

import com.example.moamz.domain.dto.admin.userInquiry.AdminUserInquiryListDTO;
import com.example.moamz.domain.dto.admin.userMng.SellerMngListDTO;
import com.example.moamz.domain.dto.admin.userMng.UserMngListDTO;
import com.example.moamz.domain.dto.page.Criteria;
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

    //일반회원 관리 목록 조회 (페이지네이션x)
    public List<UserMngListDTO> findUserMngList(){
        return userMngMapper.selectUserMngList();
    }

    //일반회원 총 인원 수 조회
    public int findUserMngTotal(){
        return userMngMapper.selectUserMngTotal();
    }

    //모든 일반회원목록 보기 (페이지네이션o)
    public List<UserMngListDTO> findAllUserMngPage(Criteria criteria){
        return userMngMapper.selectAllUserMngPage(criteria);
    }


    // 판매자회원 관리 목록 조회 (페이지네이션x)
    public List<SellerMngListDTO> findSellerMngList(){
        return userMngMapper.selectSellerMngList();
    }

    //판매자 총 인원 수
    public int findSellerMngTotal(){
        return userMngMapper.selectSellerMngTotal();
    }

    //모든 판매자목록 보기 (페이지네이션o)
    public List<SellerMngListDTO> findAllSellerMngPage(Criteria criteria){
        return userMngMapper.selectAllSellerMngPage(criteria);
    }
}
