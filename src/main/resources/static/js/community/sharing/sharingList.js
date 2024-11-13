// 나눔가능, 예약중, 나눔완료 버튼
const availableBtn = document.getElementById('sharing-available-btn');
const reservedBtn = document.getElementById('sharing-reserved-btn');
const completedBtn = document.getElementById('sharing-completed-btn');    
// 각각의 게시글 목록
const availableList = document.getElementById('sharing-available-list');
const reservedList = document.getElementById('sharing-reserved-list');
const completedList = document.getElementById('sharing-completed-list');
// 각각의 페이지네이션 영역
const availablePage = document.querySelector('.page-container.available');
const reservedPage = document.querySelector('.page-container.reserved');
const completedPage = document.querySelector('.page-container.completed');


// 나눔가능 버튼 눌렀을 떄
availableBtn.addEventListener('click', () => {
    // 나눔가능 버튼에만 active 클래스 추가
    availableBtn.classList.add('active');
    reservedBtn.classList.remove('active');
    completedBtn.classList.remove('active');
    // 나눔가능 목록만 보여지도록
    availableList.classList.remove('hidden');
    reservedList.classList.add('hidden');
    completedList.classList.add('hidden');
    // 나눔가능 페이징만 보여지도록
    availablePage.classList.remove('hidden');
    reservedPage.classList.add('hidden');
    completedPage.classList.add('hidden');
});

// 예약중 버튼 눌렀을 때
reservedBtn.addEventListener('click', () => {
    // 예약중 버튼에만 active 클래스 추가
    availableBtn.classList.remove('active');
    reservedBtn.classList.add('active');
    completedBtn.classList.remove('active');
    // 예약중 목록만 보여주기
    availableList.classList.add('hidden');
    reservedList.classList.remove('hidden');
    completedList.classList.add('hidden');
    // 예약중 페이징만 보여지기
    availablePage.classList.add('hidden');
    reservedPage.classList.remove('hidden');
    completedPage.classList.add('hidden');
});

// 나눔완료 버튼 눌렀을 때
completedBtn.addEventListener('click', () => {
    // 나눔 완료 버튼에만 active 클래스 추가
    availableBtn.classList.remove('active');
    reservedBtn.classList.remove('active');
    completedBtn.classList.add('active');
    // 나눔 완료 목록만 보여주기
    availableList.classList.add('hidden');
    reservedList.classList.add('hidden');
    completedList.classList.remove('hidden');
    // 나눔완료 페이징만 보여주기
    availablePage.classList.add('hidden');
    reservedPage.classList.add('hidden');
    completedPage.classList.remove('hidden');
});

// 페이지네이션..