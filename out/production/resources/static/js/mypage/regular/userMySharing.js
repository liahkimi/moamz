const sharingPossibility = document.getElementById('sharing-possibility-btn');
const sharingReservation = document.getElementById('sharing-reservation-btn');
const sharingDone = document.getElementById('sharing-done-btn');
const sharingPossibilityList = document.querySelector('.sharing-possibility-list');
const sharingReservationList = document.querySelector('.sharing-reservation-list');
const sharingDoneList = document.querySelector('.sharing-done-list');

// 예약중으로 변경 버튼
const changeReservationBtn = document.querySelectorAll('.reservation-state');
// 나눔완료로 변경 버튼
const sharingDoneBtn = document.querySelectorAll('.sharing-done');

//나눔가능 메뉴 눌렀을 때
sharingPossibility.addEventListener('click', () => {
    sharingPossibility.classList.add('active');
    sharingReservation.classList.remove('active');
    sharingDone.classList.remove('active');
    sharingPossibilityList.classList.remove('hidden');
    sharingReservationList.classList.add('hidden');
    sharingDoneList.classList.add('hidden');
});

//예약중 메뉴 눌렀을 때
sharingReservation.addEventListener('click', () => {
    sharingPossibility.classList.remove('active');
    sharingReservation.classList.add('active');
    sharingDone.classList.remove('active');
    sharingPossibilityList.classList.add('hidden');
    sharingReservationList.classList.remove('hidden');
    sharingDoneList.classList.add('hidden');
});

//나눔완료 메뉴 눌렀을 때
sharingDone.addEventListener('click', () => {
    sharingPossibility.classList.remove('active');
    sharingReservation.classList.remove('active');
    sharingDone.classList.add('active');
    sharingPossibilityList.classList.add('hidden');
    sharingReservationList.classList.add('hidden');
    sharingDoneList.classList.remove('hidden');
});

// 예약중으로 변경 버튼
changeReservationBtn.forEach(btn => {
    btn.addEventListener('click', function() {
        const isConfirm = confirm("'예약중' 상태로 변경하시겠습니까?");
        if (isConfirm) {
            //상태변경
        } else {
        }
    });
});

// 나눔완료로 변경 버튼
sharingDoneBtn.forEach(btn => {
    btn.addEventListener('click', function() {
        const isConfirm = confirm("'나눔완료' 상태로 변경하시겠습니까?");
        if (isConfirm) {
            //상태변경
        } else {
        }
    });
});