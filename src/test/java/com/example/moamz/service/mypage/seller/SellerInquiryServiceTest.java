//package com.example.moamz.service.mypage.seller;
//
//import com.example.moamz.domain.dto.mypage.seller.inquiry.InquiryCommentDTO;
//import com.example.moamz.mapper.mypage.seller.SellerInquiryMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class SellerInquiryServiceTest {
//    @Mock
//    public SellerInquiryMapper sellerInquiryMapper;
//
//    @InjectMocks
//    private SellerInquiryService sellerInquiryService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void findInquiryComment_ShouldReturnCommentList_WhenCommentsExist() {
//        // Given
//        Long postId = 5L;
//        List<InquiryCommentDTO> expectedComments = Arrays.asList(
//                new InquiryCommentDTO("22/10/01 12:30:00", "This is a comment", " "),
//                new InquiryCommentDTO("22/10/02 13:45:00", "Another comment", "수정됨")
//        );
//
//        // When
//        when(sellerInquiryMapper.selectInquiryComment(postId)).thenReturn(expectedComments);
//        List<InquiryCommentDTO> actualComments = sellerInquiryService.findInquiryComment(postId);
//
//        // Then
//        assertEquals(expectedComments, actualComments);
//    }
//
//}