const postDeleteBtn = document.getElementById('delete-btn');
const postId = document.querySelector('.post-info-wrap')
                        .getAttribute('data-id');

postDeleteBtn.addEventListener('click', () => {
    const isConfirm = confirm('게시글을 삭제하시겠습니까?');
    if(isConfirm) {
        location.href=`/seller/inquiry/removeInquiry/${postId}`;
    }
});