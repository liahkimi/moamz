package com.example.moamz.mapper.mypage.normal;

import com.example.moamz.domain.dto.mypage.normal.ShareStatusUpdateDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShareStatusUpdateMapper {
    // 나눔 상태 '예약 중'으로 변경 버튼
    void updateShareReservation(ShareStatusUpdateDTO shareStatusUpdateDTO);

    // 나눔 상태 '나눔 완료'로 변경 버튼
    void updateShareCompleted(ShareStatusUpdateDTO shareStatusUpdateDTO);
}
