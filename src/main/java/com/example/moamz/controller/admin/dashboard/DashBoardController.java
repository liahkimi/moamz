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

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller
@RequestMapping("/admin/dashboard")
@RequiredArgsConstructor
@Slf4j
public class DashBoardController {
    private final DashBoardService dashBoardService;
    LocalDate currentDate = LocalDate.now(); //현재 날짜

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
//        log.info("dashBoardEcoTopDTO {}", dashBoardEcoTopDTO);


        //최근 생성된 에코프젝 중 두번쨰로 최근인 것
        Optional<DashBoardEcoTop2DTO> dashBoardEcoTop2DTO = dashBoardService.findDashBoardIngEco2();
        dashBoardEcoTop2DTO.ifPresent(dto -> model.addAttribute("dashBoardEcoTop2DTO", dto));
//        model.addAttribute("dashBoardEcoTop2DTO", dashBoardEcoTop2DTO);
        log.info("dashBoardEcoTop2DTO {}", dashBoardEcoTopDTO);


        // 첫 번째 에코 프로젝트의 좋아요 top5 인증글
        if (dashBoardEcoTopDTO.isPresent()) {
            Long fgProjectId1 = dashBoardEcoTopDTO.get().getFgProjectId();
            log.info("First Eco Project ID: {}", fgProjectId1);

            List<DashBoardEcoTopLikes1DTO> dashBoardEcoTopLikes1DTO = dashBoardService.findDashBoardEcoTopLikes1(fgProjectId1);
            model.addAttribute("dashBoardEcoTopLikes1DTO", dashBoardEcoTopLikes1DTO);
        }

        // 두 번째 에코 프로젝트의 좋아요 top5 인증글
        if (dashBoardEcoTop2DTO.isPresent()) {
            Long fgProjectId2 = dashBoardEcoTop2DTO.get().getFgProjectId();
            log.info("Second Eco Project ID: {}", fgProjectId2);

            List<DashBoardEcoTopLikes2DTO> dashBoardEcoTopLikes2DTO = dashBoardService.findDashBoardEcoTopLikes2(fgProjectId2);
            model.addAttribute("dashBoardEcoTopLikes2DTO", dashBoardEcoTopLikes2DTO);
        }


        // 월별 쇼핑몰 총 구매건수 등락 추이 --> 현재 달로부터 근 4개월간의 그래프를 표현하고 싶은데...
        List<DashBoardGraphDTO> dashBoardGraphDTO = dashBoardService.findDashBoardSelectMonthlyPurchase();
        // 이번 달을 포함한 최근 4개월을 역순으로 계산
        for (int i = 0; i < 4; i++) {
            int month = currentDate.minusMonths(i).getMonthValue(); // 한 달 전, 두 달 전...
            String monthName = currentDate.minusMonths(i).getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH); // 영문 월 이름 생성

            boolean monthFound = false; // 해당 월에 대한 데이터를 찾았는지 여부를 추적

            for (DashBoardGraphDTO dto : dashBoardGraphDTO) {
                if (dto.getOrderMonth() == month) {
                    // 여기서 attributeName을 선언하여 바로 사용
                    String attributeName = monthName.toLowerCase() + "TotalOrders"; // augustTotalOrders, septemberTotalOrders...
                    model.addAttribute(attributeName, dto.getMonthlyTotalOrders());
                    log.info("Added to model: {} = {}", attributeName, dto.getMonthlyTotalOrders());
                    monthFound = true; // 데이터를 찾았으므로 true로 설정
                    break; // 해당 월 데이터를 찾으면 반복문 종료
                }
            }

            if (!monthFound) {
                // 데이터를 찾지 못한 경우 0을 설정
                String attributeName = monthName.toLowerCase() + "TotalOrders"; // augustTotalOrders, septemberTotalOrders...
                model.addAttribute(attributeName, 0);
                log.info("No data found for {}. Set to 0", monthName);
            }
        }


        // 월별 총 에코 프로젝트 인증글 수
        List<DashBoardGraphDTO> dashBoardGraphDTOEcoCert = dashBoardService.findDashBoardSelectMonthlyEcoCert();
        for (int i = 0; i < 4; i++) {
            int month = currentDate.minusMonths(i).getMonthValue(); // 한 달 전, 두 달 전...
            String monthName = currentDate.minusMonths(i).getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH); // 영문 월 이름 생성

            boolean monthFound = false; // 해당 월에 대한 데이터를 찾았는지 여부를 추적

            for (DashBoardGraphDTO dto : dashBoardGraphDTOEcoCert) {
                if (dto.getPostMonth() == month) {
                    // attributeName을 선언하여 바로 사용
                    String attributeName = monthName.toLowerCase() + "EcoCertPosts"; // augustEcoCertPosts, septemberEcoCertPosts...
                    model.addAttribute(attributeName, dto.getMonthlyEcoCertPosts());
                    log.info("Added to model: {} = {}", attributeName, dto.getMonthlyEcoCertPosts());
                    monthFound = true; // 데이터를 찾았으므로 true로 설정
                    break; // 해당 월 데이터를 찾으면 반복문 종료
                }
            }

            if (!monthFound) {
                // 데이터를 찾지 못한 경우 0을 설정
                String attributeName = monthName.toLowerCase() + "EcoCertPosts"; // augustEcoCertPosts, septemberEcoCertPosts...
                model.addAttribute(attributeName, 0);
                log.info("No data found for {}. Set to 0", monthName);
            }
        }
        return "admin/adminDashboard";
    }

}
