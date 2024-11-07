package com.example.moamz.mapper.mypage.normal;

import com.example.moamz.domain.dto.mypage.normal.MyPostRecipeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyPostRecipeMapper {
    List<MyPostRecipeDTO> selectMyPostRecipe();
}
