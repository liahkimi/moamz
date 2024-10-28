const ongoingMenu = document.getElementById('ongoing-menu');
const completedMenu = document.getElementById('completed-menu');
const ongoingList = document.getElementById('ongoing-list');
const completedList = document.getElementById('completed-list');
const productCompletedBtn = document.querySelectorAll('.product-completed-btn');
const productDeleteBtn = document.querySelectorAll('.product-delete-btn');

// 판매중 메뉴
ongoingMenu.addEventListener('click', () => {
    ongoingMenu.classList.add('active');
    completedMenu.classList.remove('active');
    ongoingList.classList.remove('hidden');
    completedList.classList.add('hidden');
});

// 판매완료 메뉴
completedMenu.addEventListener('click', () => {
    ongoingMenu.classList.remove('active');
    completedMenu.classList.add('active');
    ongoingList.classList.add('hidden');
    completedList.classList.remove('hidden');
});

// 판매완료 버튼
productCompletedBtn.forEach(btn => {
    btn.addEventListener('click', function() {
        const isConfirm = confirm("'판매완료' 상태로 변경하시겠습니까?");
        if (isConfirm) {
            //상태변경
        } else {
        }
    })
});

// 상품 삭제버튼
productDeleteBtn.forEach(btn => {
    btn.addEventListener('click', function() {
        const isConfirm = confirm("상품을 삭제하시겠습니까?");
        if (isConfirm) {
            //삭제
        } else {
        }
    })
});
