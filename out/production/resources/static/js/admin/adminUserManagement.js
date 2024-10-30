const userMngBtn = document.getElementById('user-management-btn');
const sellerMngBtn = document.getElementById('seller-management-btn');
const userList = document.getElementById('user-table-container');
const sellerList = document.getElementById('seller-table-container');

//'일반회원'버튼 클릭시, 
// => '일반회원'버튼 active, '판매자회원'버튼 active지우기
// => 일반회원테이블 보이기, 판매자회원테이블 숨기기
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