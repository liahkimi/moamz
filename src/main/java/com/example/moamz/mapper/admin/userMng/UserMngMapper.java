package com.example.moamz.mapper.admin.userMng;

import com.example.moamz.domain.dto.admin.userMng.SellerMngListDTO;
import com.example.moamz.domain.dto.admin.userMng.UserMngListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMngMapper {
    // 일반회원 관리 목록 조회
    List<UserMngListDTO> selectUserMngList();

    // 판매자회원 관리 목록 조회
    List<SellerMngListDTO> selectSellerMngList();
}
