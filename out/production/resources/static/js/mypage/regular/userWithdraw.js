const withdrawCheckbox = document.getElementById('withdraw-checkbox');
const inputPw = document.getElementById('input-password');
const cancleBtn = document.getElementById('cancle-btn');
const withdrawBtn = document.getElementById('withdraw-btn');

// 취소 버튼
cancleBtn.addEventListener('click', () => {
    const isConfirm = confirm('취소하시겠습니까?');
    if (isConfirm) {
        window.location.href = 'userPurchaseHistory.html';
    } else {
    }
});

// 탈퇴하기 버튼
withdrawBtn.addEventListener('click', (e) => {
    e.preventDefault(); // 기본 submit 동작 막기
    
    // 약관 체크 여부 확인
    if(!withdrawCheckbox.checked) {
        alert('탈퇴 약관에 동의해주세요.');
        return;
    }
    
    // 비밀번호 입력여부 확인
    if (!inputPw.value.trim()) {
        alert('비밀번호를 입력해주세요.');
        inputPw.focus();
        return;
    }

    // 비밀번호 일치여부도 나중에 확인해야 함

    const isConfirm = confirm('정말로 탈퇴하시겠습니까?');
    if(isConfirm) {
        alert('회원 탈퇴가 완료되었습니다.');
        location.href='../../main/main/mainPage.html'
    } else {
        
    }

})