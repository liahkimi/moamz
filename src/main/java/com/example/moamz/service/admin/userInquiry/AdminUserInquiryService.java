package com.example.moamz.service.admin.userInquiry;

import com.example.moamz.domain.dto.admin.userInquiry.AdminUserInquiryDetailDTO;
import com.example.moamz.domain.dto.admin.userInquiry.AdminUserInquiryListDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.mapper.admin.userInquiry.AdminUserInquiryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AdminUserInquiryService {

    private final AdminUserInquiryMapper adminUserInquiryMapper;

    //일반회원  문의목록 보여주기 (페이지네이션 x)
    public List<AdminUserInquiryListDTO> findInquiryList(){
        return adminUserInquiryMapper.selectInquiryList();
    }


    //일반회원 특정 문의글 상세보기
    public AdminUserInquiryDetailDTO findInquiryDetail(Long fgPostId, Long fgUserCode){
        return adminUserInquiryMapper.selectUserInquiryDetailById(fgPostId).orElseThrow(()-> new IllegalStateException("유효하지 않은 게시물 입니다."));
    }


    //일반회원 특정 문의글 상세보기에 있는 댓글 보기




    //일반회원 문의글 답변상태 변경시키기
    public void updateStatusBtn(Long fgPostId){
        adminUserInquiryMapper.changeStatusBtn(fgPostId);
    }

    //일반회원문의 글 총갯수 구하기
    public int findUserInquiryTotal(){
        return adminUserInquiryMapper.selectUserInquiryTotal();
    }

    //모든 일반회원문의 목록 페이지 보기 (페이지네이션 o)
    public List<AdminUserInquiryListDTO> findAllUserInquiryPage(Criteria criteria){
        return adminUserInquiryMapper.selectAllUserInquiryPage(criteria);
    }


}
