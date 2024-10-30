const deleteBtn = document.getElementById('delete-btn');
const likeBtns = document.querySelectorAll('.like-btn');
const commentInput = document.getElementById('comment-input');
const commentInputBtn = document.getElementById('comment-input-btn');
const commentList = document.querySelector('.comment-content-wrap ul');

// 좋아요 버튼 토글
likeBtns.forEach((btn) => {
    btn.addEventListener('click', function () {
        // 클릭하면 active 적용
        btn.classList.toggle('active');

        // 하트 이미지 변경
        const img = btn.querySelector('img');
        if (btn.classList.contains('active')) {
            img.src = "../../../static/img/community/like_icon_greenheart.png";
        } else {
            img.src = "../../../static/img/community/like_icon_fullheart.png";
        }
    });
});

// 게시글 삭제버튼
deleteBtn.addEventListener('click', () => {
    const isConfirm = confirm('해당 글을 삭제하시겠습니까?');
    if (isConfirm) {
        window.location.href = 'freeList.html';
    } else {
    }
});

// 댓글
// 댓글 처리를 비동기로 해야하는 이유?
// 댓글 작성완료 버튼을 누르면 서버에 데이터를 보냄
// 응답이 올 때 까지 페이지가 멈추지 않고 다른 작업이 가능해야 함
commentInputBtn.addEventListener('click', () => {
    const commentText = commentInput.value;
    // console.log(commentText);

    // 빈 댓글인 경우 alert
    if (commentText.trim() === '') {
        alert('댓글 내용을 입력하세요.');
        return;
    }

    // 비동기 fetch..를 어디로 날림??????
    fetch('', {
        method: 'POST',
        headers: {

        },
        body: JSON.stringify({

        }),
    }).then(response => response.json())    //서버 응답 json으로 변환
    .then(data => {
        if(data.success) {
            // 서버 응답 성공하면 댓글 목록에 새 댓글 추가
            // 새 댓글
            const newComment = `
                <li class="comment-list">
                    <div>
                        <div class="comment-info-wrap">
                            <span class="user-nickname">${data.nickname}</span>
                            <span class="comment-write-time">${data.writeTime}</span>
                            <span class="comment-modified">수정됨</span>
                        </div>
                        <div class="comment-btn-wrap">
                            <button type="button" id="comment-modify-btn">수정</button>
                            <button type="button" id="comment-delete-btn">삭제</button>
                        </div>
                    </div>
                    <p class="comment-content">${data.content}</p>
                </li>
            `;
            // 댓글 목록에 댓글 추가
            commentList.innerHTML(newComment);
            // 댓글 입력창 초기화
            commentInput.value='';
        } else {
            alert('댓글 작성에 실패했습니다.');
        }
    }).catch(error => {
        console.log('=====서버 통신 오류 : ', error);
    });
});