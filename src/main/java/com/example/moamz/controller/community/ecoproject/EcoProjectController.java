package com.example.moamz.controller.community.ecoproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ecoproject")
public class EcoProjectController {

    @RequestMapping("/projectList")
    public String projectList(){
        return "community/ecoproject/ecoList";
    }

    @RequestMapping("/ecoCertDetail")
    public String ecoCertDetail(){
        return "community/ecoproject/ecoCertificationDetatil";
    }

    @RequestMapping("/ecoCertWrite")
    public String ecoCertWrite(){
        return "community/ecoproject/ecoCertificationWrite";
    }

    @RequestMapping("/ecoCertList")
    public String ecoCertList(){
        return "community/ecoproject/ecoCertificationBoard";
    }
}
