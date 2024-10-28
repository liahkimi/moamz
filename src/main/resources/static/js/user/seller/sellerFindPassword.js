const name = document.getElementById("find-name-check");
const phone = document.getElementById("find-phone-check");
const find = document.getElementById("find-id-btn");
const check = document.getElementById("find-phone-recheck");

find.addEventListener("click", () => {
  if(!name.value.trim()){
    alert("이름을 입력해주세요");
    return;
  }
  if(!phone.value.trim()){
    alert("휴대폰 인증을 확인해주세요");
    return;
  }
  if(!check.value.trim()){
    alert("인증번호를 입력해주세요.");
    return;
  }
  const isConfirm = confirm("비밀번호 변경 페이지로 이동하시겠습니까?")
  if(isConfirm){
    location.href='userResetPassword.html';
  }
  
});


// ----------------------------------------------------------------------------
$(document).ready(function() {
    let seconds; // 남은 시간 변수
    let countdown; // 카운트다운을 관리하는 변수
    const $timeSpan = $('#time'); // 시간을 표시할 요소
    const $btnSend = $('#phone-send'); // "인증번호 받기" 버튼 요소

    // 시간을 업데이트하고 화면에 표시하는 함수
    const updateCountdown = function() {
        if (seconds >= 0) {
            const minutes = Math.floor(seconds / 60);
            const remainingSeconds = seconds % 60;
            $timeSpan.text(`${minutes.toString().padStart(2, '0')}:${remainingSeconds.toString().padStart(2, '0')}`);
            seconds--;
        } else {
            clearInterval(countdown);
            alert('인증번호 유효시간이 만료되었습니다.');
        }
    };

    // "인증번호 받기" 버튼 클릭 이벤트 핸들러
    $btnSend.on('click', function(e) {
        e.preventDefault();
        $btnSend.text('재전송');
        alert('인증번호가 발송되었습니다.');

        clearInterval(countdown);
        seconds = 180; // 3분(180초)

        updateCountdown();
        // 1초마다 카운트다운 업데이트
        countdown = setInterval(updateCountdown, 1000); 
    });
});