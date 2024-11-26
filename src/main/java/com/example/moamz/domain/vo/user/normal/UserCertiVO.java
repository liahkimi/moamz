package com.example.moamz.domain.vo.user.normal;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserCertiVO {
    private String fgUserId;
    private String fgNormalPhone;
    private String fgCertiNumber;
}
