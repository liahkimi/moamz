const inputPw = document.getElementById('inputPw');
const checkPw = document.getElementById('password-check');
const passwordMessage = document.getElementById('password-message');
const confirmMessage = document.getElementById('confirm-message');
const pwModifyBtn = document.getElementById('pw-modify-btn');
const cancleBtn = document.getElementById('cancle-btn');

// 비밀번호 유효성검사
const pwValidateCheck = () => { 
    const password = inputPw.value;
    // 정규식
    // (?=.*[a-zA-Z])   => 적어도 하나 이상의 알파벳(대문자 또는 소문자) 포함
    // (?=.*\d)         => 적어도 하나 이상의 숫자 포함
    // (?=.*[@$!%*?&])  => 적어도 하나 이상의 특수문자(@$!%*?&) 포함
    // [A-Za-z\d@$!%*?&] => 허용하는 문자는 알파벳, 숫자, 특수문자
    // {8,20}           => 비밀번호 길이는 8자에서 20자 사이
    const regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/;

    if (regex.test(password)) {
        passwordMessage.textContent = '사용 가능한 비밀번호입니다.';
        passwordMessage.style.color = 'green';
        return true;
    } else {
        passwordMessage.textContent = '비밀번호 형식에 맞게 입력해주세요.';
        passwordMessage.style.color = 'red';
        return false;
    }
};

// 비밀번호 일치여부 검사
const pwMatchCheck = () => {
    const password = inputPw.value;
    const checkPassword = checkPw.value;

    if (password === checkPassword) {
        confirmMessage.textContent = '비밀번호가 일치합니다.';
        confirmMessage.style.color = 'green';
        return true;
    } else {
        confirmMessage.textContent = '비밀번호가 일치하지 않습니다.';
        confirmMessage.style.color = 'red';
        return false;
    }
};

function checkFormValidity() {
    // 비밀번호 유효성검사
    const isPasswordValid = pwValidateCheck();
    // 비밀번호 일치여부 검사
    const isConfirmValid = pwMatchCheck();

    // 둘 다 true일 때만 비밀번호 변경 활성화
    if (isPasswordValid && isConfirmValid) {
        pwModifyBtn.disabled = false;
    } else {
        pwModifyBtn.disabled = true;
    }
}

// 비밀번호 입력칸 값 들어올 때마다 유효성검사
inputPw.addEventListener('input', checkFormValidity);
// 재확인칸 값 들어올 때마다 일치여부 검사
checkPw.addEventListener('input', checkFormValidity);


// 비밀번호 변경 버튼
pwModifyBtn.addEventListener('click', () => {
    const isConfirm = confirm('비밀번호를 변경하시겠습니까? 다시 로그인이 필요합니다.');
    if(isConfirm) {
        location.href='../../user/seller/sellerLogin.html'
    } else {

    }
})

// 나가기 버튼
cancleBtn.addEventListener('click', () => {
    const isConfirm = confirm('현재 페이지에서 나가시겠습니까? 작성한 내용이 저장되지 않습니다.');
    if(isConfirm) {
        location.href='sellerSalesHistory.html';
    }
});
