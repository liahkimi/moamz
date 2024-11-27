package com.example.moamz.mapper.mypage.normal;

import com.example.moamz.domain.dto.mypage.normal.MyPostEcoDTO;
import com.example.moamz.domain.dto.mypage.normal.MyPostFreeDTO;
import com.example.moamz.domain.dto.mypage.normal.MyPostRecipeDTO;

import java.util.List;

public interface NormalMyPostMapper {

    // 마이페이지 내 게시글 에코프로젝트
    List<MyPostEcoDTO> selectMyPostEco();

    // 마이페이지 내 게시글 자유 게시판
    List<MyPostFreeDTO> selectMyPostFree();

    // 마이페이지 내 게시글 레시피
    List<MyPostRecipeDTO> selectMyPostRecipe();
}
