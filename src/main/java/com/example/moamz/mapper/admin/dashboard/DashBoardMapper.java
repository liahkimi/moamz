package com.example.moamz.mapper.admin.dashboard;

import com.example.moamz.domain.dto.admin.dashboard.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DashBoardMapper {

    // 대시보드 상단 집계 부분
    Optional<DashBoardAggregationDTO> selectAggregation();

    // -최근 생성된 에코프젝 중 가장 최근 인 것
    Optional<DashBoardEcoTopDTO> selectIngEco();

    // 최근 생성된 에코프젝 중 두번쨰로 최근인 것
    Optional<DashBoardEcoTop2DTO> selectIngEco2();

    // 에코프로젝트1의 top5좋아요리스트1
    List<DashBoardEcoTopLikes1DTO> selectEcoTopLikes1(@Param("fgProjectId") Long fgProjectId); // 매개변수 추가

    // 에코프로젝트1의 top5좋아요리스트1
    List<DashBoardEcoTopLikes2DTO> selectEcoTopLikes2(@Param("fgProjectId") Long fgProjectId); // 매개변수 추가


    //   특정 한 에코프로젝트만 조회하기
    Optional<DashBoardEcoTopDTO> selectEcoProjectById(@Param("fgPostId") Long fgPostId);


    // 대시보드 하단 월별 총 구매건수
    List<DashBoardGraphDTO> selectMonthlyPurchase();

    // 월별 총 에코 프로젝트 인증글 수
    List<DashBoardGraphDTO> selectMonthlyEcoCert();
}
