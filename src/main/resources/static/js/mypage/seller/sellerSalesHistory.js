const productReadyMenu = document.getElementById('product-ready-btn');
const readyToPickupMenu = document.getElementById('product-pickup-btn');
const pickupCompleteMenu = document.getElementById('product-completed-btn');
const productReadyList = document.getElementById('product-ready-list');
const readyToPickupList = document.getElementById('product-pickup-list');
const pickupCompleteList = document.getElementById('product-completed-list');

// 상품준비완료 버튼
const readyCompleteBtn = document.querySelectorAll('.ready-complete-btn');
// 고객픽업완료 버튼
const pickupCompleteBtn = document.querySelectorAll('.pickup-complete-btn');


//상품준비 메뉴 눌렀을 때
productReadyMenu.addEventListener('click', () => {
    productReadyMenu.classList.add('active');
    readyToPickupMenu.classList.remove('active');
    pickupCompleteMenu.classList.remove('active');
    productReadyList.classList.remove('hidden');
    readyToPickupList.classList.add('hidden');
    pickupCompleteList.classList.add('hidden');
});

//픽업대기 메뉴 눌렀을 때
readyToPickupMenu.addEventListener('click', () => {
    productReadyMenu.classList.remove('active');
    readyToPickupMenu.classList.add('active');
    pickupCompleteMenu.classList.remove('active');
    productReadyList.classList.add('hidden');
    readyToPickupList.classList.remove('hidden');
    pickupCompleteList.classList.add('hidden');
});

//픽업완료 메뉴 눌렀을 때
pickupCompleteMenu.addEventListener('click', () => {
    productReadyMenu.classList.remove('active');
    readyToPickupMenu.classList.remove('active');
    pickupCompleteMenu.classList.add('active');
    productReadyList.classList.add('hidden');
    readyToPickupList.classList.add('hidden');
    pickupCompleteList.classList.remove('hidden');
});

// 상품 준비 완료 버튼
readyCompleteBtn.forEach(btn => {
    btn.addEventListener('click', function() {
        const isConfirm = confirm("'픽업대기중' 상태로 변경하시겠습니까?");
        if (isConfirm) {
            //상태변경
        } else {
        }
    });
});

// 고객 픽업 완료 버튼
pickupCompleteBtn.forEach(btn => {
    btn.addEventListener('click', function() {
        const isConfirm = confirm("'픽업완료' 상태로 변경하시겠습니까?");
        if (isConfirm) {
            //상태변경
        } else {
        }
    });
});

// 페이지네이션..