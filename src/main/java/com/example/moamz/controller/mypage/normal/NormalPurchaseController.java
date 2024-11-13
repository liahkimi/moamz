package com.example.moamz.controller.mypage.normal;

import com.example.moamz.domain.dto.mypage.normal.PurchaseDetailDTO;
import com.example.moamz.domain.dto.mypage.normal.PurchaseHistoryDTO;
import com.example.moamz.service.mypage.normal.NormalPurchaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("/normal/purchase")
@RequiredArgsConstructor
@Slf4j
public class NormalPurchaseController {

    private final NormalPurchaseService normalPurchaseService; // 서비스 클래스 주입
//    private final NormalProfileService noramlProfileService; // 프로필

    // 마이페이지 > 상품 구매 내역 페이지
    @GetMapping("/list")
    public String getUserPurchaseHistory(@SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode,
                                         Model model) {

        // 세션에 userCode가 null이면 로그인 페이지로 리다이렉트
        if (fgUserCode == null) {
            return "redirect:/normal/regular/userLogin";
        }


        // 사용자 코드 (userCode)를 이용해서 서비스 메서드 호출
        List<PurchaseHistoryDTO> purchaseHistoryList = normalPurchaseService.getPurchaseHistory(fgUserCode);
        log.info(purchaseHistoryList.toString() + "컨트롤러 확인 ========== ");

        // 모델에 데이터 추가
        model.addAttribute("purchaseHistoryList", purchaseHistoryList);

//        log.info("😊😊😊:{}",purchaseHistoryList.toString());
        log.info("🍎🍎🍎🍎🍎🍎🍎🍎purchaseHistoryList:{}",purchaseHistoryList);
//        log.info("😍😍😍:{}",fgUserCode);

        // 템플릿 반환
        return "mypage/regular/userPurchaseHistory";
    }

    // 선택된 구매 내역의 상세 정보 가져오기
    @GetMapping("/detail/{orderId}")
    public String getPurchaseDetail(@SessionAttribute(value = "fgUserCode", required = false) Long fgUserCode,
                                    Long fgOrderId, Model model) {
        // 세션에 userCode가 null이면 로그인 페이지로 리다이렉트
        if (fgUserCode == null) {
            return "redirect:/normal/regular/userLogin";
        }

        // 구매 내역 상세 정보 가져오기
        PurchaseDetailDTO purchaseDetail = normalPurchaseService.getPurchaseDetail(fgUserCode, fgOrderId);

        // 모델에 데이터 추가
        model.addAttribute("purchaseDetail", purchaseDetail);

        // 템플릿 반환
        return "mypage/regular/userPurchaseDetail"; // 상세 페이지로 반환
    }
}
