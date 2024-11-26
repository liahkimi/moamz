// 썸네일
const thumbnailInput = document.getElementById('attach');
const thumbnailImg = document.querySelector(".thumbnail-img");
const thumbnailCancleBtn = document.querySelector(".thumbnail-cancle-btn");

// 원본 파일 여부 변수
let originalExist = true;

// 파일 변경 감지 변수
let fileChanged = document.getElementById("fileChanged").value;

// 취소, 수정버튼
const cancleBtn = document.getElementById('cancle-btn');
const storeModifyBtn = document.getElementById('store-modify-btn');


/////////////////////////////////////////////////////////
///// 썸네일

// 정보 수정 페이지에서는 썸네일 x 버튼이 처음부터 보여야 함
thumbnailCancleBtn.style.display = "block";

thumbnailInput.addEventListener("change", (e) => {
    // 파일을 변경하게 되면 원본 파일은 사라지고, fileChanged 값을 true로 업데이트 해준다.
    // fileChanged=true, originalExist=false로 변경
    fileChanged = 'true';
    originalExist = 'false';

    // 비구조화 할당으로 업로드된 파일을 가져온다.
    const [file] = e.target.files;

    const reader = new FileReader();    //업로드된 파일을 읽을 수 있는 FileReader 객체
    reader.readAsDataURL(file);    //파일의 내용이 아니라 절대경로를 읽겠다는 의미
    
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
    // 썸네일 취소 버튼을 누르면 원본 파일이 사라지고, fileChanged 값을 false로 업데이트한다.
    fileChanged = 'false';
    originalExist = 'false';

    //1. 맨 처음 이미지로 변경
    thumbnailImg.style.backgroundImage = "url(/img/mypage/seller/thumbnail.png)";
    //2. input 태그의 value 초기화해주기
    thumbnailInput.value="";
    //3. X 버튼 숨기기
    thumbnailCancleBtn.style.display = "none";
});





/////////////////////////////////////////////////////////
///// 우편번호 API

function findPostCode() {
    new daum.Postcode({
        oncomplete:function(data){
            console.log(data);
            //팝업창에서 검색결과 항목을 클릭했을 때 실행할 코드를 작성하는 부분

            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다
            // 내려오는 변수가 값이 없는 경우 공백('')값을 가지므로, 이를 참고하여 분기한다
            let roadAddr = data.roadAddress; //도로 주소 변수
            let extraRoadAddr = ''; //참고 항목 변수

            // 법정동명이 있을 경우 추가한다(법정리는 제외)
            // 법정동의 경우 마지막 문자가 '동/로/가'로 끝난다
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }

            //건물명이 있고 공동주택일 경우 추가한다
            if(data.buildingName !== '' && data.apartment === 'Y' ){
                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다
            document.getElementById('address-num').value = data.zonecode;
            document.getElementById('address-detail-1').value = roadAddr;
        }
    }).open();
}





/////////////////////////////////////////////////////////
///// 나가기 버튼

cancleBtn.addEventListener('click', () => {
    const isConfirm = confirm('현재 페이지에서 나가시겠습니까? 작성한 내용이 저장되지 않습니다.');
    if(isConfirm) {
        location.href='/seller/sales/list';
    }
});





/////////////////////////////////////////////////////////
///// 변경하기 버튼

storeModifyBtn.addEventListener('click', (e) => {
    // form태그 자동제출 막기
    e.preventDefault();

    // form태그 요소들
    const addressDetail2 = document.getElementById('address-detail-2');
    const storePhoneNum = document.getElementById('store-phone-num');
    const storeOpenTime = document.getElementById('store-open-time')
    const storeCloseTime = document.getElementById('store-close-time')
    const storeDetail = document.getElementById('store-detail');

    // 값이 입력됐는지 검사

    // 새로 등록된 파일, 원본 파일이 모두 없는 경우에 대표사진 등록 alert
    if(!thumbnailInput.value && fileChanged === 'false' && originalExist === 'false') {
        alert('업체 대표사진을 등록해주세요.');
        return;
    }
    if(!addressDetail2.value.trim()) {
        alert('상세 주소를 입력해주세요.');
        addressDetail2.focus();
        return;
    }
    if(!storePhoneNum.value.trim()) {
        alert('업체 대표번호를 입력해주세요.');
        storePhoneNum.focus();
        return;
    }
    if(!storeOpenTime.value.trim()) {
        alert('오픈시간을 입력해주세요.');
        storeOpenTime.focus();
        return;
    }
    if(!storeCloseTime.value.trim()) {
        alert('마감시간을 입력해주세요.');
        storeCloseTime.focus();
        return;
    }
    if(!storeDetail.value.trim()) {
        alert('상세정보를 입력해주세요.');
        storeDetail.focus();
        return;
    }

    // 최종적으로 정해진 fileChanged 변수의 값을 input type=hidden 태그에 반영해준다.
    document.getElementById('fileChanged').value = fileChanged;

    const isConfirm = confirm('업체 정보를 수정하시겠습니까?');
    if(isConfirm) {
        // 폼 요소 제출하기
        document.querySelector('form').submit();
    }
})
 