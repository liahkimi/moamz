package com.example.moamz.mapper.community.free;

import com.example.moamz.domain.dto.community.free.FreeCommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    // 댓글 목록, 작성, 수정, 삭제
    List<FreeCommentDTO> selectFreeComment(Long postId);
    void insertFreeComment(FreeCommentDTO freeCommentDTO);
    void modifyFreeComment(FreeCommentDTO freeCommentDTO);
    void deleteFreeComment(Long commentId);
}
