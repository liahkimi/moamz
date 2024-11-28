package com.example.moamz.domain.vo.user.normal;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class UserVO {
    private String fgUserName;
    private String profilePic;
    private String provider;
    private String providerId;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
