package com.example.moamz.service.main;

import com.example.moamz.domain.dto.main.MainPageDTO;
import com.example.moamz.mapper.main.MainPageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final MainPageMapper mainPageMapper;

    // 업체 정보 반환
    public List<MainPageDTO> getMainRecommendedShops() {
        return mainPageMapper.selectMainBusiness();
    }

    // 에코 프로젝트 반환
    public List<MainPageDTO> getMainEcoProjects() {
        return mainPageMapper.selectMainEco();
    }

    // 레시피 반환
    public List<MainPageDTO> getMainRecipes() {
        return mainPageMapper.selectMainRecipe();
    }

    // 소셜링 반환
    public List<MainPageDTO> getMainSocialings() {
        return mainPageMapper.selectMainSocialing();
    }
}
