package com.example.moamz.service.community.free;

import com.example.moamz.domain.dto.community.free.FreeLikeDTO;
import com.example.moamz.mapper.community.free.FreeLikeMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FreeLikeService {
    private final FreeLikeMapper freeLikeMapper;

    // 특정 게시물의 좋아요 수 반환 메서드
    public int findLikeCount(Long postId) {
        return freeLikeMapper.selectLikeCount(postId);
    }

    // 좋아요 여부 반환 메서드
    public String isLiked(@Param("userCode") Long userCode, @Param("postId") Long postId) {
        return freeLikeMapper.selectLikeStatus(userCode, postId);
    }

    // 좋아요 추가 메서드
    public void likePost(@Param("userCode") Long userCode, @Param("postId") Long postId) {
        // DTO 생성
        FreeLikeDTO freeLikeDTO = new FreeLikeDTO();
        freeLikeDTO.setUserCode(userCode);
        freeLikeDTO.setPostId(postId);
        System.out.println("🧡🧡🧡좋아여 : " + freeLikeDTO);
        // 좋아요 추가
        freeLikeMapper.insertLike(freeLikeDTO);

        // 게시물 좋아요 수 증가
        freeLikeMapper.increaseLike(postId);
    }

    // 좋아요 삭제 메서드
    public void unlikePost(@Param("userCode") Long userCode, @Param("postId") Long postId) {
        // 좋아요 삭제
        freeLikeMapper.deleteLike(userCode, postId);
        // 게시물 좋아요 수 감소
        freeLikeMapper.decreaseLike(postId);
    }



}
