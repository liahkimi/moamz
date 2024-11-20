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

//    @Autowired
//    private UserResetPasswordMapper userResetPasswordMapper;
//
//    // 비밀번호 조회 및 변경
//    @Transactional
//    public boolean resetPassword(String fgUserId, String fgNormalPhone, UserResetPasswordDTO userResetPasswordDTO) {
//        // 사용자 정보 조회
//        Optional<String> existingPassword = userResetPasswordMapper.selectPassword(fgUserId, fgNormalPhone);
//
//        // 비밀번호 정보가 없으면 리턴 false (잘못된 정보)
//        if (!existingPassword.isPresent()) {
//            return false;
//        }
//
//        // 비밀번호 변경
//        int updateCount = userResetPasswordMapper.updatePassword(userResetPasswordDTO);
//
//        // 업데이트된 행 수가 1보다 크면 성공, 아니면 실패
//        return updateCount > 0;
//    }
}
