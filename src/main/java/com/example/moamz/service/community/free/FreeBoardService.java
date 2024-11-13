package com.example.moamz.service.community.free;

import com.example.moamz.domain.dto.page.Criteria;
import com.example.moamz.domain.dto.community.free.*;
import com.example.moamz.mapper.community.PostMapper;
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
    private final PostMapper postMapper;

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
    public boolean removeFree(Long userCode, Long postId) {

        // 게시글 작성자
        Long writerCode = postMapper.selectWriterCode(postId);

        // 삭제를 요청한 userCode와 게시글 작성자 userCode가 일치할 때만 삭제한다.
        if(userCode.equals(writerCode)) {
            freeMapper.deleteFree(postId);
            return true;
        } else {
            return false;
        }
    }

    // 자유게시판 목록 메서드
    public List<FreeListDTO> findFreeList() {
        return freeMapper.selectFreeList();
    }

    // 자유게시판 목록 메서드 (페이지네이션O)
    public List<FreeListDTO> findFreeListAll(Criteria criteria) {
        return freeMapper.selectFreeListAll(criteria);
    }

    // 전체 게시글 수 세는 메서드
    public int findTotal() {
        return freeMapper.selectTotal();
    }

    // 자유게시판 상세보기 메서드
    public FreeDetailDTO findFreeDetail(Long postId, Long userCode) {

        // 작성자 userCode
        Long writerCode = postMapper.selectWriterCode(postId);

        // 작성자 Code랑 세션의 userCode 다를때 조회수 +1
        if(!writerCode.equals(userCode)) {
            postMapper.updateViewCount(postId);
        }

        return freeMapper.selectFreeDetail(postId)
                .orElseThrow(() -> new IllegalStateException("❌❌❌유효하지 않은 게시글입니다."));
    }


}
