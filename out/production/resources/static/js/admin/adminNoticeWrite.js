// 썸머노트 삽입
$(document).ready(function() {
    //여기 아래 부분
    $('#summernote').summernote({
          height: 1000,                 // 에디터 높이
          minHeight: 1000,             // 최소 높이
          maxHeight: 600,             // 최대 높이
          focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
          lang: "ko-KR",					// 한글 설정
    });
});

$(function() {
    $("#adminNavBar").load("adminNavBar.html");
    $("#adminHeader").load("adminHeader.html")
});

const cancleBtn = document.getElementById('cancle-btn');
const registerBtn = document.getElementById('register-btn');

// 작성하기 화면의 취소버튼 클릭
// => 컨펌창 띄우기 => 취소에 대한 확인=> 컨펌창 닫고 목록화면으로
//                 => 취소에 대한 취소 => 컨펌창만 닫기
cancleBtn.addEventListener('click', ()=>{
    const isConfirm = confirm('글 작성을 취소하시겠습니까? 작업중인 내용이 저장되지 않습니다.');
    if(isConfirm){
        window.location.href = 'adminNoticeList.html';
    }else{

    }
});
// 작성하기화면의 등록버튼 클릭
// => 컨펌창 띄우기 => 등록에 대한 확인 => 필수입력사항 확인하고 등록
//                  => 등록에  대한 취소 => 컨펌창만 닫기
registerBtn.addEventListener('click',(e)=> {
    e.preventDefault(); //기본 submit동작 막기

    const titleInput = document.querySelector('input[type="text"]');
    const contentInput = $('#summernote').val();
    if(titleInput.value.trim() == ''){
        alert('제목을 입력해주세요.');
    }else if(contentInput.trim() === ''){
        alert('상세내용을 입력해주세요.')
    }else{
        const isConfirm = confirm('등록하시겠습니까?');
        if(isConfirm){
            window.location.href ='adminNoticeList.html';
        }
    }
})