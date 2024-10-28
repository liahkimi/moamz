const submitBtn = document.getElementById('submit-btn');

submitBtn.addEventListener('click', (e)=>{
    e.preventDefault();

    const idInput = document.querySelector('input[type="text"]');
    const pwInput = document.querySelector('input[type="password"]');

    // 💥추후, 관리자 아이디 생기면 js 보강하기
    if(idInput.value === ''){
        alert('아이디를 입력해주세요.');
    }else if(pwInput.value ===''){
        alert('비밀번호를 입력해주세요.')
    }else{
        window.location.href ='adminDashboard.html';
    }
})