// 썸머노트 삽입
$(document).ready(function() {
    //여기 아래 부분
    $('#summernote').summernote({
          height: 400,                 // 에디터 높이
          minHeight: null,             // 최소 높이
          maxHeight: null,             // 최대 높이
          focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
          lang: "ko-KR",					// 한글 설정
    });
});


const cancleBtn = document.getElementById('cancle-btn');
const writeBtn = document.getElementById('write-btn');

//취소버튼
cancleBtn.addEventListener('click', () => {
    const isConfirm = confirm('글 작성을 취소하시겠습니까? 작업중인 내용이 저장되지 않습니다.');
    if (isConfirm) {
        window.location.href = 'freeList.html';
    } else {
    }
});

//등록버튼 -> 모든 폼 요소가 입력되었을 때만 confirm창이 떠야함
writeBtn.addEventListener('click', (e) => {
    e.preventDefault(); // 기본 submit 동작 막기

    const titleInput = document.querySelector('input[type="text"]');
    const contentInput = $('#summernote').val();

    if (titleInput.value.trim() === '') {
        alert('제목을 입력해주세요.');
    } else if (contentInput.trim() === '') {
        alert('상세내용을 입력해주세요.');
    } else {
        const isConfirm = confirm('등록하시겠습니까?');
        if (isConfirm) {
            window.location.href = 'freeDetail.html';
        }
    }
});
