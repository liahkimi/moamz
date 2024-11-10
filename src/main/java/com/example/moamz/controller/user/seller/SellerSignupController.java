package com.example.moamz.controller.user.seller;

import com.example.moamz.domain.dto.user.seller.SellerBusinessDTO;
import com.example.moamz.domain.dto.user.seller.SellerCommonSignupDTO;
import com.example.moamz.domain.dto.user.seller.SellerUserSignupDTO;
import com.example.moamz.service.user.seller.SellerSignupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/seller")
public class SellerSignupController {
    private final SellerSignupService sellerSignupService;

    @GetMapping("seller/sellerSignup")
    public String Join(){return "/user/seller/sellerSignup";}

    @PostMapping("seller/sellerSignup")
    public String join(@ModelAttribute SellerCommonSignupDTO sellerCommonSignupDTO,
                       @ModelAttribute SellerUserSignupDTO sellerUserSignupDTO,
                       @ModelAttribute SellerBusinessDTO sellerBusinessDTO,
                       @RequestParam("file") MultipartFile file) throws IOException {
        //@ModelAttribute : 요청전에 모델에 특정 속성을 추가할 수 있음
        //요청 매개변수를 모델 객체로 바인딩, 컨트롤러 메소드가 실행되기 전 모델에 데이터를 추가할 때(모델 추가)
        //요청전에 모델 객체 초기화
        sellerSignupService.userSignup(sellerCommonSignupDTO,
                sellerUserSignupDTO,
                sellerBusinessDTO,
                file);

        return "redirect:/seller/seller/sellerLogin";
    }

}
