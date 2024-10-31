package com.example.moamz.service.community.ecoproject;

import com.example.moamz.mapper.community.ecoproject.EcoProjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@Slf4j
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class EcoProjectServiceTest {
    @Mock
    private EcoProjectMapper ecoProjectMapper;


    @DisplayName("테스트용")
    @Test
    void test(){
        String testNick = "as";
        doReturn("as").when(ecoProjectMapper).testNick();

        String result = ecoProjectMapper.testNick();

        assertThat(result).isEqualTo("as");
    }
}










