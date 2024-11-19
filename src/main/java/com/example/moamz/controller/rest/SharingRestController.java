package com.example.moamz.controller.rest;

import com.example.moamz.domain.dto.community.sharing.SharingListDTO;
import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.page.Page;
import com.example.moamz.service.community.sharing.SharingBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sharing")
@RequiredArgsConstructor
public class SharingRestController {
    private final SharingBoardService sharingBoardService;

    //
    // 나눔게시판 목록 반환 <GET 요청>
    // 페이지네이션 O
    //
    @GetMapping("/list/{status}")
    public ResponseEntity<Map<String, Object>> getList(@PathVariable("status") String status,
                                                       Criteria criteria) {

        // 한 페이지에 9개의 게시글을 보여주도록 criteria 객체 설정
        criteria.setAmount(9);

        // 결과를 반환할 객체 정의
        Map<String, Object> response = new HashMap<>();

        // 상태별 데이터 정의
        List<SharingListDTO> sharingList = null;
        int total = 0;

        // 게시글의 상태에 따라 알맞은 글 목록과 총 게시글 수를 변수에 담기
        switch (status) {
            case "available":
                sharingList = sharingBoardService.findAvailableListAll(criteria);
                total = sharingBoardService.findAvailableTotal();
                break;
            case "reserved":
                sharingList = sharingBoardService.findReservedListAll(criteria);
                total = sharingBoardService.findReservedTotal();
                break;
            case "completed":
                sharingList = sharingBoardService.findCompletedListAll(criteria);
                total = sharingBoardService.findCompletedTotal();
                break;
        }

        //  페이지 설정
        Page page = new Page(criteria, total);

        // 응답 객체에 게시글 목록, 총 게시글 수 담기
        response.put("sharingList", sharingList);
        response.put("page", page);

        // 응답 객체 반환
        return ResponseEntity.ok(response);
    }

}
