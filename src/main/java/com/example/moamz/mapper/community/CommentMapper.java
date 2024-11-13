package com.example.moamz.mapper.community;

import com.example.moamz.domain.dto.admin.page.Criteria;
import com.example.moamz.domain.dto.community.CommentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    // 댓글 목록, 작성, 수정, 삭제
    List<CommentDTO> selectComment(Long postId);
    void insertComment(CommentDTO commentDTO);
    void modifyComment(CommentDTO commentDTO);
    void deleteComment(Long commentId);

    // 페이징 포함된 댓글 목록 가져오기
    List<CommentDTO> selectSlice(@Param("criteria")Criteria criteria, @Param("postId") Long postId);

}
