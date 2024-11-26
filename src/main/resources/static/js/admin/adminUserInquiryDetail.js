///// 댓글 관련 모듈 import하기
import * as comment from "../community/comment.js";

let page = 1;
let hasNext = true;
const postId = document.querySelector('.content').getAttribute('data-id');


////////////////////////////////////////////////////////
///// 댓글 작성하기

{
    // 댓글 작성 버튼
    const $commentInputBtn = document.getElementById('comment-input-btn');
    // 댓글 입력 input 태그
    const $commentInput = document.getElementById('comment-input');
    // 더보기 버튼
    let $showMoreBtn = document.getElementById('show-more-btn');
    // let postId = document.querySelector('.post-info-wrap').getAttribute('data-id');


    // 처음 페이지 로드할 때 댓글 목록 가져오기
    comment.getListAll(postId, page, function(data) {
        hasNext = data.hasNext;
        displayComment(data.contentList);
    });


    // 댓글 작성하기 버튼 이벤트
    $commentInputBtn?.addEventListener('click', () => {
        // input 태그에 작성한 값(댓글 내용) 가져오기
        let commentContent = $commentInput.value;

        // 댓글 내용이 비었는지 확인한다.
        if(commentContent.trim() === '') {
            alert('댓글 내용을 입력해주세요.');
            $commentInput.focus();
            return;
        }

        // 댓글 정보를 담는 객체를 생성한다.
        let commInfo = {
            postId : postId,
            commentContent : commentContent
        };

        // 댓글 등록 함수 호출
        comment.insertComm(commInfo, () => {
            // input 태그 초기화
            $commentInput.value = '';

            // 페이지 초기화
            page = 1;

            // 댓글 목록 다시 가져오기
            comment.getListAll(postId, page, function(data) {
                hasNext = data.hasNext;
                displayComment(data.contentList);
            });
        });
    }); // 댓글 등록버튼 이벤트 끝


    // 더보기 버튼을 클릭하면 다음 페이지 댓글을 가져온다.
    $showMoreBtn?.addEventListener('click', () => {
        // 페이지 증가
        page++;

        // 다음페이지 댓글 반환
        comment.getListAll(postId, page, function(data) {
            hasNext = data.hasNext;
            appendComment(data.contentList);
        });
    });


}





////////////////////////////////////////////////////////
///// 댓글 수정, 삭제하기

{
    // 댓글 목록이 보여질 태그
    let $commentContainer = document.querySelector('.comment-content-wrap ul');
    // postId값 가져오기
    // const postId = document.querySelector('.post-info-wrap').getAttribute('data-id');

    // 해당 태그 안에서 클릭 이벤트를 감지함
    $commentContainer.addEventListener('click', (e) => {

        // 클릭한 요소를 저장하는 변수
        let $target = e.target;

        // 1️⃣클릭한 요소가 '수정'버튼일 때 댓글 수정할 수 있는 태그를 생성한다.
        if($target.classList.contains('comment-modify-btn')) {

            // 댓글 내용이 출력되고 있는 태그 찾기
            let $commentBox = $target.closest('.comment-list').querySelector('.comment-content');

            // 원래 작성되어 있던 댓글 내용을 변수에 저장
            let oldComment = $commentBox.innerText;

            // '수정' 버튼이 클릭되면 원래 댓글이 출력되던 p태그 안에
            // 댓글을 수정할 수 있는 textarea 태그와 '수정 완료' 버튼을 추가해준다.
            $commentBox.innerHTML = `
                <div class="comment-modify-box">
                    <textarea class="modify-content">${oldComment}</textarea>
                    <button type="button" class="modify-content-btn">수정완료</button>
                </div>
            `;

            // 2️⃣클릭한 요소가 '수정완료' 버튼일 때, 댓글 내용을 수정한다.
        } else if($target.classList.contains('modify-content-btn')) {

            // commentId값 찾아오기..
            let commentId = $target.closest('.comment-list').dataset.id;

            // 수정된 댓글 내용을 변수에 담는다.
            let newComment = $target.closest('.comment-modify-box')
                .querySelector('.modify-content').value;

            // 수정된 댓글 정보 객체를 생성한다
            let updateInfo = {
                commentId : commentId,
                commentContent : newComment
            };

            // 모듈에서 댓글 수정 함수 호출
            comment.updateComm(updateInfo, () => {
                // 페이지 초기화
                page = 1;

                // 댓글 목록을 다시 로딩한다.
                comment.getListAll(postId, page, function(data) {
                    hasNext = data.hasNext;
                    displayComment(data.contentList);
                });
            })

            // 3️⃣클릭한 요소가 '삭제' 버튼일 때, 댓글을 삭제한다.
        } else if($target.classList.contains('comment-delete-btn')) {
            const isConfirm = confirm('댓글을 삭제하시겠습니까?');

            if(isConfirm) {
                // commentId값 찾아오기..
                let commentId = $target.closest('.comment-list').dataset.id;

                // 모듈에서 댓글 삭제 함수 호출
                comment.removeComm(commentId, () => {
                    page = 1;

                    // 댓글 목록을 다시 로딩한다.
                    comment.getListAll(postId, page, function(data) {
                        hasNext = data.hasNext;
                        displayComment(data.contentList);
                    });
                })
            }

        }
    });




}




