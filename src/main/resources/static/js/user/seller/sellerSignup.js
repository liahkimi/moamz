const emailBtn = document.getElementById("email-btn");

emailBtn.addEventListener("click", () => {
  alert("아이디 중복검사");
});




  const input = document.getElementById("attach");
  const thumnail = document.querySelector("div.image");
  const cancle = document.querySelector("div.cancle");

  //업로드한 파일 정보가 input 태그의 value에 들어간다.
  //파일이 업로드 될 때 value가 변화된다.
  //따라서 클릭이벤트를 주게 되면, 업로드 되기 전에 실행되기 때문에 change가 적합하다.
  input.addEventListener("change", (e) => {
      //console.log(e.target.files);
      
      //비구조화 할당
      //업로드된 파일을 가져온다
      //e.target.files는 FileList 자료형이다.
      const [file] = e.target.files;

      const reader = new FileReader();    //업로드된 파일을 읽을 수 있는 FileReader 객체
      reader.readAsDataURL(file);    //파일의 내용이 아니라 절대경로를 읽겠다는 의미
      
      //경로를 읽어오는 방식이 stream 방식이다.
      //reader객체가 파일을 다 읽어왔다면 load 이벤트를 발생시킨다.
      //이 이벤트가 발생했ㅇ르 때 reader 객체는 인코딩된 절대경로를 가진다.
      reader.addEventListener("load", (e) => { 
          //x 버튼이 보이도록 함
          cancle.style.display = "block";

          //base64로 인코딩된 경로를 src()에 담아주면 해당 경로의 이미지를 출력한다.
          if(e.target.result.includes("image")) {
              thumnail.style.backgroundImage = `url("${e.target.result}")`;
              //x 버튼이 보여야 하는 곳

          } else {
              thumnail.style.backgroundImage = `url("./")`;
          }
          
      })
  })


  //cancle 버튼이 눌리면
  cancle.addEventListener("click", (e) => {

      //1. 맨 처음 이미지로 변경
      thumnail.style.backgroundImage = "url('./a.png')";

      //2. input 태그의 value 초기화해주기
      input.value="";

      //3. X 버튼 숨기기
      cancle.style.display = "none";
  })
//-----------------------------------------------------------
const inputPw = document.getElementById('password-input');
const checkPw = document.getElementById('password-recheck');
const passwordMessage = document.getElementById('check-p');
const confirmMessage = document.getElementById('recheck-p');


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




//-----------------------------------------------------------
$(document).ready(function() {
  let seconds; // 남은 시간 변수
  let countdown; // 카운트다운을 관리하는 변수
  const $timeSpan = $('#time'); // 시간을 표시할 요소
  const $btnSend = $('#phone-btn'); // "인증번호 받기" 버튼 요소

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

// -----------------------------------------------------------------------------------------


  // 모달 열기 함수
  function openModal(event) {
    event.stopPropagation();  // 클릭 이벤트 전파 차단하여 tr 클릭을 방지
    document.getElementById('myModal').style.display = "block";  // 모달 열기
  }
  
  // 모달 닫기 함수
  function closeModal() {
    document.getElementById('myModal').style.display = "none";  // 모달 닫기
  }
  
//   // 모달 외부를 클릭하면 닫기
//   window.onclick = function(event) {
//     const modal = document.getElementById('myModal');
//     if (event.target === modal) {
//       modal.style.display = "none";  // 모달 닫기
//     }
//   }

// 포인트지급하기 버튼에서 적용버튼 누르면 
// 지급되었다는 알럿뜨고 모달 닫기
const submitBtn = document.getElementById('subminBtn');
submitBtn.addEventListener('click',(e)=>{
    const modal = document.getElementById('myModal');
    modal.style.display = "none";  // 모달 닫기
})

// 체크박스 클릭 시 모달 안보이게
function checkboxClick(event){
  event.stopPropagation();
}
