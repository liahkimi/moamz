package com.example.moamz.domain.dto.mypage.seller.inquiry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class InquiryDetailDTO {
    //
    // 관리자 문의 상세 DTO
    // 문의 게시글에 대한 내용만 있음(댓글X)
    //

    private Long postId;                // 게시글ID
    private String postTitle;           // 문의글 제목
    private String businessName;        // 업체명(내 업체명)
    private String postCreateAt;        // 문의글 작성일
    private String inquiryContent;      // 문의글 내용
    private Long userCode;              // 회원Code

-- 문의글 댓글 보여주기
-- COMMON_USER : 댓글 작성자 이름(관리자)
-- COMMENT : 작성자 코드(관리자), 작성날짜, 수정여부, 댓글내용
SELECT cu.FG_USER_TYPE, c.FG_COMMENT_DATE, c.FG_COMMENT_CONTENT,
		CASE c.FG_COMMENT_EDIT
			WHEN '0' THEN ' '
			WHEN '1' THEN '수정됨'
		END AS 수정여부
FROM FG_POST p, FG_COMMENT c, FG_COMMON_USER cu
WHERE p.FG_POST_ID = c.FG_POST_ID
AND c.FG_USER_CODE = cu.FG_USER_CODE
AND p.FG_POST_ID = 31;
     */

}
