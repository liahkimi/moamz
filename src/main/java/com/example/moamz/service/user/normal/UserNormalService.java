package com.example.moamz.service.user.normal;

import com.example.moamz.domain.dto.user.normal.UserNomalSessionDTO;
import com.example.moamz.mapper.user.normal.UserNomalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserNomalService {
    private final UserNomalService userNomalService;
    private final UserNomalMapper userNomalMapper;

    // 유저 추가 메소드
//    public void registerUser(UserNomalSessionDTO userNomalSessionDTO) {
//        userNomalService.insertUser(userNomalSessionDTO);
//    }

    // 유저 번호 찾기 메소드
    public Long findId(String loginId, String password) {
        return userNomalMapper.selectId(loginId, password)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 화원 정보"));
    }

    public UserNomalSessionDTO findLoginInfo(String loginId, String password) {
        return userNomalMapper.selectLoginInfo(loginId, password)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 화원 정보"));
    }
}
