package com.example.moamz.service.admin.dashboard;

import com.example.moamz.domain.dto.admin.dashboard.*;
import com.example.moamz.mapper.admin.dashboard.DashBoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class DashBoardService {
    private final DashBoardMapper dashBoardMapper;
    //대시보드 상단 보여주기 -집계 데이터 보여주기
    public Optional<DashBoardAggregationDTO> findDashBoardAggregation(){
        return dashBoardMapper.selectAggregation();
    }

    // -최근 생성된 에코프젝 중 가장 최근 인 것
    public Optional<DashBoardEcoTopDTO> findDashBoardIngEco(){

        return dashBoardMapper.selectIngEco();
    }

    // 최근 생성된 에코프젝 중 두번쨰로 최근인 것
    public Optional<DashBoardEcoTop2DTO> findDashBoardIngEco2(){

        return dashBoardMapper.selectIngEco2();
    }

    //에코프로젝트1의 top5좋아요리스트1
    public List<DashBoardEcoTopLikes1DTO> findDashBoardEcoTopLikes1(Long fgProjectId){
        return dashBoardMapper.selectEcoTopLikes1(fgProjectId);
    }

    //에코프로젝트2의 top5좋아요리스트2
    public List<DashBoardEcoTopLikes2DTO> findDashBoardEcoTopLikes2(Long fgProjectId){
        return dashBoardMapper.selectEcoTopLikes2(fgProjectId);
    }

    //    (진행중/종료된) 특정 한 에코 프로젝트의 인증글 목록보기
    public Optional<DashBoardEcoTopDTO> findEcoProjectById(Long fgPostId ){
        return dashBoardMapper.selectEcoProjectById(fgPostId);
    }

    //대시보드 하단 보여주기 - 월별 총 구매건수
    public List<DashBoardGraphDTO> findDashBoardSelectMonthlyPurchase(){
        return dashBoardMapper.selectMonthlyPurchase();
    }

    //대시보드 하단 보여주기 - 별 총 에코 프로젝트 인증글 수
    public List<DashBoardGraphDTO> findDashBoardSelectMonthlyEcoCert(){
        return dashBoardMapper.selectMonthlyEcoCert();
    }
}
