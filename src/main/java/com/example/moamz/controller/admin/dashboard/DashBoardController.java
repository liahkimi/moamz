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

@Controller  // Spring MVC의 Controller 어노테이션. 이 클래스가 웹 요청을 처리함을 나타냄
@RequestMapping("/admin/dashboard")  // 요청 URL에 '/admin/dashboard' 경로가 포함된 경우 이 컨트롤러에서 처리
@RequiredArgsConstructor  // final 필드를 생성자 주입하는 Lombok 어노테이션
@Slf4j  // SLF4J 로깅을 위한 Lombok 어노테이션
public class DashBoardController {
    private final DashBoardService dashBoardService;  // 대시보드 서비스 의존성 주입
    LocalDate currentDate = LocalDate.now();  // 현재 날짜를 가져오는 LocalDate 객체

    // 대시보드 보여주기 위한 메소드
    @GetMapping("")  // 기본 GET 요청에 대해 처리 ("/admin/dashboard")
    public String showDashBoard(@SessionAttribute(value="fgUserCode", required = false) Long fgUserCode ,Model model) {
        // 대시보드 상단 집계 데이터 조회
        Optional<DashBoardAggregationDTO> dashBoardAggregationDTO = dashBoardService.findDashBoardAggregation();
        dashBoardAggregationDTO.ifPresent(dto -> model.addAttribute("dashBoardAggregationDTO", dto));  // 데이터가 있으면 model에 추가

        // 최근 생성된 에코 프로젝트 중 가장 최근 것
        Optional<DashBoardEcoTopDTO> dashBoardEcoTopDTO = dashBoardService.findDashBoardIngEco();
        dashBoardEcoTopDTO.ifPresent(dto -> model.addAttribute("dashBoardEcoTopDTO", dto));  // 데이터가 있으면 model에 추가

        // 최근 생성된 에코 프로젝트 중 두 번째로 최근인 것
        Optional<DashBoardEcoTop2DTO> dashBoardEcoTop2DTO = dashBoardService.findDashBoardIngEco2();
        dashBoardEcoTop2DTO.ifPresent(dto -> model.addAttribute("dashBoardEcoTop2DTO", dto));  // 데이터가 있으면 model에 추가
        log.info("dashBoardEcoTop2DTO {}", dashBoardEcoTopDTO);  // 두 번째 에코 프로젝트 정보 로그 출력

        // 첫 번째 에코 프로젝트의 좋아요 상위 5개 인증글 조회
        if (dashBoardEcoTopDTO.isPresent()) {
            Long fgProjectId1 = dashBoardEcoTopDTO.get().getFgProjectId();  // 첫 번째 프로젝트의 ID를 가져옴
            log.info("First Eco Project ID: {}", fgProjectId1);  // 첫 번째 프로젝트 ID 로그 출력

            List<DashBoardEcoTopLikes1DTO> dashBoardEcoTopLikes1DTO = dashBoardService.findDashBoardEcoTopLikes1(fgProjectId1);  // 좋아요 상위 5개 인증글 조회
            model.addAttribute("dashBoardEcoTopLikes1DTO", dashBoardEcoTopLikes1DTO);  // 모델에 추가
        }

        // 두 번째 에코 프로젝트의 좋아요 상위 5개 인증글 조회
        if (dashBoardEcoTop2DTO.isPresent()) {
            Long fgProjectId2 = dashBoardEcoTop2DTO.get().getFgProjectId();  // 두 번째 프로젝트의 ID를 가져옴
            log.info("Second Eco Project ID: {}", fgProjectId2);  // 두 번째 프로젝트 ID 로그 출력

            List<DashBoardEcoTopLikes2DTO> dashBoardEcoTopLikes2DTO = dashBoardService.findDashBoardEcoTopLikes2(fgProjectId2);  // 좋아요 상위 5개 인증글 조회
            model.addAttribute("dashBoardEcoTopLikes2DTO", dashBoardEcoTopLikes2DTO);  // 모델에 추가
        }

        // 월별 쇼핑몰 총 구매 건수 등락 추이 (최근 4개월 데이터)
        List<DashBoardGraphDTO> dashBoardGraphDTO = dashBoardService.findDashBoardSelectMonthlyPurchase();
        // 최근 4개월을 역순으로 가져오기
        for (int i = 0; i < 4; i++) {
            int month = currentDate.minusMonths(i).getMonthValue();  // 한 달 전, 두 달 전, 세 달 전...
            String monthName = currentDate.minusMonths(i).getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);  // 해당 월의 영문 이름

            boolean monthFound = false;  // 해당 월에 대한 데이터를 찾았는지 여부를 추적

            // 월별 데이터가 있는지 확인하고 모델에 추가
            for (DashBoardGraphDTO dto : dashBoardGraphDTO) {
                if (dto.getOrderMonth() == month) {
                    String attributeName = monthName.toLowerCase() + "TotalOrders";  // 월별 데이터 이름 생성 (예: augustTotalOrders)
                    model.addAttribute(attributeName, dto.getMonthlyTotalOrders());  // 모델에 해당 데이터를 추가
                    log.info("Added to model: {} = {}", attributeName, dto.getMonthlyTotalOrders());  // 로그 출력
                    monthFound = true;  // 데이터를 찾았으므로 true로 설정
                    break;  // 데이터를 찾았으면 더 이상 반복하지 않음
                }
            }

            // 데이터가 없으면 0으로 설정
            if (!monthFound) {
                String attributeName = monthName.toLowerCase() + "TotalOrders";  // 월별 데이터 이름 생성
                model.addAttribute(attributeName, 0);  // 0으로 모델에 추가
                log.info("No data found for {}. Set to 0", monthName);  // 데이터가 없다는 로그 출력
            }
        }

        // 월별 총 에코 프로젝트 인증글 수
        List<DashBoardGraphDTO> dashBoardGraphDTOEcoCert = dashBoardService.findDashBoardSelectMonthlyEcoCert();
        for (int i = 0; i < 4; i++) {
            int month = currentDate.minusMonths(i).getMonthValue();  // 한 달 전, 두 달 전...
            String monthName = currentDate.minusMonths(i).getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);  // 해당 월의 영문 이름

            boolean monthFound = false;  // 해당 월에 대한 데이터를 찾았는지 여부를 추적

            // 월별 데이터가 있는지 확인하고 모델에 추가
            for (DashBoardGraphDTO dto : dashBoardGraphDTOEcoCert) {
                if (dto.getPostMonth() == month) {
                    String attributeName = monthName.toLowerCase() + "EcoCertPosts";  // 월별 인증글 데이터 이름 생성
                    model.addAttribute(attributeName, dto.getMonthlyEcoCertPosts());  // 모델에 해당 데이터를 추가
                    log.info("Added to model: {} = {}", attributeName, dto.getMonthlyEcoCertPosts());  // 로그 출력
                    monthFound = true;  // 데이터를 찾았으므로 true로 설정
                    break;  // 데이터를 찾았으면 더 이상 반복하지 않음
                }
            }

            // 데이터가 없으면 0으로 설정
            if (!monthFound) {
                String attributeName = monthName.toLowerCase() + "EcoCertPosts";  // 월별 인증글 데이터 이름 생성
                model.addAttribute(attributeName, 0);  // 0으로 모델에 추가
                log.info("No data found for {}. Set to 0", monthName);  // 데이터가 없다는 로그 출력
            }
        }

        // 대시보드 화면에 정보를 보여주기 위한 뷰 반환
        return "admin/adminDashboard";  // adminDashboard 뷰를 반환
    }
}
