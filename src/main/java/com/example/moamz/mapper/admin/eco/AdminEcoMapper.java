package com.example.moamz.mapper.admin.eco;

import com.example.moamz.domain.dto.admin.eco.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminEcoMapper {
//    진행중인 에코프로젝트 목록 가져오기
    List<AdminEcoListDTO> selectIngEcoList();

//    종료된 에코프로젝트 목록 가져오기
    List<AdminEcoListDTO> selectFinEcoList();

//    에코프로젝트 글 작성하기 (공통게시글테이블 insert)
    void insertEcoPost(AdminEcoWriteDTO adminEcoWriteDTO);

//    에코프로젝트 글 작성하기 (에코프젝테이블 insert)
    void insertEcoReal(AdminEcoWriteDTO adminEcoWriteDTO);

//    에코프젝  글 수정하기 (공통게시글테이블 UPDATE / 수정여부 업데이트)
    void modifyEco(AdminEcoModifyDTO adminEcoModifyDTO);

//   에코프젝 글 수정하기 (에코프젝테이블 UPDATE)
    void modifyEcoReal(AdminEcoModifyDTO adminEcoModifyDTO);

//   에코프젝 종료시키기 버튼 클릭시 (처음엔 무조건  FG_ECO_STATUS = '0')
    void finishBtn(AdminEcoStatusUpdateDTO adminEcoStatusUpdateDTO);

//    (진행중/종료된) 특정 한 에코 프로젝트의 인증글 목록보기
    List<AdminEcoCertListDTO> selectEcoCertList(@Param("fgProjectId") Long fgProjectId);

//    에코프젝 인증글 상세 보기
     Optional<AdminEcoCertDetailDTO> selectEcoCertDetail(@Param("fgPostId") Long fgPostId, @Param("fgProjectId") Long fgProjectId);

//  에코프젝 인증글 - 포인트 지급하기 (인증글 쓴사람의 회원번호 알아내기)
    Optional<AdminEcoCertPointBtnDTO> selectEcoPointReceiver(@Param("fgPostId") Long fgPostId);

//  에코프젝 인증글 - 포인트 지급하기(해당 유저의 포인트 업데이트하기
    void updateUserEcoPoint(@Param("fgPostId") Long fgPostId);

//  에코프젝 인증글 -포인트 지급 내역 기록하기
    void  insertEcoPointLog(AdminEcoCertPointBtnDTO adminEcoCertPointBtnDTO);
























}
