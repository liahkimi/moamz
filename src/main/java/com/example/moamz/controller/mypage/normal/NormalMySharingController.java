package com.example.moamz.controller.mypage.normal;

import com.example.moamz.domain.dto.mypage.normal.MySharingDTO;
import com.example.moamz.domain.dto.mypage.normal.info.NormalProfileDTO;
import com.example.moamz.service.mypage.normal.NormalMySharingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/normal/my/sharing")
@RequiredArgsConstructor
@Slf4j
public class NormalMySharingController {

    private final NormalMySharingService normalMySharingService;


//    @GetMapping("/profile")
//    public String showUserMySharingPage(Model model) {
//        // 필요한 데이터 로딩
//        NormalProfileDTO normalProfileDTO = Service.getNormalProfileDTO();
//        model.addAttribute("normalProfileDTO", normalProfileDTO);
//        return "mypage/regular/userMySharing";
//    }

    // '나눔 가능 상태' 조회
    @GetMapping("/possible")
    public String getSharingPossible(Model model) {
        List<MySharingDTO> sharingPossibleList = normalMySharingService.getSharingPossible();
        model.addAttribute("sharingPossibleList", sharingPossibleList);
        log.info("😊😊😊Getting sharing possible posts...:{}", sharingPossibleList);
        return "/mypage/regular/userMySharing";
    }

    // '예약 중 상태' 조회
    @GetMapping("/reservation")
    public String getSharingReservation(Model model) {
        log.info("Getting sharing reservation posts...");
        List<MySharingDTO> sharingReservationList = normalMySharingService.getSharingReservation();
        model.addAttribute("sharingReservationList", sharingReservationList);
        return "/mypage/regular/userMySharing";
    }

    // '나눔 완료 상태' 조회
    @GetMapping("/completed")
    public String getSharingCompleted(Model model) {
        log.info("Getting sharing completed posts...");
        List<MySharingDTO> sharingCompletedList = normalMySharingService.getSharingCompleted();
        model.addAttribute("sharingCompletedList", sharingCompletedList);
        return "/mypage/regular/userMySharing";
    }
}
