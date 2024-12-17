package com.example.moamz.controller.admin.notice;

import com.example.moamz.domain.dto.admin.notice.AdminNoticeDetailDTO;
import com.example.moamz.domain.dto.admin.notice.AdminNoticeListDTO;
import com.example.moamz.domain.dto.admin.notice.AdminNoticeModifyDTO;
import com.example.moamz.domain.dto.admin.notice.AdminNoticeWriteDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.page.Page;
import com.example.moamz.service.admin.notice.AdminNoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("admin/notice")
@RequiredArgsConstructor
@Slf4j
public class AdminNoticeController {
    private final AdminNoticeService adminNoticeService;

    // 공지사항 목록 보여주기
    @GetMapping("/list")
    public String noticeList(@SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode, Criteria criteria, Model model) { //Model은 ui로 임포트
        List<AdminNoticeListDTO> adminNoticeListDTO = adminNoticeService.findAllNoticePage(criteria);
        int total = adminNoticeService.findNoticeTotal(); //공지사항 글 총갯수
        Page page = new Page(criteria, total);

        model.addAttribute("page", page);
        model.addAttribute("adminNoticeListDTO", adminNoticeListDTO);
        return fgUserCode == null ? "redirect:/admin/login?error=sessionExpired" : "admin/adminNoticeList";
    }

    //공지사항 글 작성페이지 보여주기
    @GetMapping("/write")
    public String noticeWrite(@SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode) {
        return fgUserCode == null ? "redirect:/admin/login?error=sessionExpired" : "/admin/adminNoticeWrite";
    }

    //공지사항 글 작성하기 -글 업로드
    @PostMapping("/write")
    public String noticeWrite(AdminNoticeWriteDTO adminNoticeWriteDTO, @SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode,
                              RedirectAttributes redirectAttributes) {

        // 세션이 없으면 로그인 페이지로 리다이렉트
        if (fgUserCode == null) {
            return "redirect:/admin/login?error=sessionExpired"; // 세션 만료 오류 메시지 추가
        }

        adminNoticeWriteDTO.setFgUserCode(fgUserCode);

        // 공지사항 글 등록 메서드 호출
        adminNoticeService.registerNotice(adminNoticeWriteDTO);

        //fgPostId가 제대로 설정되었는지 확인
        if (adminNoticeWriteDTO.getFgPostId() != null) {
            System.out.println("fgPostId가 설정되었습니다 : " + adminNoticeWriteDTO.getFgPostId());
            redirectAttributes.addFlashAttribute("fgPostId", adminNoticeWriteDTO.getFgPostId());
        } else {
            System.out.println("오류 : adminNoticeWriteDTO.getFgPostId()가 서비스 호출 후 null입니다.");
        }
        return "redirect:/admin/notice/list";
    }

    //공지사항글 상세보기
    @GetMapping("/detail")
    public String noticeDetail(@RequestParam("fgPostId") Long fgPostId, Model model
            ,@SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode) {
        System.out.println("view 컨트롤러");
        AdminNoticeDetailDTO adminNoticeDetailDTO = adminNoticeService.findNoticeById(fgPostId);


        model.addAttribute("adminNoticeDetailDTO", adminNoticeDetailDTO);
        return fgUserCode == null ? "redirect:/admin/login?error=sessionExpired" : "/admin/adminNoticeDetail";
    }

    //공지사항 수정페이지 보여주기
    @GetMapping("/modify")
    public String noticeModify(@RequestParam("fgPostId") Long fgPostId, Model model
            ,@SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode){
        AdminNoticeDetailDTO adminNoticeDetailDTO = adminNoticeService.findNoticeById(fgPostId);
        model.addAttribute("adminNoticeDetailDTO", adminNoticeDetailDTO);
        return fgUserCode == null ? "redirect:/admin/login?error=sessionExpired" : "admin/adminNoticeModify";
    }

    //공지사항 수정하기
    @PostMapping("/modify")
    public String noticeModify(AdminNoticeModifyDTO adminNoticeModifyDTO,
                               RedirectAttributes redirectAttributes
            ,@SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode){
        try {
            adminNoticeService.modifyNotice(adminNoticeModifyDTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        redirectAttributes.addAttribute("fgPostId", adminNoticeModifyDTO.getFgPostId());
        return fgUserCode == null ? "redirect:/admin/login?error=sessionExpired" : "redirect:/admin/notice/detail";
    }

    //공지사항 게시글 삭제하기
//    @GetMapping("/remove/{fgPostId}")
//    public String noticeRemove(@PathVariable("fgPostId") Long fgPostId
//            ,@SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode){
//        adminNoticeService.removeNotice(fgPostId);
//        return fgUserCode == null ? "redirect:/admin/login" : "redirect:/admin/notice/list";
//    }
    @GetMapping("/remove/{fgPostId}")
    public String noticeRemove(
            @PathVariable("fgPostId") Long fgPostId,
            @SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode) {

        // 세션이 없는 경우
        if (fgUserCode == null) {
            return "redirect:/admin/login?error=sessionExpired"; // 세션 만료 메시지 추가
        }

        // 세션이 있는 경우 삭제 수행
        adminNoticeService.removeNotice(fgPostId);
        return "redirect:/admin/notice/list";
    }










}