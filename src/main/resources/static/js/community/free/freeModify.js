////////////////////////////////////////////////////////
///// 썸머노트 삽입

$(document).ready(function() {
    $('#summernote').summernote({
        height: 400,                 // 에디터 높이
        minHeight: null,             // 최소 높이
        maxHeight: null,             // 최대 높이
        focus: true,                 // 에디터 로딩후 포커스를 맞출지 여부
        lang: "ko-KR",			   // 한글 설정
    });
});





///////////////////////////////////////////////////////
///// 글 작성취소, 등록 버튼 처리

const cancleBtn = document.getElementById('cancle-btn');
const writeBtn = document.getElementById('write-btn');
const postId = document.querySelector('form').getAttribute('data-id');


//취소버튼
cancleBtn.addEventListener('click', () => {
    const isConfirm = confirm('글 작성을 취소하시겠습니까? 작업중인 내용이 저장되지 않습니다.');

    if (isConfirm) {
        // 게시글 상세페이지로 이동
        location.href = '/free/detail/' + postId;
    }
});


//등록버튼 -> 모든 폼 요소가 입력되었을 때만 confirm창이 떠야함
writeBtn.addEventListener('click', (e) => {
    e.preventDefault(); // 기본 submit 동작 막기

    const titleInput = document.getElementById('postTitle');
    const contentInput = $('#summernote').val();

    if (titleInput.value.trim() === '') {
        alert('제목을 입력해주세요.');
    } else if (contentInput.trim() === '') {
        alert('상세내용을 입력해주세요.');
    } else {
        const isConfirm = confirm('등록하시겠습니까?');
        if (isConfirm) {
            document.querySelector('form').submit();
        }
    }
});
