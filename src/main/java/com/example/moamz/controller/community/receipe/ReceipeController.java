package com.example.moamz.controller.community.receipe;

import com.example.moamz.domain.dto.community.PostDTO;
import com.example.moamz.domain.dto.community.receipe.ReceipeDetailDTO;
import com.example.moamz.domain.dto.community.receipe.ReceipeListDTO;
import com.example.moamz.domain.dto.community.receipe.ReceipeWriteDTO;
import com.example.moamz.service.community.PostService;
import com.example.moamz.service.community.receipe.ReceipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class ReceipeController {

    private final ReceipeService receipeService;
    private final PostService postService;

    @GetMapping("/list")
    public String receipeList(Model model) {

        List<ReceipeListDTO> receipeLists = receipeService.showReceipes();

        model.addAttribute("receipeLists", receipeLists);

        System.out.println("receipeLists = " + receipeLists);

        return "/community/receipe/receipeList";
    }

    @GetMapping("/recipeDetail/{fgPostId}")
    public String receipeDetail(@PathVariable("fgPostId") Long fgPostId, Model model) {
        ReceipeDetailDTO receipeDetail = receipeService.showReceipeDetail(fgPostId);

        model.addAttribute("receipeDetail", receipeDetail);
        model.addAttribute("fgPostId", fgPostId);
        return "/community/receipe/receipeDetail";
    }

    @GetMapping("/recipeWrite")
    public String receipeWrite(Model model) {
        return "/community/receipe/receipeWrite";
    }

    @PostMapping("/recipeWrite")
    public String recipeWritePost(@ModelAttribute ReceipeWriteDTO receipeWriteDTO,
                                  @RequestParam("postFile") MultipartFile postFile) throws IOException {

        // 샘플 사용자 ID (예시)
        Long sampleUser = 1L;

        // PostDTO 객체 생성 및 설정
        PostDTO postDTO = new PostDTO();
        postDTO.setFgPostType("recipe"); // 게시글 유형 설정
        postDTO.setFgPostTitle(receipeWriteDTO.getFgPostTitle()); // 제목 설정
        postDTO.setFgUserCode(sampleUser); // 사용자 ID 설정

        // 게시글 저장
        postService.writePost(postDTO);

        // RecipeWriteDTO에 게시글 ID 설정
        receipeWriteDTO.setFgPostId(postDTO.getFgPostId());

        // 레시피 데이터 저장
        receipeService.writeReceipe(receipeWriteDTO, postFile);

        // 작성된 게시글의 상세 페이지로 리다이렉트
        return "redirect:/recipe/recipeDetail/" + postDTO.getFgPostId();
    }

}

