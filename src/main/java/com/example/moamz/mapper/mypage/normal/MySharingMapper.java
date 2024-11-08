package com.example.moamz.mapper.mypage.normal;

import com.example.moamz.domain.dto.mypage.normal.MySharingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MySharingMapper {
    // '나눔 가능 상태 조회'
    List<MySharingDTO> selectSharingPossible();

    // '예약 중 상태 조회'
    List<MySharingDTO> selectSharingReservation();

    // '나눔 완료 조회'
    List<MySharingDTO> selectSharingCompleted();
}
