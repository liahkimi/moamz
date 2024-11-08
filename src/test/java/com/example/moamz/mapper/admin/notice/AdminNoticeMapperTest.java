//package com.example.moamz.mapper.admin.notice;
//
//import com.example.moamz.domain.dto.admin.notice.AdminNoticeDetailDTO;
//import com.example.moamz.domain.dto.admin.notice.AdminNoticeWriteDTO;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@Transactional
//class AdminNoticeMapperTest {
//
//    @Autowired
//    AdminNoticeMapper adminNoticeMapper;
//
//    AdminNoticeWriteDTO adminNoticeWriteDTO;
//
//    @BeforeEach
//    void setUp() {
//        // 공지사항 글 작성에 필요한 데이터 설정
//        adminNoticeWriteDTO = new AdminNoticeWriteDTO();
//        adminNoticeWriteDTO.setFgPostTitle("공지사항 제목 테스트");
//        adminNoticeWriteDTO.setFgNoticeContent("공지사항 내용 테스트");
//    }
//
//    @Test
//    @DisplayName("공지사항 글 작성 테스트")
//    void insertNoticePost() {
//        // given: 공지사항 글 작성 준비
//        adminNoticeMapper.insertNoticePost(adminNoticeWriteDTO);
//        adminNoticeMapper.insertNotice(adminNoticeWriteDTO);  // 공지사항 테이블에도 데이터 삽입
//
//        // when: 작성된 공지사항 글 조회
//        Optional<AdminNoticeDetailDTO> result = adminNoticeMapper.selectNoticeById(adminNoticeWriteDTO.getFgPostId());
//
//        // then: 검증 단계
//        assertThat(result)
//                .isPresent()
//                .get()
//                .extracting("fgPostTitle", "fgNoticeContent")
//                .containsExactly(adminNoticeWriteDTO.getFgPostTitle(), adminNoticeWriteDTO.getFgNoticeContent());
//    }
//}
