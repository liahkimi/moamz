const modifyBtn = document.getElementById('modify-btn');
const deleteBtn = document.getElementById('delete-btn');
const postId = document.querySelector('.post-container').getAttribute('data-id');

/////////////////////////////////////////////////////////////
///// 나눔글 수정하기

modifyBtn.addEventListener('click', () => {
    const isConfirm = confirm('해당 글을 수정하시겠습니까?');

    if (isConfirm) {
        window.location.href = `/sharing/update?postId=${postId}`;
    }
});


/////////////////////////////////////////////////////////////
///// 나눔글 삭제하기

deleteBtn.addEventListener('click', () => {
    const isConfirm = confirm('해당 글을 삭제하시겠습니까?');

    if (isConfirm) {
        window.location.href = `/sharing/delete?postId=${postId}`;
    }
});