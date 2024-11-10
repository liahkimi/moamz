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


    // 메인페이지 열기
    @GetMapping()
    public String getMainPage(Model model) {
        // 업체 추천 데이터 가져오기
        List<MainPageDTO> mainBusinessList = mainService.getMainRecommendedShops();
        model.addAttribute("mainBusinessList", mainBusinessList);
        // 에코 프로젝트 데이터 가져오기
        List<MainPageDTO> mainEcoList = mainService.getMainEcoProjects();
        model.addAttribute("mainEcoList", mainEcoList);
        log.info("😎😎 업체 {}", mainBusinessList);
        log.info("😎😎 에코 {}", mainEcoList);

        // 레시피 데이터 가져오기
        List<MainPageDTO> mainRecipeList = mainService.getMainRecipes();
        model.addAttribute("mainRecipeList", mainRecipeList);

        // 소셜링 데이터 가져오기
        List<MainPageDTO> mainSocialingList = mainService.getMainSocialings();
        model.addAttribute("mainSocialingList", mainSocialingList);

        return "/main/main/mainPage";
    }



}
