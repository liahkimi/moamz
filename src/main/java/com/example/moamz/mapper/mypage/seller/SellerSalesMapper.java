package com.example.moamz.mapper.mypage.seller;

import com.example.moamz.domain.dto.mypage.seller.SalesDetailDTO;
import com.example.moamz.domain.dto.mypage.seller.SalesListDTO;
import com.example.moamz.domain.dto.page.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SellerSalesMapper {
    // 판매 목록 (주문 확인중)
    List<SalesListDTO> selectCheckOrder(Long businessId);

    // 판매 목록 (픽업 대기중)
    List<SalesListDTO> selectReadyToPickup(Long businessId);

    // 판매 목록 (픽업완료)
    List<SalesListDTO> selectCompletePickup(Long businessId);


    //////////  페이지네이션이 포함된 판매 목록

    // 판매 목록 (주문 확인중)
    List<SalesListDTO> selectCheckOrderAll(@Param("criteria") Criteria criteria, @Param("businessId") Long businessId);

    // 판매 목록 (픽업 대기중)
    List<SalesListDTO> selectReadyToPickupAll(@Param("criteria") Criteria criteria, @Param("businessId") Long businessId);

    // 판매 목록 (픽업완료)
    List<SalesListDTO> selectCompletePickupAll(@Param("criteria") Criteria criteria, @Param("businessId") Long businessId);


    ////////// 픽업 상태별 주문 건수

    // 상품 준비중인 주문 수
    int selectCheckOrderTotal(Long businessId);

    // 픽업 대기중인 주문 수
    int selectReadyToPickupTotal(Long businessId);

    // 픽업 완료된 주문 수
    int selectCompletePickupTotal(Long businessId);


    // 픽업 상태 변경 (주문확인중 -> 픽업대기)
    void modifyStatusReadyToPickup(Long orderId);

    // 픽업 상태 변경 (픽업대기 -> 픽업완료)
    void modifyStatusCompletePickup(Long orderId);

    // 판매 상세
    Optional<SalesDetailDTO> selectSalesDetail(Long orderId);

}
