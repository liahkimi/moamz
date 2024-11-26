package com.example.moamz.mapper.admin.userMng;

import com.example.moamz.domain.dto.admin.userInquiry.AdminUserInquiryListDTO;
import com.example.moamz.domain.dto.admin.userMng.AdminSearchDTO;
import com.example.moamz.domain.dto.admin.userMng.SellerMngListDTO;
import com.example.moamz.domain.dto.admin.userMng.UserMngListDTO;
import com.example.moamz.domain.dto.page.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMngMapper {
    // 일반회원 관리 목록 조회 (페이지네이션x)
    List<UserMngListDTO> selectUserMngList();

    // 일반회원 총 인원 수 조회
    int selectUserMngTotal();

    // 모든 일반회원목록 보기 (페이지네이션o)
    List<UserMngListDTO> selectAllUserMngPage(Criteria criteria);


    // 판매자회원 관리 목록 조회 (페이지네이션x)
    List<SellerMngListDTO> selectSellerMngList();

    // 판매자 총 인원 수
    int selectSellerMngTotal();

    //모든 판매자목록 보기 (페이지네이션o)
    List<SellerMngListDTO> selectAllSellerMngPage(Criteria criteria);

//    List<AdminSearchDTO> searchByUserId(String fgUserId);

    // 사용자 유형 조회
    String findUserTypeByUserId(String fgUserId);

    // 일반 회원 검색
    List<UserMngListDTO> searchNormalUserByUserId(@Param("fgUserId") String fgUserId, @Param("criteria") Criteria criteria);

    // 판매자 회원 검색
    List<SellerMngListDTO> searchSellerByUserId(@Param("fgUserId") String fgUserId, @Param("criteria") Criteria criteria);

}
