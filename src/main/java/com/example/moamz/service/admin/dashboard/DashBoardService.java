package com.example.moamz.service.admin.dashboard;

import com.example.moamz.domain.dto.admin.dashboard.DashBoardAggregationDTO;
import com.example.moamz.domain.dto.admin.dashboard.DashBoardEcoTopDTO;
import com.example.moamz.domain.dto.admin.dashboard.DashBoardGraphDTO;
import com.example.moamz.domain.dto.admin.eco.AdminEcoCertListDTO;
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

    //대시보드 중앙 보여주기 -에코 프로젝트 데이터 보여주기
    public List<DashBoardEcoTopDTO> findDashBoardIngEco(){
        return dashBoardMapper.selectIngEco();
    }

    //대시보드 중앙 보여주기 - 인증글 TOP 5 리스트 보여주기
    public List<DashBoardEcoTopDTO> findDashBoardEcoTopLikes(Long fgProjectId){
        return dashBoardMapper.selectEcoTopLikes(fgProjectId);
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
