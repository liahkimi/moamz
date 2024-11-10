package com.example.moamz.service.community.ecoproject;

import com.example.moamz.domain.dto.community.ecoproject.EcoCertDetailDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoCertListDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoCertWriteDTO;
import com.example.moamz.domain.dto.community.ecoproject.EcoProjectListDTO;
import com.example.moamz.mapper.community.ecoproject.EcoProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class EcoProjectService {
    private final EcoProjectMapper ecoProjectMapper;

    // 프로젝트 리스트
    public List<EcoProjectListDTO> showProjectList() {
        return ecoProjectMapper.ecoProjectList();
    }

    // 완료 프로젝트 리스트
    public List<EcoProjectListDTO> showEndProjectList() {
        return ecoProjectMapper.ecoProjectEndList();
    }

    // 인증글 리스트
    public List<EcoCertListDTO> showCertList(Long fgProjectId) {
        return ecoProjectMapper.ecoCertList(fgProjectId);
    }

    // 인증글 디테일
    public EcoCertDetailDTO showCertDetail(Long fgPostId){
        return ecoProjectMapper.ecoCertDetail(fgPostId);
    }

    // 인증글에 insert
    public void writeCert(EcoCertWriteDTO ecoCertWriteDTO){
        ecoProjectMapper.ecoCertInsert(ecoCertWriteDTO);
    }

//    인증글 삭제
    public void deleteCert(Long fgPostId){
        ecoProjectMapper.ecoCertDelete(fgPostId);
    }
}













