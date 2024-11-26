package com.example.moamz.controller.admin.eco;

import com.example.moamz.domain.dto.admin.AdminCommentDTO;
import com.example.moamz.domain.dto.admin.eco.*;
import com.example.moamz.domain.dto.admin.notice.AdminNoticeModifyDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.page.Page;
import com.example.moamz.mapper.admin.eco.AdminEcoMapper;
import com.example.moamz.service.admin.eco.AdminEcoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //진행중인 에코프로젝트 목록 보여주기
    @GetMapping("/ingList")
    public String ingEcoList(Criteria criteria, Model model, @SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode) {
        criteria.setAmount(2);

        List<AdminIngEcoListDTO> adminIngEcoListDTO = adminEcoService.findAllIngEcoList(criteria);
        int ingTotal = adminEcoService.findEcoTotal(); //에코프젝 총 갯수
        Page ingPage = new Page(criteria, ingTotal);
        model.addAttribute("ingPage", ingPage);
        model.addAttribute("adminIngEcoListDTO", adminIngEcoListDTO);

        return "admin/adminEcoList";
    }

    //종료된 에코프로젝트 목록 보여주기
    @GetMapping("/finList")
    public String finEcoList(Criteria criteria, Model model, @SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode) {
        criteria.setAmount(2);

        //완료된 에코프젝 목록 dto
        List<AdminFinEcoListDTO> adminFinEcoListDTO = adminEcoService.findAllFinEcoList(criteria);
        int finTotal = adminEcoService.findFinEcoTotal(); //에코프젝 총 갯수
        Page finPage = new Page(criteria, finTotal);
        model.addAttribute("finPage", finPage);
        model.addAttribute("adminFinEcoListDTO", adminFinEcoListDTO);

        log.info("💥💥💥💥+adminFinEcoListDTO, {}", adminFinEcoListDTO);

        return "admin/adminFinEcoList";
    }




    //에코프로젝트 작성페이지 보여주기
    @GetMapping("/write")
    public String ecoWrite(@SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode) {

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

    //에코프젝 상태 버튼클릭으로 변경하기 post
    @PostMapping("/list/modifyEcoStatus/{fgPostId}")
    public String modifyEcoStatusPost(@PathVariable("fgPostId") Long fgPostId,
                                      @SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode) {
        adminEcoService.changeStatusBtn(fgPostId);
        return "redirect:/admin/eco/list";
    }


    // 진행중인 에코프로젝트 인증글목록 불러오기
    @GetMapping("/ecoCertList/{fgPostId}")
    public String ecoCertList(@PathVariable("fgPostId") Long fgPostId , Model model, Criteria criteria,
                              @SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode) {
        List<AdminEcoCertListDTO> adminEcoCertListDTO = adminEcoService.findAllEcoCertPage(criteria, fgPostId);
        int ingCertTotal = adminEcoService.findEcoCertTotal(fgPostId);
        Page ingCertPage = new Page(criteria, ingCertTotal);

        model.addAttribute("fgPostId", fgPostId);
        model.addAttribute("ingCertPage", ingCertPage);
        model.addAttribute("adminEcoCertListDTO", adminEcoCertListDTO);
        return "admin/adminEcoCertifiList";
    }

    // 진행중인 에코프로젝트 인증글 상세보기 페이지 + 댓글 보여주기
    @GetMapping("/ecoCertDetail/{fgPostId}/{fgProjectId}")
    public String ecoCertDetail(@SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode,
                                @PathVariable("fgPostId") Long fgPostId,
                                @PathVariable("fgProjectId") Long fgProjectId, Model model) {
        AdminEcoCertDetailDTO adminEcoCertDetailDTO = adminEcoService.findEcoCertDetail(fgPostId, fgProjectId);
        List<AdminCommentDTO> adminCommentDTO = adminEcoService.findEcoCertDetailComment(fgPostId);
        model.addAttribute("adminCommentDTO", adminCommentDTO);


        adminEcoCertDetailDTO.setFgProjectId(fgProjectId);
        model.addAttribute("adminEcoCertDetailDTO", adminEcoCertDetailDTO);
        return "/admin/adminEcoCertifiDetail";
    }


    // 완료된 에코프로젝트 인증글목록 불러오기
    @GetMapping("/finEcoCertList/{fgPostId}")
    public String finEcoCertList(@PathVariable("fgPostId") Long fgPostId, Model model, Criteria criteria,
                                 @SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode) {
        List<AdminEcoCertListDTO> adminFinEcoCertListDTO = adminEcoService.findAllEcoCertPage(criteria, fgPostId);
        int finCertTotal = adminEcoService.findEcoCertTotal(fgPostId);
        Page finCertPage = new Page(criteria, finCertTotal);

        System.out.println("Total Certification Count: " + finCertTotal);

        // prev, next 값 출력
        System.out.println("prev: " + finCertPage.isPrev());  // prev 값 확인
        System.out.println("next: " + finCertPage.isNext());  // next 값 확인

        model.addAttribute("fgPostId", fgPostId);
        model.addAttribute("finCertPage", finCertPage);
        model.addAttribute("adminFinEcoCertListDTO", adminFinEcoCertListDTO);

        log.info("✔️✔️✔️✔️✔️+adminFinEcoCertListDTO, {}", adminFinEcoCertListDTO);

        System.out.println("adminEcoCertListDTO = " + adminFinEcoCertListDTO);
        return "admin/adminEcoCertifiListFin";
    }

    //완료된 에코프로젝트 인증글 상세보기 보여주기
    @GetMapping("/finEcoCertDetail/{fgPostId}/{fgProjectId}")
    public String finEcoCertDetail(@SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode,
                                   @PathVariable("fgPostId") Long fgPostId,
                                   @PathVariable("fgProjectId") Long fgProjectId, Model model) {
        AdminEcoCertDetailDTO adminEcoCertDetailDTO = adminEcoService.findEcoCertDetail(fgPostId, fgProjectId);
        adminEcoCertDetailDTO.setFgProjectId(fgProjectId);
        model.addAttribute("adminEcoCertDetailDTO", adminEcoCertDetailDTO);

        List<AdminCommentDTO> adminCommentDTO = adminEcoService.findEcoCertDetailComment(fgPostId);
        model.addAttribute("adminCommentDTO", adminCommentDTO);

        if (adminCommentDTO == null) {
            log.info("💥💥💥💥adminCommentDTO is null");
        } else {
            log.info("💥💥💥💥adminCommentDTO : {}", adminCommentDTO);
        }
        return "/admin/adminEcoCertifiDetailFin";
    }


    //    //진행중인 에코프로젝트 수정하기 페이지 보여주기
//    @GetMapping("/modify/{fgPostId}")
//    public String ecoModify(@PathVariable("fgPostId") Long fgPostId, Model model){
//        AdminIngEcoListDTO adminIngEcoListDTO = adminEcoService.findEcoProjectById(fgPostId);
//        model.addAttribute("adminIngEcoListDTO", adminIngEcoListDTO);
//        return "/admin/adminEcoModify";
//    }
//
    //특정 에코프로젝트 삭제하기
    @GetMapping("/remove/{fgPostId}")
    public String ecoRemove(@PathVariable("fgPostId") Long fgPostId) {
        adminEcoService.removeEcoProject(fgPostId);
        return "redirect:/admin/eco/list";
    }


    // 특정 에코프로젝트 인증글 작성자에게 포인트 지급해주기
    // 지급버튼 클릭시, fgPostId가 모달창에 전달되도록 getMapping하는 부분
    @GetMapping("/updatePoint/{fgPostId}")
    public String ecoPoint(@SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode,
                           @PathVariable("fgPostId") Long fgPostId,
                           @ModelAttribute AdminEcoCertPointBtnDTO adminEcoCertPointBtnDTO,
                           @RequestParam("fgPointReceived") long fgPointReceived) {
       // DTO에 fgPostId와 fgPointReceived값 설정
        adminEcoCertPointBtnDTO.setFgPostId(fgPostId);
        adminEcoCertPointBtnDTO.setFgPointReceived(fgPointReceived);

        // 포인트 지급 및 내역 기록 서비스 호출
        adminEcoService.giveUserEcoPointAndLog(adminEcoCertPointBtnDTO);

        // 리다이렉트 URL에 fgPostId 포함
        return "redirect:/admin/eco/finEcoCertList/" + fgPostId;
    }


    @PostMapping("/updatePoint")
    @ResponseBody
    public ResponseEntity<?> givePoints(@RequestBody AdminEcoCertPointBtnDTO adminEcoCertPointBtnDTO,
                                        @SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode) {

        Long fgPostId = adminEcoCertPointBtnDTO.getFgPostId();  // @RequestBody로 받아온 fgPostId 사용
        log.info("💥fgPostId: " + fgPostId);
        log.info("💥fgPointReceived: " + adminEcoCertPointBtnDTO.getFgPointReceived());
        log.info("💥fgPointReceived: " + adminEcoCertPointBtnDTO.getFgUserCode());
        log.info("💥fgPointReceived: " + adminEcoCertPointBtnDTO.getFgPointId());

        if (fgUserCode == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }

        try {
            adminEcoService.giveUserEcoPointAndLog(adminEcoCertPointBtnDTO);
            log.info("🥲🥲🥲🥲 adminEcoCertPointBtnDTO =", adminEcoCertPointBtnDTO);
            return ResponseEntity.ok("포인트 지급 완료");
        } catch (Exception e) {
            log.error("포인트 지급 중 오류 발생 {}", e.getMessage());
            log.info("🫠adminEcoCertPointBtnDTO: " + (adminEcoCertPointBtnDTO != null ? adminEcoCertPointBtnDTO.toString() : "DTO is null"));

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"포인트 지급 실패\"}");
        }
    }




}
    








