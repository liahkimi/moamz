package com.example.moamz.controller.admin.dashboard;

import com.example.moamz.domain.dto.admin.dashboard.*;
import com.example.moamz.domain.dto.admin.eco.AdminIngEcoListDTO;
import com.example.moamz.service.admin.dashboard.DashBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class DashBoardController {
    private final DashBoardService dashBoardService;


    //대시보드 보여주기
    @GetMapping("")
    public String showDashBoard(@SessionAttribute(value="fgUserCode", required = false) Long fgUserCode ,Model model) {
        //대시보드 상단 집계 데이터
        Optional<DashBoardAggregationDTO> dashBoardAggregationDTO = dashBoardService.findDashBoardAggregation();
        dashBoardAggregationDTO.ifPresent(dto -> model.addAttribute("dashBoardAggregationDTO", dto));

        //-최근 생성된 에코프젝 중 가장 최근 인 것
      Optional<DashBoardEcoTopDTO> dashBoardEcoTopDTO = dashBoardService.findDashBoardIngEco();
        dashBoardEcoTopDTO.ifPresent(dto -> model.addAttribute("dashBoardEcoTopDTO", dto));
//        model.addAttribute("dashBoardEcoTopDTO", dashBoardEcoTopDTO);
        log.info("💥💥💥💥💥💥💥💥dashBoardEcoTopDTO {}", dashBoardEcoTopDTO);


        //최근 생성된 에코프젝 중 두번쨰로 최근인 것
        Optional<DashBoardEcoTop2DTO> dashBoardEcoTop2DTO = dashBoardService.findDashBoardIngEco2();
        dashBoardEcoTop2DTO.ifPresent(dto -> model.addAttribute("dashBoardEcoTop2DTO", dto));
//        model.addAttribute("dashBoardEcoTop2DTO", dashBoardEcoTop2DTO);
        log.info("💥💥💥💥💥💥💥💥dashBoardEcoTop2DTO {}", dashBoardEcoTopDTO);

        // 첫 번째와 두 번째 에코프로젝트의 projectId 가져오기
        if (dashBoardEcoTopDTO.isPresent()) {
            Long fgProjectId1 = dashBoardEcoTopDTO.get().getFgProjectId();
            log.info("First Eco Project ID: {}", fgProjectId1);

            // 첫 번째 에코 프로젝트의 좋아요 top5 인증글
            List<DashBoardEcoTopLikes1DTO> dashBoardEcoTopLikes1DTO = dashBoardService.findDashBoardEcoTopLikes1(fgProjectId1);
            model.addAttribute("dashBoardEcoTopLikes1DTO", dashBoardEcoTopLikes1DTO);
        }

        if (dashBoardEcoTop2DTO.isPresent()) {
            Long fgProjectId2 = dashBoardEcoTop2DTO.get().getFgProjectId();
            log.info("Second Eco Project ID: {}", fgProjectId2);

            // 두 번째 에코 프로젝트의 좋아요 top5 인증글
            List<DashBoardEcoTopLikes2DTO> dashBoardEcoTopLikes2DTO = dashBoardService.findDashBoardEcoTopLikes2(fgProjectId2);
            model.addAttribute("dashBoardEcoTopLikes2DTO", dashBoardEcoTopLikes2DTO);
        }

        return "admin/adminDashboard";
    }

}
