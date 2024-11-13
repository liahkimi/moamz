package com.example.moamz.service.community;

import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.community.CommentDTO;
import com.example.moamz.domain.dto.page.Slice;
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

    // 댓글 목록 가져오기 메서드 (페이지네이션x)
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

    // 페이지네이션 포함한 댓글 목록 가져오기
    public Slice<CommentDTO> findSlice(Criteria criteria, Long postId) {
        List<CommentDTO> commentList = commentMapper.selectSlice(criteria, postId);

        // 다음 페이지가 있는지 검사한다.
        // 현재 페이지의 게시물 수가 요청한 수보다 많다면, 다음 페이지가 있다.
        boolean hasNext = commentList.size() > criteria.getAmount();

        // 더 가져온 항목을 제거하여 정확한 개수로 반환한다.
        if(hasNext) {
            commentList.remove(criteria.getAmount());
        }

        return new Slice<CommentDTO>(hasNext, commentList);
    }
}
