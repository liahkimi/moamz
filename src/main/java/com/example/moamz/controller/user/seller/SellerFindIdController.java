package com.example.moamz.controller.user.seller;

import com.example.moamz.service.user.seller.SellerFindIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/seller")
public class SellerFindIdController {
    private final SellerFindIdService sellerFindIdService;

    @GetMapping("/findId")
    public String findId(){return "/user/seller/sellerFindId";}

    @GetMapping("/seller/findId")
    @ResponseBody
    public String sellerFindId(@RequestParam("name")String fgSellerName,@RequestParam("phone") String fgSellerPhone){
        String userId = sellerFindIdService.selectFindId(fgSellerName,fgSellerPhone);
        log.info("😀😀😀😀😀😀fgUserName:{}, fgSellerPhone:{}", fgSellerName, fgSellerPhone);
        if(userId != null){
            return userId + "입니다";
        }else {
            return "아이디를 찾을 수 없습니다.";
        }
    }

}
