const inputPw = document.getElementById('inputPw');
const checkPw = document.getElementById('password-check');
const passwordMessage = document.getElementById('password-message');
const confirmMessage = document.getElementById('confirm-message');

// 버튼
const pwModifyBtn = document.getElementById('pw-modify-btn');
const phoneModifyBtn = document.getElementById('phone-modify-btn');
const cancleBtn = document.getElementById('cancle-btn');


////////////////////////////////////////////////
///// 비밀번호 유효성검사

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





////////////////////////////////////////////////
///// 비밀번호 변경 버튼

pwModifyBtn.addEventListener('click', () => {
    const isConfirm = confirm('비밀번호를 변경하시겠습니까? 다시 로그인해야 합니다.');

    if (isConfirm) {
        // 새 비밀번호 가져오기
        const inputPw = document.querySelector('#inputPw').value;

        // 컨트롤러로 post요청 보내기
        fetch(`/seller/my/updatePw`, {
            method: 'POST',
            headers: {
                // application/x-www-form-urlencoded
                // 서버에 전송하는 데이터를 key=value 형식으로 인코딩하여 URL처럼 전송한다.
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            // new URLSearchParams
            // key=value 형식으로 데이터를 인코딩해주는 객체
            // Content-Type: application/x-www-form-urlencoded 형식에 맞는 데이터로 변환해준다.
            body: new URLSearchParams({
                inputPw: inputPw
            })
        }).then(response => response.text())    // 응답을 text로 반환
            .then(data => {

                // 응답결과가 false일 때(비밀번호 변경 실패시)
                if(data ===  'false') {
                    alert('이전 비밀번호와 동일한 비밀번호로는 변경할 수 없습니다.');
                    // 화면 새로고침
                    location.reload();
                } else {
                    // 응답결과가 true일 때 판매자 로그인 화면으로 리다이렉트
                    location.href = '/seller/seller/sellerLogin';
                }
            })

    }
});





////////////////////////////////////////////////
///// 휴대폰번호 변경 버튼 활성화 (문자인증api)

const inputPhoneNum = document.querySelector('#input-phone-num');

// 휴대폰번호 입력란에 값이 들어올 때마다 이벤트 발생
inputPhoneNum.addEventListener('input', (e) => {
    // 일단은 값이 들어오면 활성화되도록 처리
    if(inputPhoneNum.value.trim()) {
        phoneModifyBtn.disabled = false;
    }
});





////////////////////////////////////////////////
///// 휴대폰번호 변경 버튼 이벤트처리

phoneModifyBtn.addEventListener('click', () => {
    const isConfirm = confirm('휴대폰 번호를 변경하시겠습니까?');

    if (isConfirm) {
        // 새 번호 가져오기
        const inputPhone = document.querySelector('#input-phone-num').value;

        // 컨트롤러로 post요청 보내기
        fetch(`/seller/my/updatePhone`, {
            method: 'POST',
            headers: {
                // application/x-www-form-urlencoded
                // 서버에 전송하는 데이터를 key=value 형식으로 인코딩하여 URL처럼 전송한다.
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            // new URLSearchParams
            // key=value 형식으로 데이터를 인코딩해주는 객체
            // Content-Type: application/x-www-form-urlencoded 형식에 맞는 데이터로 변환해준다.
            body: new URLSearchParams({
                inputPhone: inputPhone
            })
        }).then(response => response.text())    // 응답을 text로 반환
            .then(data => {
                console.log(data);
                // 응답결과가 false일 때(핸드폰번호 변경 실패시)
                if(data ===  'false') {
                    alert('이전 핸드폰번호와 동일한 번호로는 변경할 수 없습니다.');
                    // 화면 새로고침
                    location.reload();
                } else {
                    // 응답결과가 true일 때(핸드폰번호 변경 성공시)
                    alert('변경되었습니다.');
                    // 화면 새로고침
                    location.reload();
                }
            })

    }
});


////////////////////////////////////////////////
///// 나가기 버튼

cancleBtn.addEventListener('click', () => {
    const isConfirm = confirm('현재 페이지에서 나가시겠습니까? 작성한 내용이 저장되지 않습니다.');
    if(isConfirm) {
        location.href='/seller/sales/list';
    }
});
