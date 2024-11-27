//package com.example.moamz.service.mypage.normal;
//
//import com.example.moamz.domain.dto.mypage.normal.info.NormalProfileDTO;
//import com.example.moamz.mapper.mypage.normal.info.NormalProfileMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class NormalProfileService {
//    private final NormalProfileMapper normalProfileMapper;
//
//    // 판매자 프로필 가져오기 메소드
//    public NormalProfileDTO getNormalProfile(Long fgUserCode) {
//
//        // 판매자 프로필 조회
//        NormalProfileDTO normalProfileDTO = (NormalProfileDTO) normalProfileMapper.selectProfile(fgUserCode);
//
//        // 구해준 음식물 누적합계 g -> kg으로 변환
//        int totalWeight = normalProfileDTO.getTotalWeight();
//        normalProfileDTO.setTotalWeightToKg((double) totalWeight/1000 );
//
//        // 탄소감축량, 나무 수 계산
//        double carbonReduct = totalWeight * 0.0025;
//        double treeCount = carbonReduct / 22;
//
//        // DTO에 탄소감축량, 나무 수 필드값 설정하기
//        normalProfileDTO.setCarbonReduction(carbonReduct);
//        normalProfileDTO.setTreeCount(treeCount);
//
//        return normalProfileDTO;
//    }
//
//
//}
