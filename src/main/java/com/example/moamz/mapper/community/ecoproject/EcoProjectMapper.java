package com.example.moamz.mapper.community.ecoproject;

import com.example.moamz.domain.dto.community.PostDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoCertDetailDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoCertListDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoCertWriteDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoProjectListDTO;
import com.example.moamz.domain.dto.page.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EcoProjectMapper {
    
    // 프로젝트 진행중 리스트
    List<EcoProjectListDTO> ecoProjectList();

//    완료 프로젝트
    List<EcoProjectListDTO> ecoProjectEndList();

    // 인증글 디테일
    EcoCertDetailDTO ecoCertDetail(Long fgPostId);

    // 인증글 리스트
     List<EcoCertListDTO> ecoCertList(Long fgProjectId);

     // 인증글에 insert
    void ecoCertInsert(EcoCertWriteDTO ecoCertWriteDTO);

    // 인증글 삭제
    void ecoCertDelete(Long fgPostId);

    List<EcoProjectListDTO> ecoProjectListPage(Criteria criteria);

    List<EcoProjectListDTO> endecoProjectListPage(Criteria criteria);

    int countEco();

    int countCert();
}
