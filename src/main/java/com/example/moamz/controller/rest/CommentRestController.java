package com.example.moamz.controller.rest;

import com.example.moamz.domain.dto.admin.page.Criteria;
import com.example.moamz.domain.dto.community.CommentDTO;
import com.example.moamz.domain.dto.page.Slice;
import com.example.moamz.service.community.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/comment")
public class CommentRestController {

    private final CommentService commentService;

    //
    // 댓글 목록 <GET 요청>, 페이지네이션 없음
    //
    @GetMapping("/list/{postId}")
    public List<CommentDTO> selectCommemtList(@PathVariable(value="postId") Long postId) {
        // 댓글 목록 가져오는 메서드 호출
        return commentService.findCommentList(postId);
    }

    //
    // 댓글 목록 <GET 요청>, 페이지네이션 있음
    //
    @GetMapping("/list/{postId}/comm")
    public Slice<CommentDTO> selectCommentSlice(@PathVariable(value="postId") Long postId,
                                                @RequestParam("page") int page) {
        // 요청한 페이지와 페이지당 게시글 수를 설정한다.
        Slice<CommentDTO> slice = commentService.findSlice(new Criteria(page, 5), postId);
        return slice;
    }


    //
    // 댓글 등록 <POST 요청>
    //
    @PostMapping("/insert/{postId}")
    public void insertComm(@SessionAttribute(value = "fgUserCode", required = false) Long userCode,
                           @PathVariable(value = "postId") Long postId,
                           @RequestBody CommentDTO commentDTO) {

        // DTO에 userCode, postId 값 넣기
        commentDTO.setFgUserCode(userCode);
        commentDTO.setFgPostId(postId);

        // 댓글 등록 서비스 호출하기
        commentService.registComment(commentDTO);
    }

    //
    // 댓글 수정 <PATCH 요청>
    //
    @PatchMapping("/update/{commentId}")
    public void updateComment(@RequestBody CommentDTO commentDTO,
                              @PathVariable(value="commentId") Long commentId) {

        // DTO에 commentId 넣기
        commentDTO.setFgCommentId(commentId);

        // 댓글 수정 메서드 호출
        commentService.updateComment(commentDTO);
    }

    //
    // 댓글 삭제 <DELETE 요청>
    //
    @DeleteMapping("/delete/{commentId}")
    public void deleteComment(@PathVariable(value="commentId") Long commentId) {
        // 댓글 삭제 메서드 호출
        commentService.removeComment(commentId);
    }

}
