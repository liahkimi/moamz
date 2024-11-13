package com.example.moamz.service.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.StoreReviewDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerInfoDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerProfileDTO;
import com.example.moamz.domain.dto.mypage.seller.info.StoreModifyDTO;
import com.example.moamz.domain.dto.page.Criteria;
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

    // 판매자 프로필 가져오기 메서드
    public SellerProfileDTO getSellerProfile(Long businessId, Long userCode) {
        //businessId = 1L;
        //userCode = 1L;

        // 판매자 프로필 조회
        SellerProfileDTO sellerProfileDTO = sellerMyMapper.selectStoreProfile(userCode);

        // 우수 업체 여부
        String isExcellent = sellerMyMapper.selectExcellentStore(businessId);

        // 우수업체인 경우 DTO에 topBusiness값 설정하기
        if(isExcellent.equals("TRUE")) {
            sellerProfileDTO.setIsTopBusiness("우수업체");
        }

        // 구해준 음식물 누적합계 g -> kg으로 변환
        int totalWeight = sellerProfileDTO.getTotalWeight();
        sellerProfileDTO.setTotalWeightToKg((double) totalWeight/1000 );

        // 탄소감축량, 나무 수 계산
        double carbonReduct = totalWeight * 0.0025;
        double treeCount = carbonReduct / 22;

        // DTO에 탄소감축량, 나무 수 필드값 설정하기
        sellerProfileDTO.setCarbonReduction(carbonReduct);
        sellerProfileDTO.setTreeCount(treeCount);

        return sellerProfileDTO;
    }

    // 업체 리뷰 조회 메서드
    public List<StoreReviewDTO> findMyStoreRv(Long businessId) {
        return sellerMyMapper.selectMyStoreRv(businessId);
    }

    // 업체 리뷰 조회 메서드 (페이지네이션)
    public List<StoreReviewDTO> findMyStoreRvAll(Long businessId, Criteria criteria) {
        return sellerMyMapper.selectMyStoreRvAll(businessId, criteria);
    }

    // 전체 리뷰 수 세는 메서드
    public int findTotal(Long businessId) {
        return sellerMyMapper.selectTotal(businessId);
    }

    // 판매자 업체 번호 반환 메서드
    public Long findBusinessId(Long userCode) {
        return sellerMyMapper.selectBusinessId(userCode).
                orElseThrow(() -> new IllegalStateException("❌❌❌존재하지 않는 업체"));
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
