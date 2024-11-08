package com.example.moamz.mapper.community.ecoproject;

import com.example.moamz.domain.dto.community.PostDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoCertDetailDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoCertListDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoCertWriteDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoProjectListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EcoProjectMapper {
    
    // 프로젝트 리스트
    List<EcoProjectListDTO> ecoProjectList();

    // 인증글 디테일
    EcoCertDetailDTO ecoCertDetail(Long fgPostId);

    // 인증글 리스트
     List<EcoCertListDTO> ecoCertList(Long fgProjectId);

     // 인증글에 insert
    void ecoCertInsert(EcoCertWriteDTO ecoCertWriteDTO);

    // post에 insert(eco 인증)
    void ecoCertPostInsert(PostDTO postDTO);

    // 인증글 삭제
    void ecoCertDelete(Long fgPostId);
}
