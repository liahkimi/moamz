package com.example.moamz.mapper.admin.eco;

import com.example.moamz.domain.dto.admin.eco.EcoListDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EcoListMapper {
//    진행중인 에코프로젝트 목록 가져오기
    List<EcoListDTO> selectIngEcoList();

//    종료된 에코프로젝트 목록 가져오기
    List<EcoListDTO> selectFinEcoList();
}
