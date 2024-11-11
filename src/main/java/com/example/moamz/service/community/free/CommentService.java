package com.example.moamz.service.community.free;

import com.example.moamz.domain.dto.community.free.FreeCommentDTO;
import com.example.moamz.mapper.community.free.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final CommentMapper commentMapper;

    // 댓글 목록 가져오기 메서드
    public List<FreeCommentDTO> findFreeComment(Long postId) {
        return commentMapper.selectFreeComment(postId);
    }

    // 댓글 등록 메서드
    public void registFreeComment(FreeCommentDTO freeCommentDTO) {
        commentMapper.insertFreeComment(freeCommentDTO);
    }

    // 댓글 수정 메서드
    public void updateFreeComment(FreeCommentDTO freeCommentDTO) {
        commentMapper.modifyFreeComment(freeCommentDTO);
    }

    // 댓글 삭제 메서드
    public void removeFreeComment(Long postId) {
        commentMapper.deleteFreeComment(postId);
    }
}
