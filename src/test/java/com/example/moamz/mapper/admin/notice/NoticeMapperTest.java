//package com.example.moamz.mapper.admin.notice;
//
//import com.example.moamz.domain.dto.admin.notice.NoticeWriteDTO;
//import com.example.moamz.domain.dto.admin.user.UserDTO;
//import com.example.moamz.mapper.admin.user.UserMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//@Sql(statements = {
//        "INSERT INTO FG_COMMON_USER (FG_USER_CODE, FG_USER_ID, FG_USER_PASSWORD, FG_USER_TYPE) VALUES (0, 'admin', '1234', '관리자')"
//})
//class NoticeMapperTest {
//    @Autowired
//    NoticeMapper noticeMapper;
//
//    @Autowired
//    UserMapper userMapper;
//
//    NoticeWriteDTO noticeWriteDTO;
//    UserDTO userDTO;
//
//    @BeforeEach
//    void setUp(){
//        //사용자 데이터를 설정
//        userDTO = new UserDTO();
//        userDTO.setFgUserId("관리자");
//        userDTO.setFgUserPassword("1234");
//        //관리자페이지 회원가입기능 없어서 @Sql로 삽입함.
//
//        //공지사항 게시글 데이터 설정
//        NoticeWriteDTO noticeWriteDTO = new NoticeWriteDTO();
//        noticeWriteDTO.setFgPostTitle("공지사항 제목 test");
//        noticeWriteDTO.
//
//    }
//
//
//}