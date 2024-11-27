package com.example.moamz.controller.community.socialing;

import com.example.moamz.domain.dto.community.PostDTO;
import com.example.moamz.domain.dto.community.socialing.SocialingDetailDTO;
import com.example.moamz.domain.dto.community.socialing.SocialingListDTO;
import com.example.moamz.domain.dto.community.socialing.SocialingWriteDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.page.Page;
import com.example.moamz.domain.dto.page.SocialCriteria;
import com.example.moamz.service.community.PostService;
import com.example.moamz.service.community.socialing.SocialingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/socialing")
@RequiredArgsConstructor
public class SocialingController {

    private final SocialingService socialingService;
    private final PostService postService;

//    @GetMapping("/list")
//    public String soclialingList(Model model, SocialCriteria socialCriteria) {
//        socialCriteria.setAmount(8);
//        socialCriteria.setCategory("함께먹어요");
//        List<SocialingListDTO> socialList = socialingService.showSocialingPage(socialCriteria);
//
//        int total = socialingService.totalSocialing(socialCriteria.getCategory());
//
//        System.out.println("카테고리" + socialCriteria.getCategory());
//        Page page = new Page(socialCriteria, total);
//
//        model.addAttribute("page", page);
//        model.addAttribute("socialList", socialList);
//        model.addAttribute("selectedCategory", socialCriteria.getCategory());
//        System.out.println("socialList = " + socialList);
//        return "/community/socialing/socialingList";
//    }

    @GetMapping("/list")
    public String socialingList(Model model,
                                @RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "category", defaultValue = "함께먹어요") String category) {

        // SocialCriteria 객체 생성
        SocialCriteria socialCriteria = new SocialCriteria();
        socialCriteria.setPage(page);
        socialCriteria.setAmount(8); // 한 페이지당 게시글 개수
        socialCriteria.setCategory(category); // URL에서 받은 category 값 설정

        // 카테고리별로 게시글 목록 조회
        List<SocialingListDTO> socialList = socialingService.showSocialingPage(socialCriteria);

        // 카테고리별 게시글 총 개수 조회
        int total = socialingService.totalSocialing(socialCriteria.getCategory());

        // 페이지 객체 생성
        Page pageInfo = new Page(socialCriteria, total);

        // 모델에 데이터 전달
        model.addAttribute("page", pageInfo);
        model.addAttribute("socialList", socialList);
        model.addAttribute("selectedCategory", category); // 선택된 카테고리 전달

        System.out.println("카테고리: " + category);
        System.out.println("socialList: " + socialList);

        // 뷰 반환
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
    public String socialingWritePost(@ModelAttribute SocialingWriteDTO socialingWriteDTO,
                                     @RequestParam("postFile") MultipartFile postFile) throws IOException {

        Long sampleUser = 1L;

        PostDTO postDTO = new PostDTO();
        postDTO.setFgPostType("socialing");
        postDTO.setFgPostTitle(socialingWriteDTO.getFgPostTitle());
        postDTO.setFgUserCode(sampleUser);


        postService.writePost(postDTO);


        socialingWriteDTO.setFgPostId(postDTO.getFgPostId());
        socialingService.writeSocialing(socialingWriteDTO, postFile);


        return "redirect:/socialing/socialingDetail/" + postDTO.getFgPostId();
    }


}









