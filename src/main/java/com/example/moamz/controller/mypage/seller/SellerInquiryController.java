package com.example.moamz.controller.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryCommentDTO;
import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryDetailDTO;
import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryListDTO;
import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryWriteDTO;
import com.example.moamz.mapper.mypage.seller.SellerInquiryMapper;
import com.example.moamz.service.mypage.seller.SellerInquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/seller/inquiry")
public class SellerInquiryController {
    public final SellerInquiryService sellerInquiryService;

    // 문의글 등록 페이지 열기
    @GetMapping("/regist")
    public String regist() {
        return "mypage/seller/sellerAdminInquiryWrite";
    }

    // 문의글 목록 페이지 열기
    @GetMapping("/list")
    public String list(Model model) {
        //😑😑현재 로그인한 사용자 userCode 필요..
        Long userCode = 1L;

        // 목록 가져오기 메서드
        List<InquiryListDTO> inquiryList = sellerInquiryService.findInquiryList(userCode);

        // 모델에 목록 추가
        model.addAttribute("inquiryList", inquiryList);

        return "mypage/seller/sellerAdminInquiryList";
    }

    // 문의글 등록 post 요청 처리
    @PostMapping("/regist")
    public String regist(InquiryWriteDTO inquiryWriteDTO,
                         RedirectAttributes redirectAttributes) {
        // 😑😑세션 없어서 userCode값에 1 넣음
        inquiryWriteDTO.setUserCode(1L);

        // 서비스 호출 전 dto
        System.out.println("⭐⭐⭐⭐⭐DTO : " + inquiryWriteDTO);

        // 문의글 등록 메서드 호출
        sellerInquiryService.registInquiry(inquiryWriteDTO);

        // 정상적으로 등록되었는지를 확인
        if(inquiryWriteDTO.getPostId() != null) {
            log.info("⭕postId가 설정되었습니다 [{}]", inquiryWriteDTO.getPostId());
            // 정상 등록되면 postId를 URL 경로로 전달하여 상세보기 페이지로 리다이렉트
            return "redirect:/seller/inquiry/detail/" + inquiryWriteDTO.getPostId();
        } else {
            log.warn("❌오류 : inquiryWriteDTO.getPostId()가 null");
            // 오류 발생하면 목록으로 리다이렉트?
            return "redirect:/seller/inquiry/list";
        }
    }

    // 문의글 상세보기 페이지 열기
    @GetMapping("/detail/{postId}")
    public String detail(@PathVariable("postId") Long postId, Model model) {
        // 문의글 상세정보 가져오는 메서드
        InquiryDetailDTO inquiryDetailDTO = sellerInquiryService.findInquiryDetail(postId);
        log.info("🌟🌟🌟🌟🌟inquiryDetailDTO : {}", inquiryDetailDTO);
        // 상세 문의글 DTO를 모델에 담아서 뷰로 전달
        model.addAttribute("inquiryDetailDTO", inquiryDetailDTO);
        log.info("🌟🌟🌟🌟🌟model : {}", model);


        // 댓글 리스트 가져오는 메서드
        List<InquiryCommentDTO> commentList = sellerInquiryService.findInquiryComment(postId);
        log.info("🌟🌟🌟🌟postId : {}", postId);
        log.info("🌟🌟🌟🌟🌟commentList : " + commentList);
        // 댓글 DTO 모델에 담아서 뷰로 전달달
        model.addAttribute("commentList", commentList);

        return "mypage/seller/sellerAdminInquiryDetail";
    }

}
