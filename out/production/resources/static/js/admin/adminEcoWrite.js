const cancleBtn = document.getElementById('cancle-btn');
const registerBtn = document.getElementById('register-btn');



cancleBtn.addEventListener('click', ()=>{
    const isConfirm = confirm('글 작성을 취소하시겠습니까? 작업중인 내용이 저장되지 않습니다.');
    if(isConfirm){
        window.location.href = 'adminEcoList.html';
    }else{

    }
});

registerBtn.addEventListener('click',(e)=> {
    e.preventDefault(); //기본 submit동작 막기

    const titleInput = document.querySelector('input[type="text"]'); // 제목 input
    const imgUpload = document.getElementById('file'); // 파일 업로드 input
    const contentInput = document.getElementById('detail').value; // 프로젝트소개 textarea
    const certifyInput = document.getElementById('certify').value; // 인증사항 textarea
    const joinSelect = document.getElementById('join'); // 참여횟수 select
    const startDateInput = document.querySelector('input.start-date-value'); // 시작날짜 input
    const endDateInput = document.querySelector('input.end-date-value'); // 종료날짜 input

  // 제목 확인
  if (titleInput.value.trim() === '') {
    alert('제목을 입력해주세요.');
} 
// 파일 업로드 확인
else if (imgUpload.files.length === 0) {
    alert('대표 사진을 업로드해주세요.');
} 
// 참여횟수 확인
else if (joinSelect.value === 'default') {
    alert('참여횟수를 선택해주세요.');
} 
// 시작날짜 확인
else if (startDateInput.value === '') {
    alert('시작날짜를 선택해주세요.');
} 
// 종료날짜 확인
else if (endDateInput.value === '') {
    alert('종료날짜를 선택해주세요.');
} 
// 상세 내용 확인
else if (contentInput.trim() === '') {
    alert('프로젝트를 소개해주세요.');
} 
else if(certifyInput.trim() === ''){
    alert('인증사항을 입력해주세요')
}
// 모든 조건 통과
else {
    const isConfirm = confirm('등록하시겠습니까?');
    if (isConfirm) {
        // 등록 로직
        window.location.href = 'adminEcoList.html';
    }
}
})