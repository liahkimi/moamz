package com.example.moamz.service.user.normal;

import com.example.moamz.domain.dto.user.normal.NormalFindIdDTO;
import com.example.moamz.mapper.user.normal.NormalFindIdMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class NormalFindIdService {
    private final NormalFindIdMapper normalFindIdMapper;

    public NormalFindIdDTO findIdInfo(String fgNormalName, String fgNormalPhone, String fgUserId) {
        return normalFindIdMapper.selectFindId(fgNormalName, fgNormalPhone, fgUserId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디"));
    }

}
