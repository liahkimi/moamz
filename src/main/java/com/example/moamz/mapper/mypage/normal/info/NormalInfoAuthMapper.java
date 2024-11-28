package com.example.moamz.mapper.mypage.normal.info;

import com.example.moamz.domain.dto.mypage.normal.info.NormalInfoAuthDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface NormalInfoAuthMapper {


    // 회원 정보 변경 전 인증페이지

    // 유저 아이디 반환
    String selectNormalId(Long fgUserCode);

    // fgUserCode로 회원 비밀번호 조회
    Optional<String> selectNormalPw(Long fgUserCode);
}
