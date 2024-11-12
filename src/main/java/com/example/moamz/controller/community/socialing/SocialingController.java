package com.example.moamz.controller.community.socialing;

import com.example.moamz.domain.dto.community.PostDTO;
import com.example.moamz.domain.dto.community.socialing.SocialingDetailDTO;
import com.example.moamz.domain.dto.community.socialing.SocialingListDTO;
import com.example.moamz.domain.dto.community.socialing.SocialingWriteDTO;
import com.example.moamz.service.community.PostService;
import com.example.moamz.service.community.socialing.SocialingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/socialing")
@RequiredArgsConstructor
public class SocialingController {

    private final SocialingService socialingService;
    private final PostService postService;

    @GetMapping("/list")
    public String soclialingList(Model model) {
        List<SocialingListDTO> socialList = socialingService.showSocialing();

        model.addAttribute("socialList", socialList);
        return "/community/socialing/socialingList";
    }

    @GetMapping("/socialingDetail/{fgPostId}")
    public String socialingDetail(@PathVariable("fgPostId") Long fgPostId, Model model) {

        SocialingDetailDTO socialingDetail = socialingService.socialingDeatil(fgPostId);

        model.addAttribute("socialingDetail", socialingDetail);
        model.addAttribute("fgPostId", fgPostId);
        return "/community/socialing/socialingDetail";
    }

    @GetMapping("/socialingWrite")
    public String socialingWrite() {
        return "/community/socialing/socialingWrite";
    }

    @PostMapping("/socialingWrite")
    public String socialingWritePost(@ModelAttribute SocialingWriteDTO socialingWriteDTO) {

        Long sampleUser = 1L;

        PostDTO postDTO = new PostDTO();
        postDTO.setFgPostType("socialing");
        postDTO.setFgPostTitle(socialingWriteDTO.getFgPostTitle());
        postDTO.setFgUserCode(sampleUser);


        postService.writePost(postDTO);


        socialingWriteDTO.setFgPostId(postDTO.getFgPostId());
        socialingService.writeSocialing(socialingWriteDTO);


        return "redirect:/socialing/socialingDetail/" + postDTO.getFgPostId();
    }


}









