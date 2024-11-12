package com.example.moamz.service.mypage.normal;

import com.example.moamz.domain.dto.mypage.normal.MySharingDTO;
import com.example.moamz.mapper.mypage.normal.MySharingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service  // 서비스 클래스임을 나타내는 어노테이션
@Transactional  // 메소드 단위의 트랜잭션 관리
@RequiredArgsConstructor  // final 필드 자동 주입을 위한 생성자 자동 생성
@Slf4j  // 로깅을 위한 Lombok 어노테이션
public class NormalMySharingService {

    private final MySharingMapper mySharingMapper;  // MySharingMapper 의존성 주입

    // '나눔 가능 상태' 조회
    public List<MySharingDTO> getSharingPossible() {
        log.info("Fetching possible sharing posts...");
        return mySharingMapper.selectSharingPossible();  // DB에서 나눔 가능 상태의 데이터를 조회
    }

    // '예약 중 상태' 조회
    public List<MySharingDTO> getSharingReservation() {
        log.info("😍😍Fetching reservation sharing posts...");
        return mySharingMapper.selectSharingReservation();  // DB에서 예약 중 상태의 데이터를 조회
    }

    // '나눔 완료 상태' 조회
    public List<MySharingDTO> getSharingCompleted() {
        log.info("Fetching completed sharing posts...");
        return mySharingMapper.selectSharingCompleted();  // DB에서 나눔 완료 상태의 데이터를 조회
    }
}

