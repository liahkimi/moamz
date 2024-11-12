package com.example.moamz.mapper.community.socialing;

import com.example.moamz.domain.dto.community.socialing.SocialingDetailDTO;
import com.example.moamz.domain.dto.community.socialing.SocialingListDTO;
import com.example.moamz.domain.dto.community.socialing.SocialingWriteDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SocialingMapper {
//    소셜링 리스트
    List<SocialingListDTO> socialingList();

//    소셜링 디테일
    SocialingDetailDTO socialingDetail(Long fgPostId);

//    소셜링 insert
    void insertFgSocialing(SocialingWriteDTO SocialingWriteDTO);
}
