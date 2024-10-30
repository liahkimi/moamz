const userMngBtn = document.getElementById('user-management-btn');
const sellerMngBtn = document.getElementById('seller-management-btn');
const userList = document.getElementById('user-table-container');
const sellerList = document.getElementById('seller-table-container');


userMngBtn.addEventListener('click',function(){
    this.classList.add('active-btn');
    sellerMngBtn.classList.remove('active-btn');
    userList.classList.remove('table-hidden');
    sellerList.classList.add('table-hidden');
})
sellerMngBtn.addEventListener('click',function(){
    this.classList.add('active-btn');
    userMngBtn.classList.remove('active-btn');
    sellerList.classList.remove('table-hidden');
    userList.classList.add('table-hidden');

})


// 상세 페이지로 이동하는 함수
function goToDetailPage() {
    window.location.href = "adminUserInquiryDetail.html";  // 상세 페이지 URL로 이동
  }

// 답변 상태 바꾸는 함수 => tr의 이벤트 영향 안받게 하기
 function changeStatusBtn(event) {
    alert("답변완료로 변경하시겠습니까?");
    event.stopPropagation();  // 이벤트 전파 막기
  }