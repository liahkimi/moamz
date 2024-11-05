package com.example.moamz.controller.admin.notice;

import com.example.moamz.domain.dto.admin.notice.NoticeListDTO;
import com.example.moamz.domain.dto.admin.notice.NoticeWriteDTO;
import com.example.moamz.domain.dto.admin.page.Criteria;
import com.example.moamz.domain.dto.admin.page.Page;
import com.example.moamz.service.admin.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    // 공지사항 목록 보여주기
    @GetMapping("/list")
    public String noticeList(Criteria criteria, Model model){ //Model은 ui로 임포트
        List<NoticeListDTO> noticeListDTO = noticeService.findNoticeAll();
        int total = noticeService.findNoticeTotal();
        Page page = new Page(criteria, total);

        model.addAttribute("page", page);
        model.addAttribute("noticeListDTO", noticeListDTO);
        return "admin/adminNoticeList"; //html 연결
    }

    //공지사항 글 작성페이지 보여주기
    @GetMapping("/write")
    public String noticeWrite(@SessionAttribute(value="fgUserCode", required = false) Long fgUserCode){
        return fgUserCode==null ? "redirect:/admin/login" : "/admin/adminNoticeWrite";
    }

    //공지사항 글 작성하기 -글 업로드
    @PostMapping("/write")
    public String noticeWrite(NoticeWriteDTO noticeWriteDTO, @SessionAttribute("fgUserCode") Long fgUserCode,
                              RedirectAttributes redirectAttributes){
        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐");
        noticeWriteDTO.setFgUserCode(fgUserCode);
        System.out.println("서비스 호출 전 noticeWriteDTO : " + noticeWriteDTO);

        // 공지사항 글 등록 메서드 호출
        noticeService.registerNotice(noticeWriteDTO);
        System.out.println("서비스 호출 후 noticeWriteDTO : " + noticeWriteDTO);

        //fgPostId가 제대로 설정되었는지 확인
        if(noticeWriteDTO.getFgPostId() !=null){
            System.out.println("fgPostId가 설정되었습니다 : " + noticeWriteDTO.getFgPostId());
            redirectAttributes.addFlashAttribute("fgPostId", noticeWriteDTO.getFgPostId());
        }else{
            System.out.println("오류 : noticeWriteDTO.getFgPostId()가 서비스 호출 후 null입니다.");
        }
        return "redirect:/admin/notice/list";


    }





}
