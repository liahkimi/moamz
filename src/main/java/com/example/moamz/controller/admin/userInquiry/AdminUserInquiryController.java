package com.example.moamz.controller.admin.userInquiry;

import com.example.moamz.domain.dto.admin.userInquiry.AdminUserInquiryDetailDTO;
import com.example.moamz.domain.dto.admin.userInquiry.AdminUserInquiryListDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.page.Page;
import com.example.moamz.service.admin.userInquiry.AdminUserInquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/userInquiry")
@RequiredArgsConstructor
@Slf4j
public class AdminUserInquiryController {

    private final AdminUserInquiryService adminUserInquiryService;

    //일반회원 문의목록 보여주기
    @GetMapping("/list")
    public String inquiryList(@SessionAttribute(value="fgUserCode",required=false) Long fgUserCode, Criteria criteria, Model model){
        List<AdminUserInquiryListDTO> adminUserInquiryListDTO = adminUserInquiryService.findAllUserInquiryPage(criteria);
        int total = adminUserInquiryService.findUserInquiryTotal(); //일반회원문의글 총 갯수
        Page page = new Page(criteria, total);

        model.addAttribute("page", page);
        model.addAttribute("adminUserInquiryListDTO", adminUserInquiryListDTO);

        return fgUserCode == null ? "redirect:/admin/login?error=sessionExpired" : "admin/adminUserInquiryList";
    }

    //문의 상세페이지 보여주기
//    @GetMapping("/detail/{fgPostId}")
//    public String inquiryDetail(@PathVariable("fgPostId") Long fgPostId,
//                                @SessionAttribute(value="fgUserCode",required=false) Long fgUserCode, Model model){
//        AdminUserInquiryDetailDTO adminUserInquiryDetailDTO = adminUserInquiryService.findInquiryDetail(fgPostId, fgUserCode);
//
////        if(fgUserCode.equals(adminUserInquiryDetailDTO.getWriterCode())) {
////            // 내가 작성한 게시글이면 isMyPost = true
////            adminUserInquiryDetailDTO.setMyPost(true);
////        } else {
////            // 내가 작성힌 게시글이 아니면 isMyPost = false
////            adminUserInquiryDetailDTO.setMyPost(false);
////        }
//
//        model.addAttribute("adminUserInquiryDetailDTO", adminUserInquiryDetailDTO);
//        return "admin/adminUserInquiryDetail";
//    }
    // 일반회원 문의 상세페이지 보여주기
    @GetMapping("/detail/{fgPostId}")
    public String inquiryDetail(@PathVariable("fgPostId") Long fgPostId,
                                @SessionAttribute(value="fgUserCode", required=false) Long fgUserCode, Model model) {
        // 문의 상세 내용을 가져옵니다.
        AdminUserInquiryDetailDTO adminUserInquiryDetailDTO = adminUserInquiryService.findInquiryDetail(fgPostId, fgUserCode);

        // inquiryContent 내의 줄바꿈 문자를 <br>로 변환
        String formattedContent = adminUserInquiryDetailDTO.getFgInquiryContent().replaceAll("\n", "<br>");

        // 변환된 내용을 DTO에 다시 설정 (기존의 inquiryContent에 업데이트)
        adminUserInquiryDetailDTO.setFgInquiryContent(formattedContent);

        // 모델에 DTO 추가
        model.addAttribute("adminUserInquiryDetailDTO", adminUserInquiryDetailDTO);

        // 상세 페이지로 이동
        return fgUserCode == null ? "redirect:/admin/login?error=sessionExpired" : "admin/adminUserInquiryDetail";
    }


    //일반회원 문의목록 - '답변완료'버튼으로 상태 바꾸기
    @PostMapping("/list/modifyEcoStatus/{fgPostId}")
    public String modifyEcoStatus(@PathVariable("fgPostId") Long fgPostId,
                                  @SessionAttribute(value="fgUserCode",required=false) Long fgUserCode){
        // 세션이 없으면 로그인 페이지로 리다이렉트
        if (fgUserCode == null) {
            return "redirect:/admin/login?error=sessionExpired"; // 세션 만료 오류 메시지 추가
        }
        adminUserInquiryService.updateStatusBtn(fgPostId);
        return "redirect:/admin/userInquiry/list";
    }


}
























