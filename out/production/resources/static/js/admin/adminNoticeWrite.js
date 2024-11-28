const content = document.querySelector(".write-form");
// const cancleBtn = document.getElementById('cancle-btn');
//
// // 작성하기 화면의 취소버튼 클릭
// // => 컨펌창 띄우기 => 취소에 대한 확인=> 컨펌창 닫고 목록화면으로
// //                 => 취소에 대한 취소 => 컨펌창만 닫기
// cancleBtn.addEventListener('click', (e)=>{
//     e.stopPropagation();
//     e.preventDefault();
//     const isConfirm = confirm('글 작성을 취소하시겠습니까? 작업중인 내용이 저장되지 않습니다.');
//     if(isConfirm){
//         window.location.href = '/admin/notice/list';
//     }else{
//
//     }
// });

// 작성하기화면의 등록버튼 클릭
document.addEventListener('DOMContentLoaded', () => {
    const cancleBtn = document.getElementById('cancle-btn');
    const registerBtn = document.getElementById('register-btn');
    const titleInput = document.querySelector('.write-form-title__value');
    const contentInput = document.getElementById('contentInput');

    // 작성하기 화면의 취소 버튼 클릭 이벤트
    cancleBtn.addEventListener('click', (e) => {
        e.preventDefault();
        const isConfirm = confirm('글 작성을 취소하시겠습니까? 작업중인 내용이 저장되지 않습니다.');
        if (isConfirm) {
            window.location.href = '/admin/notice/list';
        }
    });

    // 작성하기 화면의 등록 버튼 클릭 이벤트
    registerBtn.addEventListener('click', (e) => {
        e.preventDefault();

        if (titleInput.value.trim() === '') {
            alert('제목을 입력해주세요.');
            titleInput.focus();
        } else if (contentInput.value.trim() === '') {
            alert('상세내용을 입력해주세요.');
            contentInput.focus();
        } else {
            const isConfirm = confirm('등록하시겠습니까?');
            if (isConfirm) {
                e.target.closest('form').submit();
            }
        }
    });
});