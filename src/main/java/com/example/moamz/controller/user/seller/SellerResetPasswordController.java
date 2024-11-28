package com.example.moamz.controller.user.seller;

import com.example.moamz.domain.dto.user.normal.UserResetPasswordDTO;
import com.example.moamz.domain.dto.user.seller.SellerResetPasswordDTO;
import com.example.moamz.service.user.seller.SellerResetService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/seller")
public class SellerResetPasswordController {
    private final SellerResetService sellerResetService;

    @GetMapping("/resetPassword")
    public String resetPassword() {return "/user/seller/sellerFindPassword";}

    //아이디 휴대폰 인증 후 새 비밀번호 페이지 반환
    @PostMapping("/resetPassword")
    public RedirectView findPassword(@RequestParam("fgUserId") String fgUserId,
                                     @RequestParam("fgSellerPhone") String fgSellerPhone,
                                     HttpSession session) {
        log.info("😀😀😀😀아이디,휴대폰번호 : {}, :{}", fgUserId, fgSellerPhone);

        // 아이디 휴대폰 정보 확인
        SellerResetPasswordDTO idPasswordInfo = (sellerResetService.selectPassword(fgUserId, fgSellerPhone));

        if (idPasswordInfo == null) {
            log.warn("인증 실패 : 잘못된 아이디 또는 휴대폰번호");
            return new RedirectView("/user/regular/userPassword?error=true");  // 에러 메시지를 URL에 전달
        }

        log.info("😀😀😀😀아이디,휴대폰번호 : {}, :{}", fgUserId, fgSellerPhone);

        // 인증 성공 시 세션에 사용자 정보 저장 (fgUserId)
        session.setAttribute("fgUserId", idPasswordInfo.getFgUserId());// .getFgUserId();???

        return new RedirectView("/seller/changePasswordSeller?fgUserId=" + fgUserId);
    }

    //새 비밀번호 변경 페이지
    @GetMapping("/changePasswordSeller")
    public String changePassword(@RequestParam("fgUserId") String fgUserId,
                                 Model model) {
        model.addAttribute("fgUserId", fgUserId);
//        return "/user/regular/userResetPassword";
        return "/user/seller/sellerResetPassword";
    }

    // 새 비밀번호 변경
    @PostMapping("/changePasswordSeller")
    public String updatePassword(SellerResetPasswordDTO sellerResetPasswordDTO,
                                 RedirectAttributes redirectAttributes) {
        sellerResetService.updatePassword(sellerResetPasswordDTO);
        redirectAttributes.addAttribute("fgUserId", sellerResetPasswordDTO.getFgUserId());
        return "/user/regular/userLogin";
    }

}
