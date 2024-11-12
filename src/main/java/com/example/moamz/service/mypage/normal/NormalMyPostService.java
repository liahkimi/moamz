package com.example.moamz.service.mypage.normal;

import com.example.moamz.domain.dto.mypage.normal.MyPostEcoDTO;
import com.example.moamz.domain.dto.mypage.normal.MyPostFreeDTO;
import com.example.moamz.domain.dto.mypage.normal.MyPostRecipeDTO;
import com.example.moamz.mapper.mypage.normal.MyPostEcoMapper;
import com.example.moamz.mapper.mypage.normal.MyPostFreeMapper;
import com.example.moamz.mapper.mypage.normal.MyPostRecipeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NormalMyPostService {

    private final MyPostEcoMapper myPostEcoMapper;
    private final MyPostRecipeMapper myPostRecipeMapper;
    private final MyPostFreeMapper myPostFreeMapper;

    // 에코 프로젝트 게시글 조회
    public List<MyPostEcoDTO> getMyPostEco(Long userCode) {
        return myPostEcoMapper.selectMyPostEco();  // 에코 게시글 조회
    }

    // 레시피 게시글 조회
    public List<MyPostRecipeDTO> getMyPostRecipe(Long userCode) {
        return myPostRecipeMapper.selectMyPostRecipe();  // 레시피 게시글 조회
    }

    // 자유 게시글 조회
    public List<MyPostFreeDTO> getMyPostFree(Long userCode) {
        return myPostFreeMapper.selectMyPostFree();  // 자유 게시글 조회
    }
}
