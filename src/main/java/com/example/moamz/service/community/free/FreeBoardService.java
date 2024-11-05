package com.example.moamz.service.community.free;

import com.example.moamz.domain.dto.community.free.*;
import com.example.moamz.mapper.community.free.FreeLikeMapper;
import com.example.moamz.mapper.community.free.FreeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class FreeBoardService {
    public final FreeMapper freeMapper;
    public final FreeLikeMapper freeLikeMapper;

    // 자유게시판 글 등록 메서드
    public void registFree(FreeWriteDTO freeWriteDTO) {
        freeMapper.insertPost(freeWriteDTO);
        freeMapper.insertFree(freeWriteDTO);
    }

    // 자유게시판 글 수정 메서드
    public void updateFree(FreeModifyDTO freeModifyDTO) {
        freeMapper.modifyPost(freeModifyDTO);
        freeMapper.modifyFree(freeModifyDTO);
    }

    // 자유게시판 글 삭제 메서드
    public void removeFree(Long postId) {
        freeMapper.deleteFree(postId);
    }

    // 자유게시판 목록 메서드
    public List<FreeListDTO> findFreeList() {
        return freeMapper.selectFreeList();
    }

    // 자유게시판 상세 메서드
    public FreeDetailDTO findFreeDetail(Long postId) {
        return freeMapper.selectFreeDetail(postId)
                .orElseThrow(() -> new IllegalStateException("❌❌❌유효하지 않은 게시글입니다."));
    }

    // 댓글 가져오기 메서드
    public List<FreeCommentDTO> findFreeComment(Long postId) {
        return freeMapper.selectFreeComment(postId);
    }

    // 댓글 등록 메서드
    public void registFreeComment(FreeCommentDTO freeCommentDTO) {
        freeMapper.insertFreeComment(freeCommentDTO);
    }

    // 댓글 수정 메서드
    public void updateFreeComment(FreeCommentDTO freeCommentDTO) {
        freeMapper.modifyFreeComment(freeCommentDTO);
    }

    // 댓글 삭제 메서드
    public void removeFreeComment(Long postId) {
        freeMapper.deleteFreeComment(postId);
    }
}
