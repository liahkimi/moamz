package com.example.moamz.service.community.receipe;

import com.example.moamz.domain.dto.community.receipe.ReceipeDetailDTO;
import com.example.moamz.domain.dto.community.receipe.ReceipeListDTO;
import com.example.moamz.domain.dto.community.receipe.ReceipeModifyDTO;
import com.example.moamz.domain.dto.community.receipe.ReceipeWriteDTO;
import com.example.moamz.mapper.community.receipe.ReceipeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReceipeService {
    private final ReceipeMapper receipeMapper;

    //레시피 리스트
    public List<ReceipeListDTO> showReceipes(){
        return receipeMapper.selectRecipePostList();
    }

//    레시피 디테일
    public ReceipeDetailDTO showReceipeDetail(Long fgPostId){
        return receipeMapper.selectRecipePost(fgPostId);
    }

//    레시피 insert
    public void writeReceipe(ReceipeWriteDTO receipeWriteDTO){
        receipeMapper.insertFgPostRecipe(receipeWriteDTO);
    }

//    레시피 update
    public void modifyReceipe(ReceipeModifyDTO receipeModifyDTO){
        receipeMapper.updateFgRecipeDetails(receipeModifyDTO);
    }

// 레시피 삭제
    public void deleteReceipe(Long fgPostId){
        receipeMapper.deleteFgRecipe(fgPostId);
    }
}
