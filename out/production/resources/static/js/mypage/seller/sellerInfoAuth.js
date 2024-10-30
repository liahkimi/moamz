const inputPw = document.getElementById('input-password');
const cancleBtn = document.getElementById('cancle-btn');
const confirmBtn = document.getElementById('confirm-btn');

// 취소버튼
cancleBtn.addEventListener('click', () => {
    const isConfirm = confirm('취소하시겠습니까?');
    if (isConfirm) {
        window.location.href = 'sellerProductList.html';
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

    const isConfirm = confirm('확인 누르면 개인정보 변경, 취소 누르면 업체정보 변경으로 이동함');
    if(isConfirm) {
        location.href='sellerInfoModify.html';
    } else {
        location.href='sellerStoreModify.html';
    }
    // 비밀번호 일치하면 수정 페이지로 넘기기
    // 비밀번호 틀리면 alert
});
