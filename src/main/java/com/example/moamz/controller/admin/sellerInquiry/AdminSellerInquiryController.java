package com.example.moamz.controller.admin.sellerInquiry;

import com.example.moamz.domain.dto.admin.sellerInquiry.AdminSellerInquiryDetailDTO;
import com.example.moamz.domain.dto.admin.sellerInquiry.AdminSellerInquiryListDTO;
import com.example.moamz.mapper.admin.sellerInquiry.AdminSellerInquiryMapper;
import com.example.moamz.service.admin.sellerInquiry.AdminSellerInquiryService;
import com.example.moamz.service.admin.userInquiry.AdminUserInquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("admin/sellerInquiry")
@RequiredArgsConstructor
@Slf4j
public class AdminSellerInquiryController {
   private final AdminSellerInquiryService adminSellerInquiryService;

    //판매자 문의목록 보여주기
    @GetMapping("/list")
    public String inquiryList(@SessionAttribute(value="fgUserCode")Long fgUserCode, Model model){
        List<AdminSellerInquiryListDTO> adminSellerInquiryListDTO = adminSellerInquiryService.findInquiryList();

        model.addAttribute("adminSellerInquiryListDTO", adminSellerInquiryListDTO);
        return "admin/adminSellerInquiryList";
    }

    //판매자 문의글 상세페이지 보여주기
    @GetMapping("/detail")
    public String inquiryDetail(@SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode, Model model
                                ,@RequestParam("fgPostId") Long fgPostId){
        AdminSellerInquiryDetailDTO adminSellerInquiryDetailDTO = adminSellerInquiryService.findInquiryDetail(fgPostId);

        model.addAttribute("adminSellerInquiryDetailDTO", adminSellerInquiryDetailDTO);
        return "admin/adminSellerInquiryDetail";
    }
}
