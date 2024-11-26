package com.example.moamz.controller.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.info.SellerProfileDTO;
import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryCommentDTO;
import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryDetailDTO;
import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryListDTO;
import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryWriteDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.page.Page;
import com.example.moamz.mapper.mypage.seller.SellerInquiryMapper;
import com.example.moamz.service.mypage.seller.SellerInquiryService;
import com.example.moamz.service.mypage.seller.SellerMyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/seller/inquiry")
public class SellerInquiryController {
    public final SellerInquiryService sellerInquiryService;
    public final SellerMyService sellerMyService;

    // 문의글 등록 페이지 열기
    @GetMapping("/regist")
    public String regist(@SessionAttribute(value="fgUserCode", required=false) Long userCode) {
        // 세션에 userCode가 null이면 로그인 페이지로 리다이렉트
        // null이 아니면 문의글 등록 페이지로 연결
        return userCode==null ? "redirect:/seller/seller/sellerLogin" :
                "mypage/seller/sellerAdminInquiryWrite";
    }

    // 문의글 목록 페이지 열기
    @GetMapping("/list")
    public String list(@SessionAttribute(value="fgUserCode", required=false) Long userCode,
                        Criteria criteria,
                        Model model) {
        // 세션에 userCode가 null이면 로그인 페이지로 리다이렉트
        if(userCode == null) {
            return "redirect:/seller/seller/sellerLogin";
        }

        // 현재 로그인한 판매자의 businessId값 찾기
        Long businessId = sellerMyService.findBusinessId(userCode);

        // 판매자 프로필 가져오기
        SellerProfileDTO sellerProfileDTO = sellerMyService.getSellerProfile(businessId, userCode);

        // 한 페이지에 게시글 20개씩 보이도록 설정
        criteria.setAmount(20);

        // 페이징을 포함한 목록 반환
        List<InquiryListDTO> inquiryList = sellerInquiryService.findInquiryListAll(userCode, criteria);
        // 전체 문의글 수
        int total = sellerInquiryService.findTotal(userCode);
        Page page = new Page(criteria, total);

        // 모델에 문의글 목록, 판매자 프로필 추가해서 뷰로 전달
        model.addAttribute("page", page);
        model.addAttribute("inquiryList", inquiryList);
        model.addAttribute("sellerProfileDTO", sellerProfileDTO);

        return "mypage/seller/sellerAdminInquiryList";
    }

    // 문의글 등록 post 요청 처리
    @PostMapping("/regist")
    public String regist(InquiryWriteDTO inquiryWriteDTO,
                         @SessionAttribute(value="fgUserCode", required = false) Long userCode,
                         RedirectAttributes redirectAttributes) {
        // 세션의 userCode를 DTO에 넣어주기
        inquiryWriteDTO.setUserCode(userCode);

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
    public String detail(@PathVariable("postId") Long postId,
                         @SessionAttribute(value="fgUserCode", required=false) Long userCode,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        // 세션에 userCode가 null이면 로그인 페이지로 리다이렉트
        if(userCode == null) {
            return "redirect:/seller/seller/sellerLogin";
        }

        // 문의글 상세정보 가져오는 메서드
        InquiryDetailDTO inquiryDetailDTO = sellerInquiryService.findInquiryDetail(postId);

        log.info("💛💛💛dto의 userCode : {}", inquiryDetailDTO.getUserCode());
        log.info("💛💛💛세션의 userCode : {}", userCode);

        if (userCode.equals(inquiryDetailDTO.getUserCode())) {
            // 상세 문의글 DTO를 모델에 담아서 뷰로 전달
            model.addAttribute("inquiryDetailDTO", inquiryDetailDTO);

            // 댓글 리스트 가져오는 메서드
            List<InquiryCommentDTO> commentList = sellerInquiryService.findInquiryComment(postId);

            // 댓글 DTO 모델에 담아서 뷰로 전달달
            model.addAttribute("commentList", commentList);

            return "mypage/seller/sellerAdminInquiryDetail";
        } else {
            // 세션의 userCode와 DTO의 userCode값이 다르면 상세글에 접근할 수 없다.
            // alert 메시지를 추가.. 실제 alert는 리다이렉트된 뷰에서 뜨게 된다.
            redirectAttributes.addFlashAttribute("Message", "본인이 작성하지 않은 문의글은 조회할 수 없습니다.");
            return "redirect:/seller/inquiry/list";
        }
    }

    // 게시글 삭제하기
    @GetMapping("/removeInquiry/{postId}")
    public String deletePost(@PathVariable("postId") Long postId,
                             RedirectAttributes redirectAttributes) {
        // 게시글 삭제하기
        sellerInquiryService.removeInquiry(postId);

        // view에 alert Message 전달하기
        redirectAttributes.addFlashAttribute("Message", "삭제되었습니다.");

        return "redirect:/seller/inquiry/list";
    }

}
