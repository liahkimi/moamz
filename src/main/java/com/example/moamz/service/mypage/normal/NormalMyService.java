package com.example.moamz.service.mypage.normal;

import com.example.moamz.domain.dto.mypage.normal.info.NormalResetPasswordDTO;
import com.example.moamz.mapper.mypage.normal.info.NormalInfoAuthMapper;
import com.example.moamz.mapper.mypage.normal.info.NormalResetPasswordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NormalMyService {
    private final NormalInfoAuthMapper normalInfoAuthMapper;
    private final NormalResetPasswordMapper normalResetPasswordMapper;

    // 회원 정보 변경 전 인증페이지

    // 유저 아이디 반환 메서드
    public String findNormalId(Long fgUserCode) {
        return normalInfoAuthMapper.selectNormalId(fgUserCode);
    }

    // 회원 비밀번호 조회 메서드
    public String findNormalPw(Long fgUserCode) {
        return normalInfoAuthMapper.selectNormalPw(fgUserCode)
                .orElseThrow(() -> new IllegalStateException("❌❌❌존재하지 않는 회원정보"));
    }



    // 비밀번호 변경 페이지
    public void changeNormalPassword(NormalResetPasswordDTO normalResetPasswordDTO){
       normalResetPasswordMapper.updateNormalPassword(normalResetPasswordDTO);
    }

}
