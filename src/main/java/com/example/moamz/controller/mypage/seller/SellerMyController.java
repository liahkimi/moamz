package com.example.moamz.controller.mypage.seller;

import com.example.moamz.controller.admin.user.AdminUserController;
import com.example.moamz.domain.dto.mypage.seller.StoreReviewDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerInfoDTO;
import com.example.moamz.domain.dto.mypage.seller.info.SellerProfileDTO;
import com.example.moamz.domain.dto.mypage.seller.info.StoreInfoDTO;
import com.example.moamz.domain.dto.mypage.seller.info.StoreModifyDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.page.Page;
import com.example.moamz.service.mypage.seller.SellerMyService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/seller/my")
public class SellerMyController {
    private final SellerMyService sellerMyService;
    private final AdminUserController adminUserController;

    //
    // 리뷰 보기 페이지 <GET 요청>
    //
    @GetMapping("/storeReview")
    public String getStoreReview(@SessionAttribute(value="fgUserCode", required=false) Long userCode,
                                 Criteria criteria,
                                 Model model) {
        // 세션에 userCode가 null이면 로그인 페이지로 이동
        if(userCode == null) {
            return "redirect:/seller/seller/sellerLogin";
        }

        // 한 페이지에 게시글 10개씩 보이도록 설정
        criteria.setAmount(10);

        // 판매자 업체id값 가져오기
        Long businessId = sellerMyService.findBusinessId(userCode);

        // 페이징을 포함한 리스트 반환
        List<StoreReviewDTO> storeReviewDTO = sellerMyService.findMyStoreRvAll(businessId, criteria);
        // 전체 리뷰 수
        int total = sellerMyService.findTotal(businessId);
        Page page = new Page(criteria, total);

        // 판매자 프로필 반환
        SellerProfileDTO sellerProfileDTO = sellerMyService.getSellerProfile(businessId, userCode);

        // 모델에 전달
        model.addAttribute("page", page);
        model.addAttribute("storeReviewDTO", storeReviewDTO);
        model.addAttribute("sellerProfileDTO", sellerProfileDTO);

        // 리뷰 확인 페이지로 이동
        return "mypage/seller/sellerReviewCheck";
    }

    //
    // 유저 정보 확인 <GET 요청>
    //
    @GetMapping("/infoAuth/{requestPage}")
    public String getInfoAuth(@SessionAttribute(value="fgUserCode", required = false) Long userCode,
                              @PathVariable(value = "requestPage") String requestPage,
                              Model model) {
        // 세션에 userCode가 null이면 로그인 페이지로 이동
        if(userCode == null) {
            return "redirect:/seller/seller/sellerLogin";
        }

        // 판매자 회원 id 찾아서 전송하기
        String sellerId = sellerMyService.findSellerId(userCode);
        model.addAttribute("sellerId", sellerId);

        // 개인정보 수정 요청인지, 업체정보 수정 요청인지를 모델에 담아서 전송한다.
        model.addAttribute("requestPage", requestPage);

        return "/mypage/seller/sellerInfoAuth";
    }

    //
    // 유저 정보 확인 <POST 요청>
    //
    @PostMapping("/infoAuth")
    public String getInfoAuth(@SessionAttribute(value = "fgUserCode", required = false) Long userCode,
                              @RequestParam(value = "requestPage") String requestPage,
                              @RequestParam(name = "input-password") String inputPassword,
                              RedirectAttributes redirectAttributes) {

        // 로그인한 계정의 비밀번호
        String userPw = sellerMyService.findSellerPw(userCode);

        // 사용자가 입력한 비밀번호와 일치하는지 확인
        if(!userPw.equals(inputPassword)) {
            // 비밀번호가 일치하지 않으면 alertMessage를 담아서 다시 infoAuth로 리다이렉트
            redirectAttributes.addFlashAttribute("Message", "비밀번호가 일치하지 않습니다.");
            return "redirect:/seller/my/infoAuth/" + requestPage;
        } else {
            // 일치하면 requestPage에 따라 알맞은 정보 수정 페이지로 리다이렉트
            if ("store".equals(requestPage)) {
                return "redirect:/seller/my/storeModify";
            } else if ("info".equals(requestPage)) {
                return "redirect:/seller/my/infoModify";
            }
        }

        // 기본 반환값
        redirectAttributes.addFlashAttribute("Message", "잘못된 요청입니다.");
        return "redirect:/seller/my/infoAuth";
    }

    //
    // 업체 정보수정 페이지 <GET 요청>
    //
    @GetMapping("/storeModify")
    public String getStoreModify(@SessionAttribute(value="fgUserCode", required = false) Long userCode,
                                 StoreInfoDTO storeInfoDTO,
                                 Model model) {

        // 세션에 userCode가 null이면 로그인 페이지로 이동
        if(userCode == null) {
            return "redirect:/seller/seller/sellerLogin";
        }

        // 업체 정보 가져오기
        storeInfoDTO = sellerMyService.findStoreInfo(userCode);

        // 모델에 담아서 전송하기
        model.addAttribute("storeInfoDTO", storeInfoDTO);

        return "/mypage/seller/sellerStoreModify";
    }

