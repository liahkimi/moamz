const availableBtn = document.getElementById('sharing-available-btn');
const reservedBtn = document.getElementById('sharing-reserved-btn');
const completedBtn = document.getElementById('sharing-completed-btn');    
const availableList = document.getElementById('sharing-available-list');
const reservedList = document.getElementById('sharing-reserved-list');
const completedList = document.getElementById('sharing-completed-list');

// 나눔가능 버튼 눌렀을 떄
availableBtn.addEventListener('click', () => {
    availableBtn.classList.add('active');
    reservedBtn.classList.remove('active');
    completedBtn.classList.remove('active');
    availableList.classList.remove('hidden');
    reservedList.classList.add('hidden');
    completedList.classList.add('hidden');
});

// 예약중 버튼 눌렀을 때
reservedBtn.addEventListener('click', () => {
    availableBtn.classList.remove('active');
    reservedBtn.classList.add('active');
    completedBtn.classList.remove('active');
    availableList.classList.add('hidden');
    reservedList.classList.remove('hidden');
    completedList.classList.add('hidden');
});

// 나눔완료 버튼 눌렀을 때
completedBtn.addEventListener('click', () => {
    availableBtn.classList.remove('active');
    reservedBtn.classList.remove('active');
    completedBtn.classList.add('active');
    availableList.classList.add('hidden');
    reservedList.classList.add('hidden');
    completedList.classList.remove('hidden');
});

// 페이지네이션..