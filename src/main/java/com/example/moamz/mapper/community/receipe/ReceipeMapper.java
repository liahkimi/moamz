package com.example.moamz.mapper.community.receipe;

import com.example.moamz.domain.dto.community.PostDTO;
import com.example.moamz.domain.dto.community.receipe.ReceipeDetailDTO;
import com.example.moamz.domain.dto.community.receipe.ReceipeListDTO;
import com.example.moamz.domain.dto.community.receipe.ReceipeModifyDTO;
import com.example.moamz.domain.dto.community.receipe.ReceipeWriteDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReceipeMapper {
//    레시피 디테일
    ReceipeDetailDTO selectRecipePost(Long fgPostId);

//    레시피 리스트
    List<ReceipeListDTO> selectRecipePostList();

//    fg_post에 insert
    void insertFgPost(PostDTO postDTO);

    // recipe에 insert
    void insertFgPostRecipe(ReceipeWriteDTO writeDTO);

    // recipe update
    void updateFgRecipeDetails(ReceipeModifyDTO modifyDTO);


}
