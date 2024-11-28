package com.example.moamz.service.user.normal;

import com.example.moamz.domain.dto.user.normal.UserResetPasswordDTO;
import com.example.moamz.mapper.user.normal.UserResetPasswordMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserResetPasswordService {
    private final UserResetPasswordMapper userResetPasswordMapper;

    public UserResetPasswordDTO checkedPassword(String fgUserID, String fgNormalPhone){
        return userResetPasswordMapper.selectPassword(fgUserID, fgNormalPhone)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원"));
    }

    public void updatePassword(UserResetPasswordDTO userResetPasswordDTO) {
        userResetPasswordMapper.updatePassword(userResetPasswordDTO);
    }

}
