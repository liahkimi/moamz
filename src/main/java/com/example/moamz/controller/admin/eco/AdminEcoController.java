package com.example.moamz.controller.admin.eco;

import com.example.moamz.domain.dto.admin.eco.AdminEcoStatusUpdateDTO;
import com.example.moamz.domain.dto.admin.eco.AdminFinEcoListDTO;
import com.example.moamz.domain.dto.admin.eco.AdminIngEcoListDTO;
import com.example.moamz.domain.dto.admin.eco.AdminEcoWriteDTO;
import com.example.moamz.domain.dto.admin.notice.AdminNoticeModifyDTO;
import com.example.moamz.service.admin.eco.AdminEcoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("admin/eco")
@RequiredArgsConstructor
@Slf4j
public class AdminEcoController {
    private final AdminEcoService adminEcoService;

    //진행OR종료된 에코프로젝트 목록 보여주기
    @GetMapping("/list")
    public String ingEcoList(Model model, @SessionAttribute(value="fgUserCode", required = false) Long fgUserCode){

        List<AdminIngEcoListDTO> adminIngEcoListDTO = adminEcoService.findIngEcoList();
        model.addAttribute("adminIngEcoListDTO", adminIngEcoListDTO);

        List<AdminFinEcoListDTO> adminFinEcoListDTO = adminEcoService.findFinEcoList();
        model.addAttribute("adminFinEcoListDTO", adminFinEcoListDTO);
        System.out.println("adminIngEcoListDTO = " + adminIngEcoListDTO);
            return "admin/adminEcoList";
        }


    //에코프로젝트 작성페이지 보여주기
    @GetMapping("/write")
    public String ecoWrite(@SessionAttribute(value="fgUserCode", required = false) Long fgUserCode) {

        return fgUserCode == null ? "redirect:/admin/login" : "/admin/adminEcoWrite";

    }

    //에코프로젝트 작성하기
    @PostMapping("/write")
    public String ecoWrote(@ModelAttribute AdminEcoWriteDTO adminEcoWriteDTO,
                           @SessionAttribute("fgUserCode") Long fgUserCode,
                           RedirectAttributes redirectAttributes,
                           @RequestParam("postFile") List<MultipartFile> files) {
        adminEcoWriteDTO.setFgUserCode(fgUserCode);  // 작성자 정보 넣기
        System.out.println("서비스 호출 전 adminEcoWriteDTO : " + adminEcoWriteDTO);

        try {
            adminEcoService.registerEco(adminEcoWriteDTO, files);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("서비스 호출 후 adminEcoWriteDTO : " + adminEcoWriteDTO);

        // fgPostId가 제대로 설정되었는지 확인
        if (adminEcoWriteDTO.getFgPostId() != null) {
            System.out.println("fgPostId가 설정되었습니다." + adminEcoWriteDTO.getFgPostId());
            redirectAttributes.addFlashAttribute("fgPostId", adminEcoWriteDTO.getFgPostId());
        } else {
            System.out.println("오류 : adminEcoWriteDTO.getFgPostId가 서비스 호출 후 null입니다.");
        }

        return "redirect:/admin/eco/list";
    }

    //에코프젝 상태 버튼클릭으로 변경하기
    @PostMapping("/list/modifyEcoStatus/{fgPostId}")
    public String modifyEcoStatusPost(@PathVariable("fgPostId") Long fgPostId){
        adminEcoService.changeStatusBtn(fgPostId);
//        redirectAttributes.addAttribute("fgPostId", fgPostId);
        return "redirect:/admin/eco/list";
    }

    @GetMapping("/list/modifyEcoStatus/{fgPostId}")
    public String modifyEcoStatusGet(){
        return "redirect:/admin/eco/list";
    }



    }




