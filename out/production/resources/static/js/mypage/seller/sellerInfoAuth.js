const inputPw = document.getElementById('input-password');
const cancleBtn = document.getElementById('cancle-btn');
const confirmBtn = document.getElementById('confirm-btn');

// 취소버튼
cancleBtn.addEventListener('click', () => {
    const isConfirm = confirm('취소하시겠습니까?');
    if (isConfirm) {
        window.location.href = '/seller/sales/list';
    } else {
    }
});

// 확인버튼
confirmBtn.addEventListener('click', (e) => {
    e.preventDefault(); // 기본 submit 동작 막기

    if (!inputPw.value.trim()) {
        alert('비밀번호를 입력해주세요.');
        inputPw.focus();
        return;
    }


    // post 요청을 보낼 url 처리
    const form = document.querySelector('form');

    // requestPage값 가져오기
    const requestPage = form.getAttribute('data-requestPage');

    form.action = `/seller/my/infoAuth?requestPage=${requestPage}`;

    // 폼 태그 제출하기
    form.submit();
});
