package com.example.moamz.mapper.community.free;

import com.example.moamz.domain.dto.community.free.FreeLikeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FreeLikeMapper {
    // 좋아요 추가
    void insertLike(FreeLikeDTO freeLikeDTO);
    // 좋아요 수 증가
    void increaseLike(Long postId);
    // 좋아요 삭제
    void deleteLike(@Param("userCode") Long userCode, @Param("postId") Long postId);
    // 좋아요 수 감소
    void decreaseLike(Long postId);
    // 좋아요 여부 반환
    String selectLikeStatus(@Param("userCode") Long userCode, @Param("postId") Long postId);
    // 특정 게시물의 좋아요 수 반환
    int selectLikeCount(Long postId);
}
