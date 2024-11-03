//package com.example.moamz.mapper.mypage.seller;
//
//import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryCommentDTO;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//class SellerInquiryMapperTest {
//    @Autowired
//    private SellerInquiryMapper sellerInquiryMapper;
//
//    @Test
//    public void testSelectInquiryComment() {
//        // given: 테스트할 게시글 ID 설정 (테스트 데이터에 맞게 변경)
//        Long postId = 5L;
//
//        // when: selectInquiryComment 메서드 실행
//        List<InquiryCommentDTO> comments = sellerInquiryMapper.selectInquiryComment(postId);
//
//        // then: 댓글이 제대로 조회되었는지 검증
//        assertThat(comments).isNotNull();
//        assertThat(comments).isNotEmpty();
//        comments.forEach(comment -> {
//            assertThat(comment.getPostId()).isEqualTo(postId);
//            assertThat(comment.getCommentContent()).isNotNull();
//            assertThat(comment.getCommentDate()).isNotNull();
//        });
//    }
//}