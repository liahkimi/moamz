const cancleBtn = document.getElementById('cancle-btn');
const writeBtn = document.getElementById('write-btn');
const inputTitle = document.querySelector('input[type="text"]');
const inputContent = document.querySelector('textarea');

console.log(inputContent);
//취소버튼
cancleBtn.addEventListener('click', () => {
    const isConfirm = confirm('글 작성을 취소하시겠습니까? 작업중인 내용이 저장되지 않습니다.');
    if (isConfirm) {
        window.location.href = 'userAdminInquiryList.html';
    } else {
    }
});

//등록버튼
writeBtn.addEventListener('click', (e) => {
    e.preventDefault();

    if (!inputTitle.value.trim()) {
        alert('문의제목을 입력해주세요.');
        inputTitle.focus();
        return;
    }
    if (!inputContent.value.trim()) {
        alert('문의내용을 입력해주세요.');
        inputContent.focus();
        return;
    }

    const isConfirm = confirm('등록하시겠습니까?');
    if (isConfirm) {
        location.href = 'userAdminInquiryDetail.html';
    } else {

    }
    
});