    //
    // 업체 정보수정 <POST 요청>
    //
    @PostMapping("/storeModify")
    public String storeModify(@SessionAttribute(value="fgUserCode", required = false) Long userCode,
                              StoreModifyDTO storeModifyDTO,
                              @RequestParam("userFile") MultipartFile file,
                              @RequestParam("fileChanged") boolean fileChanged,
                              RedirectAttributes redirectAttributes,
                              Model model) throws IOException {

        // 업체 정보 변경하기 메서드 호출
        sellerMyService.updateStoreInfo(userCode, storeModifyDTO, file, fileChanged);

        // 수정한 결과와 alertMessage를 담아서 다시 정보 수정 페이지로 리다이렉트
        StoreInfoDTO storeInfoDTO = sellerMyService.findStoreInfo(userCode);

        redirectAttributes.addFlashAttribute("Message", "수정되었습니다.");
        model.addAttribute("storeInfoDTO", storeInfoDTO);

        return "redirect:/seller/my/storeModify";
    }



    //
    // 개인정보 수정 페이지 <GET 요청>
    //
    @GetMapping("/infoModify")
    public String getInfoModify(@SessionAttribute(value="fgUserCode", required = false)Long userCode,
                                SellerInfoDTO sellerInfoDTO,
                                Model model) {

        // 세션에 userCode가 null이면 로그인 페이지로 이동
        if(userCode == null) {
            return "redirect:/seller/seller/sellerLogin";
        }

        // 개인정보 가져오기
        sellerInfoDTO = sellerMyService.findSellerInfo(userCode);

        // 모델에 담아서 보내기
        model.addAttribute("sellerInfoDTO", sellerInfoDTO);

        return "/mypage/seller/sellerInfoModify";
    }

    //
    // 비밀번호 변경 <POST 요청>
    //
    @PostMapping("/updatePw")
    @ResponseBody
    public boolean updatePw(@SessionAttribute(value = "fgUserCode", required = false) Long userCode,
                         @RequestParam("inputPw") String inputPw,
                         HttpSession httpSession) {

        // 이전 비밀번호 가져오기
        String oldPw = sellerMyService.findSellerPw(userCode);

        // 이전 비밀번호와 새 비밀번호가 다른지 검사
        if(!oldPw.equals(inputPw)) {
            // 이전 비밀번호와 새 비밀번호가 다를 때 비밀번호 변경 메서드 실행
            sellerMyService.updateSellerPassword(inputPw, userCode);

            // 로그아웃
            httpSession.invalidate();

            // true값 리턴
            return true;
        }

        // 이전 비밀번호와 새 비밀번호가 같으면 false값 반환
        return false;
    }

    //
    // 핸드폰번호 변경 <POST 요청>
    //
    @PostMapping("/updatePhone")
    @ResponseBody
    public boolean updatePhone(@SessionAttribute(value = "fgUserCode", required = false) Long userCode,
                            @RequestParam("inputPhone") String inputPhone) {

        // 이전 핸드폰번호 가져오기
        String oldPhone = sellerMyService.findSellerPhone(userCode);

        System.out.println("🧡old" + oldPhone);
        System.out.println("🧡inputPhone" + inputPhone);

        // 이전 핸드폰번호와 새 핸드폰번호가 다른지 검사
        if(!oldPhone.equals(inputPhone)) {
            // 이전 핸드폰번호와 새 핸드폰번호가 다를 때 핸드폰번호 변경 메서드 실행
            sellerMyService.updateSellerPhone(inputPhone, userCode);

            // true값 리턴
            return true;
        }

        // 이전 핸드폰번호와 새 핸드폰번호가 같으면 false값 반환
        return false;
    }



    //
    // 회원 탈퇴 <GET 요청>
    //
    @GetMapping("/withdraw")
    public String getWithdraw(@SessionAttribute(value = "fgUserCode", required = false) Long userCode,
                              Model model) {

        // 세션에 userCode가 null이면 로그인 페이지로 이동
        if(userCode == null) {
            return "redirect:/seller/seller/sellerLogin";
        }

        // userId 반환 메서드
        String sellerId = sellerMyService.findSellerId(userCode);

        // 모델에 담아서 보내기
        model.addAttribute("sellerId", sellerId);
        return "/mypage/seller/sellerWithdraw";
    }

    //
    // 회원 탈퇴 <POST 요청>
    //
    @PostMapping("/withdraw")
    public String getWithdraw(@SessionAttribute(value = "fgUserCode", required = false) Long userCode,
                              @RequestParam("inputPw") String inputPw,
                              RedirectAttributes redirectAttributes,
                              HttpSession httpSession) {

        // 업체id 조회
        Long businessId = sellerMyService.findBusinessId(userCode);

        // 비밀번호가 맞는지 확인
        if(inputPw.equals(sellerMyService.findSellerPw(userCode))) {
            // 비밀번호가 일치한다면 탈퇴 가능한 회원인지 조회
            int ongoingOrder = sellerMyService.findWithdrawAvailable(businessId);

            // 진행중인 주문건이 존재한다면 탈퇴할 수 없다
            if(ongoingOrder > 0) {
                redirectAttributes.addFlashAttribute("Message", "모든 주문이 「픽업완료」 상태일 때 회원 탈퇴가 가능합니다.");
                return "redirect:/seller/my/withdraw";
            }

            //진행중인 주문이 없을 때 회원 탈퇴 메서드 호출
            sellerMyService.removeUser(userCode);

            // 로그아웃
            httpSession.invalidate();

            // 메인페이지로 리다이렉트
            return "redirect:/main";
        } else {
            redirectAttributes.addFlashAttribute("Message", "비밀번호가 일치하지 않습니다.");
            return "redirect:/seller/my/withdraw";
        }
    }
}

