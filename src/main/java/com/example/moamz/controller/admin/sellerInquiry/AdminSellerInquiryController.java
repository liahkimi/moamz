package com.example.moamz.controller.admin.sellerInquiry;

import com.example.moamz.domain.dto.admin.sellerInquiry.AdminSellerInquiryDetailDTO;
import com.example.moamz.domain.dto.admin.sellerInquiry.AdminSellerInquiryListDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.page.Page;
import com.example.moamz.mapper.admin.sellerInquiry.AdminSellerInquiryMapper;
import com.example.moamz.service.admin.sellerInquiry.AdminSellerInquiryService;
import com.example.moamz.service.admin.userInquiry.AdminUserInquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/sellerInquiry")
@RequiredArgsConstructor
@Slf4j
public class AdminSellerInquiryController {
   private final AdminSellerInquiryService adminSellerInquiryService;

    //판매자 문의목록 보여주기
    @GetMapping("/list")
    public String inquiryList(@SessionAttribute(value="fgUserCode" ,required=false)Long fgUserCode, Criteria criteria, Model model){
        List<AdminSellerInquiryListDTO> adminSellerInquiryListDTO = adminSellerInquiryService.findAllSellerInquiryPage(criteria);
        int total = adminSellerInquiryService.findSellerInquiryTotal(); //판매자문의글 총 갯수
        Page page = new Page(criteria, total);

        model.addAttribute("page", page);
        model.addAttribute("adminSellerInquiryListDTO", adminSellerInquiryListDTO);
        return "admin/adminSellerInquiryList";
    }

    //판매자 문의글 상세페이지 보여주기
    @GetMapping("/detail/{fgPostId}")
    public String inquiryDetail(@PathVariable("fgPostId") Long fgPostId,
                                @SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode, Model model){
        AdminSellerInquiryDetailDTO adminSellerInquiryDetailDTO = adminSellerInquiryService.findInquiryDetail(fgPostId, fgUserCode);

        if(fgUserCode.equals(adminSellerInquiryDetailDTO.getWriterCode())) {
            // 내가 작성한 게시글이면 isMyPost = true
            adminSellerInquiryDetailDTO.setMyPost(true);
        } else {
            // 내가 작상힌 게시글이 아니면 isMyPost = false
            adminSellerInquiryDetailDTO.setMyPost(false);
        }

        model.addAttribute("adminSellerInquiryDetailDTO", adminSellerInquiryDetailDTO);
        log.info("🫠🫠🫠adminSellerInquiryDetailDTO, {}", adminSellerInquiryDetailDTO);
        return "admin/adminSellerInquiryDetail";
    }

    //판매자 문의목록 - '답변완료'버튼으로 상태 바꾸기
    @PostMapping("/list/modifyEcoStatus/{fgPostId}")
    public String modifyEcoStatus(@PathVariable("fgPostId") Long fgPostId,
                                  @SessionAttribute(value="fgUserCode",required=false) Long fgUserCode){
        adminSellerInquiryService.updateStatusBtn(fgPostId);
        return "redirect:/admin/userInquiry/list";
    }
}
