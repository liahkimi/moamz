package com.example.moamz.controller.community.free;

import com.example.moamz.service.community.free.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CommentRestController {
    //
    // 댓글 처리 RestController
    //

    private final CommentService commentService;

}
