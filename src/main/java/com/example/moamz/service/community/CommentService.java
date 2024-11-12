package com.example.moamz.service.community;

import com.example.moamz.domain.dto.community.CommentDTO;
import com.example.moamz.mapper.community.CommentMapper;
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
    public List<CommentDTO> findCommentList(Long postId) {
        return commentMapper.selectComment(postId);
    }

    // 댓글 등록 메서드
    public void registComment(CommentDTO commentDTO) {
        commentMapper.insertComment(commentDTO);
    }

    // 댓글 수정 메서드
    public void updateComment(CommentDTO commentDTO) {
        commentMapper.modifyComment(commentDTO);
    }

    // 댓글 삭제 메서드
    public void removeComment(Long postId) {
        commentMapper.deleteComment(postId);
    }
}
