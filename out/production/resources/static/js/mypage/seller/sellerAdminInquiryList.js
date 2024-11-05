const inquiryBtn = document.getElementById('inquiry-btn');

inquiryBtn.addEventListener('click', () => {
    const isConfirm = confirm('관리자 문의 글을 작성하시겠습니까?');
    if(isConfirm) {
        // get 요청으로 컨트롤러에서 seller/inquiry/regist 요청을 처리하도록 바꿔줘
        window.location.href = "/seller/inquiry/regist";
    }
});
