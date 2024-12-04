const cancleBtn = document.getElementById('cancle-btn');
const registerBtn = document.getElementById('register-btn');



cancleBtn.addEventListener('click', ()=>{
    const isConfirm = confirm('글 작성을 취소하시겠습니까? 작업중인 내용이 저장되지 않습니다.');
    if(isConfirm){
        window.location.href = '/admin/eco/list';
    }else{

    }
});


registerBtn.addEventListener('click',(e)=> {
    e.preventDefault(); //기본 submit동작 막기

    const titleInput = document.querySelector('input[type="text"]'); // 제목 input
    const imgUpload = document.getElementById('post-image'); // 파일 업로드 input
    const contentInput = document.getElementById('detail').value; // 프로젝트소개 textarea
    const certifyInput = document.getElementById('certify').value; // 인증사항 textarea
    const joinSelect = document.getElementById('join'); // 참여횟수 select
    const startDateInput = document.querySelector('input.start-date-value'); // 시작날짜 input
    const endDateInput = document.querySelector('input.end-date-value'); // 종료날짜 input
    const pointInput = document.querySelector('input.point-value'); // 포인트 input

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
// 종료날짜 확인
else if (pointInput.value === '') {
        alert('포인트를 입력해주세요.');
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
        e.target.closest('form').submit();
    }
}
})

///////////////////////////////////////////////////////////////////////////
/////썸네일 처리하기
// {
//     let $input = document.querySelector('#post-image');
//     let $imgList = document.querySelectorAll('.img-list');
//
//     $input.addEventListener('change', function () {
//         // console.dir(this)
//         let files = this.files;
//
//         let newFiles = checkLength(files, 1);
//         appendImg(newFiles);
//         this.files = newFiles;
//
//         console.log(this.files);
//     });
//
//     $imgList.forEach(ele => {
//         ele.addEventListener('click', function(){
//             let name = this.dataset.name;
//             // console.log(name);
//             removeImg(name);
//
//             appendImg($input.files);
//         });
//     });
//
//
//     /**
//      * 미리보기 삭제 함수
//      *
//      * @param name : string
//      */
//     function removeImg(name){
//         let dt = new DataTransfer();
//         let files = $input.files;
//
//         for(let i=0; i<files.length; i++){
//             if(files[i].name !== name){
//                 dt.items.add(files[i]);
//             }
//         }
//
//         $input.files = dt.files;
//     }
//
//
//
//     /**
//      * 이미지 미리보기 처리 함수
//      * 이미지 수가 4개보다 적으면 기본 이미지로 대체
//      *
//      * @param files : FileList
//      */
//     function appendImg(files){
//         for (let i = 0; i < 2; i++) {
//             if(i < files.length){
//                 let src = URL.createObjectURL(files[i]);
//
//                 $imgList[i].style.background = `url(${src})`;
//                 $imgList[i].style.backgroundSize = 'cover';
//                 $imgList[i].dataset.name = files[i].name;
//                 $imgList[i].classList.add('x-box');
//             }else {
//                 $imgList[i].style.background = `url(data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIzNiIgaGVpZ2h0PSIzNiI+PGcgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj48ZyBzdHJva2U9IiNCNUI1QjUiIHN0cm9rZS13aWR0aD0iMS41IiB0cmFuc2Zvcm09InRyYW5zbGF0ZSg0IDQpIj48cmVjdCB3aWR0aD0iMjgiIGhlaWdodD0iMjgiIHJ4PSIzLjUiLz48Y2lyY2xlIGN4PSI4LjU1NiIgY3k9IjguNTU2IiByPSIyLjMzMyIvPjxwYXRoIGQ9Ik0yOCAxOC42NjdsLTcuNzc3LTcuNzc4TDMuMTExIDI4Ii8+PC9nPjxwYXRoIGQ9Ik0wIDBoMzZ2MzZIMHoiLz48L2c+PC9zdmc+)
//     no-repeat 50% #f2f2f2`;
//                 $imgList[i].style.backgroundSize = 'none';
//                 delete $imgList[i].dataset.name;
//                 $imgList[i].classList.remove('x-box');
//             }
//         }
//     }
//
//
//
//     /**
//      * 파일 길이 체크 함수
//      *
//      * @param files :FileList fileList 객체
//      * @param limit :number 최대 이미지 수
//      * @returns {FileList|*} 결과 파일리스트 객체
//      */
//     function checkLength(files, limit){
//         if(files.length > limit) {
//             alert(`파일은 최대 ${limit}개 까지만 첨부 가능합니다.`);
//             // 최대 수를 넘으면 비어있는 files 객체를 반환
//             return new DataTransfer().files;
//         }
//
//         return files;
//     }
// }
//






















