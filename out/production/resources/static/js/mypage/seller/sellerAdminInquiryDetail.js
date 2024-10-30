const postDeleteBtn = document.getElementById('delete-btn');

postDeleteBtn.addEventListener('click', () => {
    const isConfirm = confirm('게시글을 삭제하시겠습니까?');
    if(isConfirm) {
        location.href='sellerAdminInquiryList.html';
    } else {

    }
});