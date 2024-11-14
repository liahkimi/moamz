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


///////////////////////////////////////////////////////
///// 썸네일

const thumbnailInput = document.getElementById("attach");
const thumbnailImg = document.querySelector(".thumbnail-img");
const thumbnailCancleBtn = document.querySelector(".thumbnail-cancle-btn");

//업로드한 파일 정보가 input 태그의 value에 들어간다.
//파일이 업로드 될 때 value가 변화된다.
//따라서 클릭이벤트를 주게 되면, 업로드 되기 전에 실행되기 때문에 change가 적합하다.
thumbnailInput.addEventListener("change", (e) => {
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
        thumbnailCancleBtn.style.display = "block";

        //base64로 인코딩된 경로를 src()에 담아주면 해당 경로의 이미지를 출력한다.
        if(e.target.result.includes("image")) {
            thumbnailImg.style.backgroundImage = `url("${e.target.result}")`;
            //x 버튼이 보여야 하는 곳

        } else {
            thumbnailImg.style.backgroundImage = `url("./")`;
        }

    })
});

// 썸네일 취소 버튼
thumbnailCancleBtn.addEventListener("click", (e) => {
    // 썸네일 취소 버튼 클릭 시 hidden input을 업데이트
    // 어차피 썸네일 무조건 등록해야 하니까 필요없을듯?
    // document.getElementById("fileChanged").value = "true";

    //1. 맨 처음 이미지로 변경
    thumbnailImg.style.backgroundImage = "url(/img/mypage/seller/thumbnail.png)";
    //2. input 태그의 value 초기화해주기
    thumbnailInput.value="";
    //3. X 버튼 숨기기
    thumbnailCancleBtn.style.display = "none";
});



const cancleBtn = document.getElementById('cancle-btn');
const writeBtn = document.getElementById('write-btn');

//취소버튼
cancleBtn.addEventListener('click', () => {
  const isConfirm = confirm('글 작성을 취소하시겠습니까? 작업중인 내용이 저장되지 않습니다.');
  if (isConfirm) {
      window.location.href = 'sharingList.html';
  } else {
  }
});

// //등록버튼 -> 모든 폼 요소가 입력되었을 때만 confirm창이 떠야함
// writeBtn.addEventListener('click', (e) => {
//   e.preventDefault(); // 기본 submit 동작 막기
//
//   const titleInput = document.querySelector('input[type="text"]');
//
//   const contentInput = $('#summernote').val();
//
//   if (titleInput.value.trim() === '') {
//       alert('제목을 입력해주세요.');
//   } else if (contentInput.trim() === '') {
//       alert('상세내용을 입력해주세요.');
//   } else {
//       const isConfirm = confirm('등록하시겠습니까?');
//       if (isConfirm) {
//           window.location.href = 'sharingDetail.html';
//       }
//   }
// });
// document.getElementById('file-input').addEventListener('click', () => {
//   document.getElementById('img-input').click();
//   // console.log('sad');
// });