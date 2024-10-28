const inquiryBtn = document.getElementById('inquiry-btn');

inquiryBtn.addEventListener('click', () => {
    const isConfirm = confirm('관리자 문의 글을 작성하시겠습니까?');
    if(isConfirm) {
        location.href='sellerAdminInquiryWrite.html';
    } else {
        
    }
});
