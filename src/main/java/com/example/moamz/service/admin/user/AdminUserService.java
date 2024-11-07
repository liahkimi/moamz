package com.example.moamz.service.admin.user;

import com.example.moamz.domain.dto.admin.user.AdminUserSessionDTO;
import com.example.moamz.mapper.admin.user.AdminUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional //롤백할 수 있도록
@RequiredArgsConstructor
@Slf4j
public class AdminUserService {
    // final은 서브클래스에서 해당 메서드를 오버라이딩 할 수 없게 한다.
    // 메서드가 변경되지 않도록 보장하고자 할 때 사용한다.
    private final AdminUserMapper adminUserMapper; //의존성 주입 시, 한번만 초기화 가능

    //로그인 메서드 (회원번호 찾기)
    public Long findUserCode(String fgUserId, String fgUserPassword){
        return adminUserMapper.selectUserCode(fgUserId, fgUserPassword) //userMapper의 메소드 호출
                .orElseThrow(()-> new IllegalStateException("존재하지 않는 회원 정보"));
    }

    //로그인한 유저 세션 조회 메서드
    public AdminUserSessionDTO findLoginInfo(String fgUserId, String fgUserPassword){
        log.info("로그인 시도 : {}", fgUserId);
        log.info("입력된 비밀번호 : {}", fgUserPassword); // 비밀번호는 로그에 찍지 않는 것이 좋음

        return adminUserMapper.selectLoginInfo(fgUserId, fgUserPassword)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원 정보"));

    }


}
