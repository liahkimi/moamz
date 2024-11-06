package com.example.moamz.mapper.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.StoreReviewDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerInfoDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerProfileDTO;
import com.example.moamz.domain.dto.mypage.seller.info.StoreModifyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SellerMyMapper {
    // 우수업체 여부 반환
    String selectExcellentStore(Long businessId);

    // 판매자 프로필 조회
    SellerProfileDTO selectSellerProfile(Long userCode);

    // 업체 리뷰 조회
    List<StoreReviewDTO> selectMyStoreRv(Long businessId);

    // 유저 아이디 반환
    Optional<String> selectSellerId(Long userCode);

    // 아이디, 비밀번호 확인해서 userCode 반환
    Optional<Long> selectSellerCode(String userId, String userPassword);

    // 개인정보 가져오기
    SellerInfoDTO selectSellerInfo(Long userCode);

    // 휴대폰번호 변경
    void modifySellerPhone(String sellerPhone);

    // 비밀번호 변경
    void modifySellerPw(String userPassword);

    // 업체 정보 가져오기
    SellerInfoDTO selectStoreInfo(Long userCode);

    // 업체 정보 변경하기
    void modifyStoreInfo(StoreModifyDTO storeModifyDTO);

    // 회원 탈퇴
    void deleteUser(Long userCode);

}