////////////////////////////////////////////////////////
///// 댓글 목록 화면에 보여주는 함수

function displayComment(commentList) {
    // 댓글 목록이 보여질 태그
    const commentContainer = document.querySelector('.comment-content-wrap ul');

    // 댓글 목록을 출력할 태그 초기화
    let tags = ``;

    // connentList에 있는 댓글을 하나씩 html 태그로 생성한다.
    commentList.forEach(comment => {

        tags += `
            <li class="comment-list" data-id="${comment.fgCommentId}">
                <div>
                    <div class="comment-info-wrap">
                        <span class="user-nickname">${comment.fgUserId}</span>
                        <span class="comment-write-time">${comment.fgCommentDate}</span>
                        <span class="comment-modified">${comment.fgCommentEdit}</span>
                    </div>
                    <div class="comment-btn-wrap">
                        <button type="button" class="comment-modify-btn">수정</button>
                        <button type="button" class="comment-delete-btn">삭제</button>
                    </div>
                </div>
                <p class="comment-content">${comment.fgCommentContent}</p>
            </li>
        `;
    });

    // 생성된 태그를 ul 태그 안에 출력해준다.
    commentContainer.innerHTML = tags;

    // hasNext가 true일 때만 더보기 버튼이 표시되도록 제어함
    const $showMoreBtn = document.getElementById('show-more-btn');
    $showMoreBtn.style.display = hasNext ? 'block' : 'none';

}


////////////////////////////////////////////////////////
///// 기존 댓글 목록에 새 댓글 추가해주는 함수

function appendComment(commentList) {
    // 댓글 목록이 보여질 태그
    const commentContainer = document.querySelector('.comment-content-wrap ul');

    // 댓글 목록을 출력할 태그 초기화
    let tags = ``;

    // connentList에 있는 댓글을 하나씩 html 태그로 생성한다.
    commentList.forEach(comment => {

        tags += `
            <li class="comment-list" data-id="${comment.fgCommentId}">
                <div>
                    <div class="comment-info-wrap">
                        <span class="user-nickname">${comment.fgUserId}</span>
                        <span class="comment-write-time">${comment.fgCommentDate}</span>
                        <span class="comment-modified">${comment.fgCommentEdit}</span>
                    </div>
                    <div class="comment-btn-wrap">
                        <button type="button" class="comment-modify-btn">수정</button>
                        <button type="button" class="comment-delete-btn">삭제</button>
                    </div>
                </div>
                <p class="comment-content">${comment.fgCommentContent}</p>
            </li>
        `;
    });

    // 생성된 태그를 ul 태그 안에 출력해준다.
    commentContainer.insertAdjacentHTML("beforeend", tags);

    // hasNext가 true일 때만 더보기 버튼이 표시되도록 제어함
    const $showMoreBtn = document.getElementById('show-more-btn');
    $showMoreBtn.style.display = hasNext ? 'block' : 'none';

}
