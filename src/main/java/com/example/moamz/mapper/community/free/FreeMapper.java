package com.example.moamz.mapper.community.free;

import com.example.moamz.domain.dto.community.free.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface FreeMapper {
    //
    // 자유게시판 mapper interface
    //

    // 게시글 작성
    void insertPost(FreeWriteDTO freeWriteDTO);
    void insertFree(FreeWriteDTO freeWriteDTO);

    // 게시글 수정
    void modifyPost(FreeModifyDTO freeModifyDTO);
    void modifyFree(FreeModifyDTO freeModifyDTO);

    // 게시글 삭제
    void deleteFree(Long postId);

    // 게시글 목록
    List<FreeListDTO> selectFreeList();

    // 게시글 상세보기
    Optional<FreeDetailDTO> selectFreeDetail(Long postId);

    // 댓글 목록, 작성, 수정, 삭제
    List<FreeCommentDTO> selectFreeComment(Long postId);
    void insertFreeComment(FreeCommentDTO freeCommentDTO);
    void modifyFreeComment(FreeCommentDTO freeCommentDTO);
    void deleteFreeComment(Long commentId);

}
