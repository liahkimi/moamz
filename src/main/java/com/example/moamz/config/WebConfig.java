package com.example.moamz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("C:/upload_moamz/")
    private String fileDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResourceHandlers() 리소스 경로와 연결될 URL 경로를 설정한다.
        registry.addResourceHandler("/upload_moamz/**")
                // 실제 리소스가 존재하는 외부 경로를 알려준다.
                .addResourceLocations("file:" + fileDir);
        // 로컬 디스크 경로는 file:을 반드시 사용해야 한다.
    }
}
