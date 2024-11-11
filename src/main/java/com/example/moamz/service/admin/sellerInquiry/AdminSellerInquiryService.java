package com.example.moamz.service.admin.sellerInquiry;

import com.example.moamz.domain.dto.admin.sellerInquiry.AdminSellerInquiryDetailDTO;
import com.example.moamz.domain.dto.admin.sellerInquiry.AdminSellerInquiryListDTO;
import com.example.moamz.mapper.admin.sellerInquiry.AdminSellerInquiryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AdminSellerInquiryService {
    private final AdminSellerInquiryMapper adminSellerInquiryMapper;

    //판매자 문의 목록 보여주기
    public List<AdminSellerInquiryListDTO> findInquiryList(){
        return adminSellerInquiryMapper.selectInquiryList();
    }

    //판매자회원 특정 문의글 상세보기
    public AdminSellerInquiryDetailDTO findInquiryDetail(Long fgPostId){
        return adminSellerInquiryMapper.selectUserInquiryDetailById(fgPostId).orElseThrow(()-> new IllegalStateException("유효하지 않은 게시물입니다."));
    }
}
