package com.example.moamz.mapper.main;

import com.example.moamz.domain.dto.main.MainPageDTO;
import com.sun.tools.javac.Main;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainPageMapper {
    // 업체
    List<MainPageDTO> selectMainBusiness();

    // 에코프로젝트
    List<MainPageDTO> selectMainEco();

    // 레시피
    List<MainPageDTO> selectMainRecipe();

    // 소셜링
    List<MainPageDTO> selectMainSocialing();

}
