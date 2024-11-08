package com.example.moamz.mapper.admin.dashboard;

import com.example.moamz.domain.dto.admin.dashboard.DashBoardAggregationDTO;
import com.example.moamz.domain.dto.admin.dashboard.DashBoardEcoTopDTO;
import com.example.moamz.domain.dto.admin.dashboard.DashBoardGraphDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DashBoardMapper {

    // 대시보드 상단 집계 부분
    Optional<DashBoardAggregationDTO> selectAggregation();

    // 대시보드 중앙 에코 프로젝트 진행 중인 부분
    List<DashBoardEcoTopDTO> selectIngEco();

    // 해당 에코 프로젝트의 인증글 top5 리스트
    List<DashBoardEcoTopDTO> selectEcoTopLikes(@Param("fgProjectId") Long fgProjectId); // 매개변수 추가

    // 대시보드 하단 월별 총 구매건수
    List<DashBoardGraphDTO> selectMonthlyPurchase();

    // 월별 총 에코 프로젝트 인증글 수
    List<DashBoardGraphDTO> selectMonthlyEcoCert();
}
