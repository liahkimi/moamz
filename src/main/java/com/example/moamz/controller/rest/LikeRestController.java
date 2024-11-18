package com.example.moamz.controller.rest;

import com.example.moamz.service.community.free.FreeLikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/like")
@RequiredArgsConstructor
@Slf4j
public class LikeRestController {
    private final FreeLikeService  freeLikeService;

    //
    // 좋아요 여부 반환 <GET 요청>
    // 화면이 로딩됐을 때 회원이 좋아요를 누른 게시글인지를 알기 위함
    //
    @GetMapping("/isLiked/{postId}")
    public String isLiked(@SessionAttribute(value = "fgUserCode", required = false) Long userCode,
                        @PathVariable(value = "postId") Long postId) {
        // 좋아요 여부 반환 메서드
        String isLiked = freeLikeService.isLiked(userCode, postId);
        return isLiked;
    }

    //
    // 좋아요 추가/취소 <POST 요청>
    //
    @PostMapping("/{postId}")
    public ResponseEntity<Map<String, Object>> postLike(@SessionAttribute(value="fgUserCode", required = false) Long userCode,
                                                       @PathVariable("postId") Long postId) {
        // 좋아요 여부 검사
        String isLiked = freeLikeService.isLiked(userCode, postId);

        if(isLiked.equals("TRUE")) {
            // 좋아요를 누른 게시글이면 좋아요 취소 메서드 호출
            freeLikeService.unlikePost(userCode, postId);
        } else {
            // 좋아요를 누르지 않은 게시글이면 좋아요 추가 메서드 호출
            freeLikeService.likePost(userCode, postId);
        }

        // 게시물의 좋아요 수를 가져온다.
        int likeCount = freeLikeService.findLikeCount(postId);

        // likeCount 변수를 JSON 형식으로 변환하여 리턴한다.
        Map<String, Object> response = new HashMap<>();
        response.put("likeCount", likeCount);

        return ResponseEntity.ok(response);
    }
}
