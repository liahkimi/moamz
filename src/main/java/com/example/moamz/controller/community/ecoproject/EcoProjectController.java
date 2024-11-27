package com.example.moamz.controller.community.ecoproject;

import com.example.moamz.domain.dto.community.PostDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoCertDetailDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoCertListDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoCertWriteDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoProjectListDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.page.EcoCertCriteria;
import com.example.moamz.domain.dto.page.Page;
import com.example.moamz.service.community.PostService;
import com.example.moamz.service.community.ecoproject.EcoProjectService;
import com.example.moamz.service.file.PostFileService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/ecoproject")
@RequiredArgsConstructor
public class EcoProjectController {
    private final EcoProjectService ecoProjectService;
    private final PostService postService;
    private final PostFileService postFileService;

    @GetMapping("/projectList")
    public String projectList(Model model, Criteria criteria) {
        criteria.setAmount(2);
        List<EcoProjectListDTO> ecoProjectList = ecoProjectService.showEcoPage(criteria);
        List<EcoProjectListDTO> ecoEndList = ecoProjectService.showEndEcoPage(criteria);

        int total = ecoProjectList.size();
        int totalEnd = ecoEndList.size();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");

        ecoProjectList.forEach(eco -> {
            eco.setFormattedEcoStart(eco.getFgEcoStart().format(formatter));
            eco.setFormattedEcoEnd(eco.getFgEcoEnd().format(formatter));
        });

        Page ecoPage = new Page(criteria, total);
        Page endPage = new Page(criteria, totalEnd);
        model.addAttribute("ecoProjectList", ecoProjectList);
        model.addAttribute("ecoEndList", ecoEndList);
        model.addAttribute("ecoPage", ecoPage);
        model.addAttribute("endPage", endPage);

        return "community/ecoproject/ecoList";
    }

    @GetMapping("/projectEndList")
    public String projectEndList(Model model, Criteria criteria) {
        criteria.setAmount(2);
        List<EcoProjectListDTO> ecoProjectList = ecoProjectService.showEcoPage(criteria);
        List<EcoProjectListDTO> ecoEndList = ecoProjectService.showEndEcoPage(criteria);

        int total = ecoProjectList.size();
        int totalEnd = ecoEndList.size();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy/MM/dd");

        ecoProjectList.forEach(eco -> {
            eco.setFormattedEcoStart(eco.getFgEcoStart().format(formatter));
            eco.setFormattedEcoEnd(eco.getFgEcoEnd().format(formatter));
        });

        Page ecoPage = new Page(criteria, total);
        Page endPage = new Page(criteria, totalEnd);
        model.addAttribute("ecoProjectList", ecoProjectList);
        model.addAttribute("ecoEndList", ecoEndList);
        model.addAttribute("ecoPage", ecoPage);
        model.addAttribute("endPage", endPage);

        return "community/ecoproject/ecoEndList";
    }

    @GetMapping("/ecoCertDetail/{fgPostId}")
    public String ecoCertDetail(@PathVariable("fgPostId") Long fgPostId, Model model) {

        EcoCertDetailDTO certDetail = ecoProjectService.showCertDetail(fgPostId);
        System.out.println("certDetail = " + certDetail);
        System.out.println("project Id dafklnalgknalgnaln" + certDetail.getFgProjectId());
        System.out.println("post Id dafklnalgknalgnaln" + certDetail.getFgPostId());

        model.addAttribute("certDetail", certDetail);
        return "community/ecoproject/ecoCertificationDetatil";
    }


    @GetMapping("/ecoCertWrite/{fgPostId}")
    public String ecoCertWrite(@PathVariable("fgPostId") Long fgProjectId, Model model) {

        model.addAttribute("fgPostId", fgProjectId);
        return "community/ecoproject/ecoCertificationWrite";
    }

    @PostMapping("/ecoCertWrite/{fgPostId}")
    public String ecoCertWrite(@PathVariable("fgPostId") Long fgPostId,
                               @ModelAttribute EcoCertWriteDTO ecoCertWriteDTO,
                               @RequestParam("fgCertContent") String fgCertContent,
                               @RequestParam("fgPostTitle") String fgPostTitle,
                               Model model) {

        model.addAttribute("fgPostId", fgPostId);

        // PostDTO 세팅
        PostDTO postDTO = new PostDTO();
//        postDTO.setFgPostId(ecoCertWriteDTO.getFgPostId());  // ID 설정
        postDTO.setFgPostType("ecoCert");
        postDTO.setFgPostTitle(fgPostTitle);
        postDTO.setFgPostcreatedAt(LocalDateTime.now());
        postDTO.setFgPostlikes(0);
        postDTO.setFgPostviews(0);
        postDTO.setFgPostEdit('0');
//        임시
        postDTO.setFgUserCode(1L);

        ecoCertWriteDTO.setFgCertContent(fgCertContent);
        ecoCertWriteDTO.setFgProjectId(fgPostId);

        postService.writePost(postDTO); // 글 저장
        ecoProjectService.writeCert(ecoCertWriteDTO); // 인증 저장

        // 상세 페이지로 리다이렉트
        return "redirect:/ecoproject/ecoCertDetail/" + ecoCertWriteDTO.getFgPostId();
    }


    @GetMapping("/ecoCertList/{fgPostId}")
    public String ecoCertList(@PathVariable("fgPostId") Long fgProjectId, Model model, EcoCertCriteria ecoCertCriteria) {
        ecoCertCriteria.setAmount(10);
        ecoCertCriteria.setFgProjectId(fgProjectId);

        List<EcoCertListDTO> ecoCertList = ecoProjectService.showEcoCertPage(ecoCertCriteria);
        int total = ecoCertList.size();

        Page page = new Page(ecoCertCriteria, total);

        System.out.println("ecoapsd = " + ecoCertList);
        System.out.println("page = " + page);

        model.addAttribute("ecoCerts", ecoCertList);
        model.addAttribute("fgProjectId", fgProjectId);
        model.addAttribute("page", page);

        return "community/ecoproject/ecoCertificationBoard";
    }
}
