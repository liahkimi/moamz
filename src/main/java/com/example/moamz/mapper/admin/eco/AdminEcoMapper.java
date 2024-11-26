package com.example.moamz.mapper.admin.eco;

import com.example.moamz.domain.dto.admin.AdminCommentDTO;
import com.example.moamz.domain.dto.admin.eco.*;
import com.example.moamz.domain.dto.page.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface AdminEcoMapper {

//    진행중인 에코프로젝트 총 갯수 (for pagination)
    int selectEcoTotal();

//    진행중인 모든 에코프로젝트 목록 보기(pagination o)
    List<AdminIngEcoListDTO> selectAllIngEcoList(Criteria criteria);

//    종료된 에코프로젝트 총 갯수 (for pagination)
    int selectFinEcoTotal();

//  종료된 모든 에코프로젝트 목록 보기(pagination o)
    List<AdminFinEcoListDTO> selectAllFinEcoList(Criteria criteria);


//    종료된 에코프로젝트 목록 가져오기 (pagination x)
    List<AdminFinEcoListDTO> selectFinEcoList();

//    특정 한 에코프로젝트만 조회하기
    Optional<AdminIngEcoListDTO> selectEcoProjectById(@Param("fgPostId") Long fgPostId);

//    특정 한 에코프로젝트 삭제하기
    void deleteEcoProject(@Param("fgPostId") Long fgPostId);

//    에코프로젝트 글 작성하기 (공통게시글테이블 insert)
    void insertEcoPost(AdminEcoWriteDTO adminEcoWriteDTO);

//    에코프로젝트 글 작성하기 (에코프젝테이블 insert)
    void insertEcoReal(AdminEcoWriteDTO adminEcoWriteDTO);

//    에코프젝  글 수정하기 (공통게시글테이블 UPDATE / 수정여부 업데이트)
    void modifyEco(AdminEcoModifyDTO adminEcoModifyDTO);

//   에코프젝 글 수정하기 (에코프젝테이블 UPDATE)
    void modifyEcoReal(AdminEcoModifyDTO adminEcoModifyDTO);

//   에코프젝 종료시키기 버튼 클릭시 (처음엔 무조건  FG_ECO_STATUS = '0')
    void finishBtn(@Param("fgPostId") Long fgPostId);

//    (진행중/종료된) 특정 한 에코 프로젝트의 인증글 목록보기 (pagination x)
    List<AdminEcoCertListDTO> selectEcoCertList(@Param("fgProjectId") Long fgProjectId);

//    진행중이거나 완료된 특정 한 에코 프젝의 총 인증글 수 조회하기 (for pagination)
    int selectEcoCertTotal(@Param("fgProjectId") Long fgProjectId);

//    진행중이거나 완료된 특정 한 에코프젝의 모든 인증글 목록 보기 (pagination o)
    List<AdminEcoCertListDTO>  selectAllEcoCertPage(Map<String, Object> map);

//    에코프젝 인증글 상세 보기
     Optional<AdminEcoCertDetailDTO> selectEcoCertDetail(@Param("fgPostId") Long fgPostId, @Param("fgProjectId") Long fgProjectId);

//     에코프젝 인증글 상세페이지 댓글보기
    List<AdminCommentDTO> selectEcoCertDetailComment(@Param("fgPostId") Long fgPostId);

////  에코프젝 인증글 - 포인트 지급하기 (인증글 쓴사람의 회원번호 알아내기)
//    Optional<AdminEcoCertPointBtnDTO> selectEcoPointReceiver(@Param("fgPostId") Long fgPostId);
//
////  에코프젝 인증글 - 포인트 지급하기(해당 유저의 포인트 업데이트하기
//    void updateUserEcoPoint(@Param("fgPostId") Long fgPostId);
//
////  에코프젝 인증글 -포인트 지급 내역 기록하기
//    void  insertEcoPointLog(AdminEcoCertPointBtnDTO adminEcoCertPointBtnDTO);


//  에코프젝 포인트 지급하기 (지급내역 기록 + 해당 유저 포인트 업데이트 하기
    void updateUserEcoPointAndLog(AdminEcoCertPointBtnDTO adminEcoCertPointBtnDTO);





















}
