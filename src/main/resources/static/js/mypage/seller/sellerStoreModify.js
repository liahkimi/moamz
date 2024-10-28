const thumbnailInput = document.getElementById('attach');
const thumbnailImg = document.querySelector(".thumbnail-img");
const thumbnailCancleBtn = document.querySelector(".thumbnail-cancle-btn");
const addressDetail2 = document.getElementById('address-detail-2');
const storePhoneNum = document.getElementById('store-phone-num');
const storeOpenTime = document.getElementById('store-open-time')
const storeCloseTime = document.getElementById('store-close-time')
const storeDetail = document.getElementById('store-detail');
const cancleBtn = document.getElementById('cancle-btn');
const storeModifyBtn = document.getElementById('store-modify-btn');



// 썸네일
thumbnailInput.addEventListener("change", (e) => {
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
    //1. 맨 처음 이미지로 변경
    thumbnailImg.style.backgroundImage = "url(../../../static/img/mypage/seller/thumbnail.png)";
    //2. input 태그의 value 초기화해주기
    thumbnailInput.value="";
    //3. X 버튼 숨기기
    thumbnailCancleBtn.style.display = "none";
});


// 나가기 버튼
cancleBtn.addEventListener('click', () => {
    const isConfirm = confirm('현재 페이지에서 나가시겠습니까? 작성한 내용이 저장되지 않습니다.');
    if(isConfirm) {
        location.href='sellerSalesHistory.html';
    }
});

// 변경하기 버튼
storeModifyBtn.addEventListener('click', () => {

    // 값이 입력됐는지 검사
    if(!thumbnailInput.value) {
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

    const isConfirm = confirm('업체 정보를 수정하시겠습니까?');
    if(isConfirm) {
        alert('수정되었습니다.');
        location.href='sellerSalesHistory.html';
    } else {

    }
})
 