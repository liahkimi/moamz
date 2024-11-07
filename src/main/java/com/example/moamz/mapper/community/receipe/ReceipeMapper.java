package com.example.moamz.mapper.community.receipe;

import com.example.moamz.domain.dto.community.receipe.ReceipeDetailDTO;
import com.example.moamz.domain.dto.community.receipe.ReceipeListDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReceipeMapper {
//    레시피 디테일
    ReceipeDetailDTO selectRecipePost(Long fgPostId);

//    레시피 리스트
    ReceipeListDTO selectRecipePostList();

//    fg_post에 insert
}
