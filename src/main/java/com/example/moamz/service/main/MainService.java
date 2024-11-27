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

    // 추천 업체 정보를 가져오는 메소드
    public List<MainPageDTO> getMainRecommendedShops() {

        return mainPageMapper.selectMainBusiness(); // MainPageMapper의 메소드 호출하여 추천 업체 정보 반환
    }


    // 에코 프로젝트 정보를 가져오는 메소드
    public List<MainPageDTO> getMainEcoProjects() {

        return mainPageMapper.selectMainEco(); // MainPageMapper의 메소드 호출하여 에코 프로젝트 정보 반환
    }

    // 레시피 정보를 가져오는 메소드
    public List<MainPageDTO> getMainRecipes() {

        return mainPageMapper.selectMainRecipe(); // MainPageMapper의 메소드 호출하여 레시피 정보 반환
    }

    // 소셜링 정보를 가져오는 메소드
    public List<MainPageDTO> getMainSocialings() {

        return mainPageMapper.selectMainSocialing(); // MainPageMapper의 메소드 호출하여 소셜링 정보 반환
    }
}
