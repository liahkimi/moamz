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

        //진행중인 에코프로젝트들
        List<DashBoardEcoTopDTO> dashBoardEcoTopDTO = dashBoardService.findDashBoardIngEco();
        model.addAttribute("dashBoardEcoTopDTO", dashBoardEcoTopDTO);

        //해당 에코프로젝트의 좋아요top5 인증글
        //어떻게 특정 프로젝트의 id를 매개변수로 넣지..?
//        List<DashBoardEcoTopDTO> dashBoardEcoTopDTOLikes = dashBoardService.findDashBoardEcoTopLikes(fgProjectId);

//
//        // 첫 번째 에코프로젝트의 projectId를 가져오기 (필요에 따라 다른 방식으로 선택 가능)
//        if (!dashBoardEcoTopDTO.isEmpty()) {
//            Long fgProjectId = dashBoardEcoTopDTO.get(0).getFgProjectId();  // 첫 번째 프로젝트의 ID를 가져옴
//
//            // 해당 에코프로젝트의 좋아요 top5 인증글
//            List<DashBoardEcoTopDTO> dashBoardEcoTopDTOLikes = dashBoardService.findDashBoardEcoTopLikes(fgProjectId);
//            model.addAttribute("dashBoardEcoTopDTOLikes", dashBoardEcoTopDTOLikes);
//        }




        return "admin/adminDashboard";
    }

}
