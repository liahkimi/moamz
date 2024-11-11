package com.example.moamz.controller.admin.dashboard;

import com.example.moamz.domain.dto.admin.dashboard.DashBoardAggregationDTO;
import com.example.moamz.domain.dto.admin.dashboard.DashBoardEcoTopDTO;
import com.example.moamz.domain.dto.admin.eco.AdminIngEcoListDTO;
import com.example.moamz.service.admin.dashboard.DashBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/dashboard")
@RequiredArgsConstructor
public class DashBoardController {
    private final DashBoardService dashBoardService;


    //대시보드 보여주기
    @GetMapping("")
    public String showDashBoard(@SessionAttribute(value="fgUserCode", required = false) Long fgUserCode ,Model model) {
        //대시보드 상단 집계 데이터
        Optional<DashBoardAggregationDTO> dashBoardAggregationDTO = dashBoardService.findDashBoardAggregation();
        dashBoardAggregationDTO.ifPresent(dto -> model.addAttribute("dashBoardAggregationDTO", dto));

//        //진행중인 에코프로젝트들
//        List<DashBoardEcoTopDTO> dashBoardEcoTopDTO = dashBoardService.findDashBoardIngEco();
//        model.addAttribute("dashBoardEcoTopDTO", dashBoardEcoTopDTO);
//
//        //해당 에코프로젝트의 좋아요top5 인증글





//        // 진행 중인 에코 프로젝트 리스트
//        List<DashBoardEcoTopDTO> ongoingEcoProjects = dashBoardService.findDashBoardIngEco();
//        model.addAttribute("ongoingEcoProjects", ongoingEcoProjects);
//
//        // 각 프로젝트에 대해 TOP 5 인증글 좋아요 수를 가져오기
//        for (DashBoardEcoTopDTO ecoProject : ongoingEcoProjects) {
//            List<DashBoardEcoTopDTO> topLikes = dashBoardService.findDashBoardEcoTopLikes(ecoProject.getFgProjectId());
//            ecoProject.setTopLikes(topLikes); // TOP 5 좋아요 수를 설정
//        }

        return "admin/adminDashboard";
    }

}
