package com.example.moamz.mapper.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.StoreReviewDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerInfoDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerProfileDTO;
import com.example.moamz.domain.dto.mypage.seller.info.StoreInfoDTO;
import com.example.moamz.domain.dto.mypage.seller.info.StoreModifyDTO;
import com.example.moamz.domain.dto.page.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SellerMyMapper {
    // 우수업체 여부 반환
    String selectExcellentStore(Long businessId);

    // 판매자 프로필 조회
    SellerProfileDTO selectStoreProfile(Long userCode);

    // 업체 리뷰 조회
    List<StoreReviewDTO> selectMyStoreRv(Long businessId);

    // 업체 리뷰 조회 (페이지네이션)
    List<StoreReviewDTO> selectMyStoreRvAll(@Param("businessId") Long businessId, @Param("criteria") Criteria criteria);

    // 총 리뷰 수
    int selectTotal(Long businessId);

    // 업체 아이디 반환
    Optional<Long> selectBusinessId(Long userCode);

    // 유저 아이디 반환
    String selectSellerId(Long userCode);

    // userCode로 회원 비밀번호 조회
    Optional<String> selectSellerPw(Long userCode);

    // 개인정보 가져오기
    SellerInfoDTO selectSellerInfo(Long userCode);

    // 휴대폰번호 변경
    void modifySellerPhone(String sellerPhone);

    // 비밀번호 변경
    void modifySellerPw(String userPassword);

    // 업체 정보 가져오기
    StoreInfoDTO selectStoreInfo(Long userCode);

    // 업체 정보 변경하기
    void modifyStoreInfo(StoreModifyDTO storeModifyDTO);

    // 회원 탈퇴
    void deleteUser(Long userCode);

}

