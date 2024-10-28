const inputPw = document.getElementById('input-password');
const cancleBtn = document.getElementById('cancel');
const checkBtn = document.getElementById('check');

// 취소버튼
cancleBtn.addEventListener('click', () => {
    const isConfirm = confirm('취소하시겠습니까?');
    if (isConfirm) {
        window.location.href = 'userPurchaseHistory.html';
    } else {
    }
});

// 확인버튼
checkBtn.addEventListener('click', (e) => {
    e.preventDefault(); // 기본 submit 동작 막기

    if (!inputPw.value.trim()) {
        alert('비밀번호를 입력해주세요.');
        inputPw.focus();
        return;
    }

    const isConfirm = confirm('확인 누르면 회원정보 변경, 취소 누르면 비밀번호 변경으로 이동합니다');
    if(isConfirm) {
        location.href='userInfoModify.html';
    } else {
        location.href='userResetPassword.html';
    }
    // 비밀번호 일치하면 수정 페이지로 넘기기
    // 비밀번호 틀리면 alert
});