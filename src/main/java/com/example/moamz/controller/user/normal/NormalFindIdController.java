package com.example.moamz.controller.user.normal;

import com.example.moamz.service.user.normal.NormalFindIdService;
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
@RequestMapping("/normal")
public class NormalFindIdController {
    private final NormalFindIdService normalFindIdService;

    @GetMapping("/findId")
    public String findId() {
        return "/user/regular/userFindId";
    }

    @GetMapping("/user/findId")
    @ResponseBody
    public String findUserId(@RequestParam("name") String fgNormalName, @RequestParam("phone") String fgNormalPhone) {
        log.info("😀😀😀😀😀😀fgNormalName:{},fgNormalPhone:{}", fgNormalName, fgNormalPhone);
        log.info("😀😀😀😀😀😀userId:");
        String userId = normalFindIdService.findIdInfo(fgNormalName, fgNormalPhone);
        if (userId != null) {
            return userId;  // 아이디 찾기 성공
        } else {
            return "아이디를 찾을 수 없습니다.";  // 실패 시 메시지
        }
    }

}
