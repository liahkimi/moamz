
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


// 입력폼요소
const socialingTitle = document.getElementById('socialing-title');
const categorySelect = document.getElementById('category-select');
const maxPerson = document.querySelector('.max-person-wrap input');
const startDate = document.querySelector('.start-date-wrap input');
const endDate = document.querySelector('.end-date-wrap input');
const locationSelect = document.querySelector('.location-wrap select');
const genderSelect = document.querySelector('.gender-wrap select');
const minAge = document.getElementById('min-age');
const maxAge = document.getElementById('max-age');
const socialingDetail = document.querySelector('textarea');

// 등록, 취소버튼
const cancleBtn = document.getElementById('cancle-btn');
const writeBtn = document.getElementById('write-btn');


// 취소버튼
cancleBtn.addEventListener('click', () => {
    const isConfirm = confirm('글 작성을 취소하시겠습니까? 작업중인 내용이 저장되지 않습니다.');
    if (isConfirm) {
        window.location.href = 'userPurchaseHistory.html';
    } else {
    }
});

// 등록버튼 -> 모든 폼 요소가 입력되었을 때만 confirm창이 떠야함
writeBtn.addEventListener('click', (e) => {
    e.preventDefault(); // 기본 submit 동작 막기

    const socialingTitle = document.getElementById('socialing-title');
    const categorySelect = document.getElementById('category-select');
    const maxPerson = document.querySelector('.max-person-wrap input');
    const startDate = document.querySelector('.start-date-wrap input');
    const endDate = document.querySelector('.end-date-wrap input');
    const locationSelect = document.querySelector('.location-wrap select');
    const genderSelect = document.querySelector('.gender-wrap select');
    const minAge = document.getElementById('min-age');
    const maxAge = document.getElementById('max-age');
    const socialingDetail = document.querySelector('textarea');

    // 폼 요소 값 입력되었는지, 유효성 검사
    if (!socialingTitle.value.trim()) {
        alert('소셜링 제목을 입력해주세요.');
        socialingTitle.focus();
        return;
    }
    if (!categorySelect.value.trim()) {
        alert('카테고리를 선택해주세요.');
        categorySelect.focus();
        return;
    }
    if (!maxPerson.value.trim() || maxPerson.value <= 2) {
        alert('최대인원을 2명 이상 입력해주세요.');
        maxPerson.focus();
        return;
    }
    if (!startDate.value.trim()) {
        alert('소셜링 시작 날짜를 입력해주세요.');
        startDate.focus();
        return;
    }
    if (!endDate.value.trim()) {
        alert('소셜링 종료 날짜를 입력해주세요.');
        endDate.focus();
        return;
    }
    if (!locationSelect.value.trim()) {
        alert('소셜링 위치를 선택해주세요.');
        locationSelect.focus();
        return;
    }
    if (!genderSelect.value.trim()) {
        alert('성별 제한을 선택해주세요.');
        genderSelect.focus();
        return;
    }
    if (!minAge.value.trim()) {
        alert('최소 나이제한을 입력해주세요.');
        minAge.focus();
        return;
    }
    if (!maxAge.value.trim()) {
        alert('최대 나이제한을 입력해주세요.');
        maxAge.focus();
        return;
    }
    if (!socialingDetail.value.trim()) {
        alert('소셜링 상세 내용을 입력해주세요.');
        socialingDetail.focus();
        return;
    }

    // 모든 필드가 입력되었을 때 confirm
    const isConfirm = confirm('소셜링을 등록하시겠습니까?');
    if (isConfirm) {
        alert('등록되었습니다. 마이페이지>my소셜링에서 소셜링 관리가 가능합니다.')
        location.href='userMySocialing.html';
    } else {

    }
});