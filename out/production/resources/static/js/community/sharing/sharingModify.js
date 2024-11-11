////////////////////////////////////////////////////////
///// 썸머노트 삽입

$(document).ready(function() {
    $('#summernote').summernote({
        height: 400,                 // 에디터 높이
        minHeight: null,             // 최소 높이
        maxHeight: 400,             // 최대 높이
        focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
        lang: "ko-KR",					// 한글 설정
    });
});





///////////////////////////////////////////////////////
///// 썸네일

const thumbnailInput = document.getElementById("attach");
const thumbnailImg = document.querySelector(".thumbnail-img");
const thumbnailCancleBtn = document.querySelector(".thumbnail-cancle-btn");
// 원본 파일 여부 변수
let originalExist = document.getElementById('originalFileExists').value;
// 파일 변경 감지 변수
let fileChanged = document.getElementById("fileChanged").value;

// 게시글 수정은 x 버튼이 처음부터 보여야 함
thumbnailCancleBtn.style.display = "block";

//업로드한 파일 정보가 input 태그의 value에 들어간다.
//파일이 업로드 될 때 value가 변화된다.
//따라서 클릭이벤트를 주게 되면, 업로드 되기 전에 실행되기 때문에 change가 적합하다.
thumbnailInput.addEventListener("change", (e) => {
    // 파일을 변경하게 되면
    // fileChanged = true, originalExist = false로 변경한다.
    fileChanged = 'true';
    originalExist = 'false';
    console.log(`💛💛fileChanged 변경 ${fileChanged}`);
    // 🤯🤯🤯🤯🤯js에서 변경된 파일 변경 감지 변수가 컨트롤러로 안넘어감!!


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
    // 썸네일 취소 버튼을 누르면
    // fileChanged = false, originalExist = false 상태이다.
    fileChanged = 'false';
    originalExist = 'false';

    //1. 맨 처음 이미지로 변경
    thumbnailImg.style.backgroundImage = "url(/img/mypage/seller/thumbnail.png)";
    //2. input 태그의 value 초기화해주기
    thumbnailInput.value="";
    //3. X 버튼 숨기기
    thumbnailCancleBtn.style.display = "none";
});




///////////////////////////////////////////////////////
///// 글 작성취소, 등록 버튼 처리

const cancleBtn = document.getElementById('cancle-btn');
const writeBtn = document.getElementById('write-btn');
const postId = document.querySelector('form').getAttribute('data-id');

// 취소버튼
cancleBtn.addEventListener('click', () => {
    const isConfirm = confirm('글 작성을 취소하시겠습니까? 작업중인 내용이 저장되지 않습니다.');
    if (isConfirm) {
        // 게시글 상세 페이지로 이동한다.
        window.location.href = `/sharing/detail/${postId}`;
    }
});


// 등록버튼 -> 모든 폼 요소가 입력되었을 때만 confirm창이 떠야함
writeBtn.addEventListener('click', (e) => {
    // 기본 submit 막기
    e.preventDefault();

    const titleInput = document.getElementById('postTitle');
    const thumbnail = thumbnailInput.value;
    const contentInput = $('#summernote').val();

    if (!titleInput.value.trim()) {
        alert('제목을 입력해주세요.');
        titleInput.focus();
        return;
    }

    // 사용자가 아무 처리도 안한 경우  ->  alert 없음.. 기존 파일로 처리
    // original = true, changed = false, !썸네일

    // 사용자가 새로운 파일을 등록한 경우 -> alert 없음.. 새로운 파일로 처리
    // 썸네일o, original = false로 바꿔주고, changed= true로 바꿔주기

    // 사용자가 새로운 파일 등록했다가 삭제한 경우
    // !썸네일, original = false, changed=false인 경우 -> alert!!
    if (!thumbnail && fileChanged === "false" && originalExist === "false") {
        alert('대표 사진을 등록해주세요.');
        return;
    }
    if (contentInput.trim() === '') {
        alert('상세내용을 입력해주세요.');
        return;
    }

    // fileChanged 값을 hidden input에 반영
    document.getElementById('fileChanged').value = fileChanged;

    const isConfirm = confirm('등록하시겠습니까?');
    if (isConfirm) {
        document.querySelector('form').submit();
    }

});
