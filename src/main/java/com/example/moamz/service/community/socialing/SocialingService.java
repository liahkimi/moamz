package com.example.moamz.service.community.socialing;

import com.example.moamz.domain.dto.community.socialing.SocialingDetailDTO;
import com.example.moamz.domain.dto.community.socialing.SocialingListDTO;
import com.example.moamz.domain.dto.community.socialing.SocialingWriteDTO;
import com.example.moamz.mapper.community.socialing.SocialingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SocialingService {
    private final SocialingMapper socialingMapper;

//    소셜링 리스트
    public List<SocialingListDTO> showSocialing(){
        return socialingMapper.socialingList();
    }

//소셜링 디테일
    public SocialingDetailDTO socialingDeatil(Long fgPostId){
        return socialingMapper.socialingDetail(fgPostId);
    }

    // 소셜링 insert
    public void writeSocialing(SocialingWriteDTO socialingWriteDTO){
        socialingMapper.insertFgSocialing(socialingWriteDTO);
    }
}
