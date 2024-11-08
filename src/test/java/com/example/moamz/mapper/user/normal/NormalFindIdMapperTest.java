//package com.example.moamz.mapper.user.normal;
//
//import com.example.moamz.domain.dto.user.normal.NormalFindIdDTO;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//@SpringBootTest
//@Transactional
//@Slf4j
//class NormalFindIdMapperTest {
//    @Autowired
//    NormalFindIdMapper normalFindIdMapper;
//    NormalFindIdDTO normalFindIdDTO;
//
////    @Test
////    void selectFindId(){
////
////        String fgNormalName = "aaa";
////        String fgNormalPhone = "010-0000-0000";
////
////        Long fgUserCode = normalFindIdMapper.selectFindId(fgNormalName, fgNormalPhone)
////                .orElseThrow(() -> new AssertionError("유저 Id를 찾을 수 없습니다"));
//
////        //when
////        Long fgUserCode = userNormalMapper.selectId(fgUserId, fgUserPassword)
////                .orElseThrow(() -> new AssertionError("유저 ID를 찾을 수 없습니다"));
////
////        //then
////        assertThat(fgUserCode).isEqualTo(normalLoginDTO.getFgUserCode());
//    }
//
//}