//package com.example.moamz.service.main.HeaderNoticeService;
//
//import java.util.List;
//
//import com.example.moamz.mapper.file.ProductFileMapper;
//import com.example.moamz.mapper.main.fragment.header.HeaderNoticeMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service
//public class HeaderNoticeService {
//
//    private final HeaderNoticeMapper headerNoticeMapper;
//    private final ProductFileMapper productFileMapper;
//
//    public List<HeaderNoticeResponse> getHeaderNotice(HeaderNoticeRequest headerNoticeRequest) {
//        String userCode = headerNoticeRequest.userCode();
//
//        List<HeaderNotice> headerNotices = headerNoticeRepository.findAllByUserCode(userCode);
//
//        return headerNotices.stream()
//                .map(headerNotice -> new HeaderNoticeResponse(
//                        headerNotice.getProductName(),
//                        headerNotice.getFileId(),
//                        headerNotice.getFileName(),
//                        headerNotice.getFileRoot(),
//                        headerNotice.getFileUuid()
//                ))
//                .toList();
//    }
//}
