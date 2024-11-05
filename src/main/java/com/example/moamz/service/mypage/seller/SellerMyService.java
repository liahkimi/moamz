package com.example.moamz.service.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.StoreReviewDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerInfoDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerProfileDTO;
import com.example.moamz.domain.dto.mypage.seller.info.StoreModifyDTO;
import com.example.moamz.mapper.mypage.seller.SellerMyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class SellerMyService {
    private final SellerMyMapper sellerMyMapper;

    // 우수업체 여부 반환 메서드
    public String isExcellentStore(Long businessId) {
        return sellerMyMapper.selectExcellentStore(businessId);
    }

    // 판매자 프로필 조회 메서드
    public SellerProfileDTO findSellerProfile(Long userCode) {
        return sellerMyMapper.selectSellerProfile(userCode);
    }

    // 업체 리뷰 조회 메서드
    public List<StoreReviewDTO> findMyStoreRv(Long businessId) {
        return sellerMyMapper.selectMyStoreRv(businessId);
    }

    // 유저 아이디 반환 메서드
    public String findSellerId(Long userCode) {
        return sellerMyMapper.selectSellerId(userCode);
    }

    // 로그인 메서드
    public Long findSellerCode(String userId, String userPassword) {
        return sellerMyMapper.selectSellerCode(userId, userPassword)
                .orElseThrow(() -> new IllegalStateException("❌❌❌존재하지 않는 회원정보"));
    }

    // 개인정보 가져오기 메서드
    public SellerInfoDTO findSellerInfo(Long userCode) {
        return sellerMyMapper.selectSellerInfo(userCode);
    }

    // 휴대폰번호 변경 메서드
    public void updateSellerPhone(String sellerPhone) {
        sellerMyMapper.modifySellerPhone(sellerPhone);
    }

    // 비밀번호 변경 메서드
    public void updateSellerPassword(String userPassword) {
        sellerMyMapper.modifySellerPw(userPassword);
    }

    // 업체정보 가져오기 메서드
    public SellerInfoDTO findStoreInfo(Long userCode) {
        return sellerMyMapper.selectStoreInfo(userCode);
    }

    // 업체 정보 변경하기 메서드
    public void updateStoreInfo(StoreModifyDTO storeModifyDTO) {
        sellerMyMapper.modifyStoreInfo(storeModifyDTO);
    }

    // 회원 탈퇴 메서드
    public void removeUser(Long userCode) {
        sellerMyMapper.deleteUser(userCode);
    }

}
