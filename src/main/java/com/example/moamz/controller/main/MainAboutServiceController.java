package com.example.moamz.controller.main;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/aboutService")
@RequiredArgsConstructor
public class MainAboutServiceController {

    @GetMapping("")
    public String aboutServicePage(){
        return "main/main/aboutService";
    }
}
