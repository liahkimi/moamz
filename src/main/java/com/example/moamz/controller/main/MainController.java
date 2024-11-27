package com.example.moamz.controller.main;

import com.example.moamz.domain.dto.main.MainPageDTO;
import com.example.moamz.service.main.MainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/main")
@RequiredArgsConstructor
@Slf4j
public class MainController {
    // 서비스 등록
    private final MainService mainService;

    // 메인 페이지를 열기 위한 GET 요청 처리
    @GetMapping()
    public String getMainPage(Model model) {
        // 업체 추천 데이터 가져오기
        // 추천 업체 데이터를 MainService에서 가져와서 mainBusinessList에 저장
        List<MainPageDTO> mainBusinessList = mainService.getMainRecommendedShops();
        model.addAttribute("mainBusinessList", mainBusinessList);  // model에 업체 추천 리스트 추가하여 뷰로 전달

        // 에코 프로젝트 데이터 가져오기
        // 에코 프로젝트 데이터를 MainService에서 가져와서 mainEcoList에 저장
        List<MainPageDTO> mainEcoList = mainService.getMainEcoProjects();
        model.addAttribute("mainEcoList", mainEcoList); // model에 에코 프로젝트 리스트 추가하여 뷰로 전달

        // 로그에 추천 업체와 에코 프로젝트 데이터 출력
        log.info("😎😎 업체 {}", mainBusinessList);
        log.info("😎😎 에코 {}", mainEcoList);

        // 레시피 데이터 가져오기
        // 레시피 데이터를 MainService에서 가져와서 mainRecipeList에 저장
        List<MainPageDTO> mainRecipeList = mainService.getMainRecipes();
        model.addAttribute("mainRecipeList", mainRecipeList); // model에 레시피 리스트 추가하여 뷰로 전달

        // 소셜링 데이터 가져오기
        // 소셜링 데이터를 MainService에서 가져와서 mainSocialingList에 저장
        List<MainPageDTO> mainSocialingList = mainService.getMainSocialings();
        model.addAttribute("mainSocialingList", mainSocialingList); // model에 소셜링 리스트 추가하여 뷰로 전달

        return "/main/main/mainPage";  // 데이터가 포함된 모델을 "mainPage" 템플릿으로 반환하여 뷰에 전달
    }



}
