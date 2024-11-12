package com.example.moamz.controller.community.receipe;

import com.example.moamz.domain.dto.community.receipe.ReceipeDetailDTO;
import com.example.moamz.domain.dto.community.receipe.ReceipeListDTO;
import com.example.moamz.service.community.PostService;
import com.example.moamz.service.community.receipe.ReceipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

        return "/community/receipe/receipeList";
    }

    @GetMapping("/recipeDetail/{fgPostId}")
    public String receipeDetail(@PathVariable("fgPostId") Long fgPostId, Model model) {
        ReceipeDetailDTO receipeDetail = receipeService.showReceipeDetail(fgPostId);

        model.addAttribute("receipeDetail", receipeDetail);
        model.addAttribute("fgPostId", fgPostId);
        return "/community/receipe/receipeDetail";
    }
}

