const productReadyMenu = document.getElementById('product-ready-btn');
const readyToPickupMenu = document.getElementById('product-pickup-btn');
const pickupCompleteMenu = document.getElementById('product-completed-btn');
const productReadyList = document.getElementById('product-ready-list');
const readyToPickupList = document.getElementById('product-pickup-list');
const pickupCompleteList = document.getElementById('product-completed-list');

const readyCompleteBtn = document.querySelectorAll('.ready-complete-btn'); // 상품준비완료 버튼
const pickupCompleteBtn = document.querySelectorAll('.pickup-complete-btn'); // 고객픽업완료 버튼


/////////////////////////////////////////////////////
//// 상품 준비상태에 따라 알맞은 목록 보여주기

function showList(status) {
    // 모든 리스트 숨기기
    productReadyList.classList.add("hidden");
    readyToPickupList.classList.add("hidden");
    pickupCompleteList.classList.add("hidden");

    // 모든 active 스타일 숨기기
    productReadyMenu.classList.remove("active");
    readyToPickupMenu.classList.remove("active");
    pickupCompleteMenu.classList.remove("active");

    // status에 따라 알맞은 목록 보여주기
    if (status === 'ready') {
        productReadyList.classList.remove("hidden");
        productReadyMenu.classList.add("active");
    } else if (status === 'pickup') {
        readyToPickupList.classList.remove("hidden");
        readyToPickupMenu.classList.add("active");
    } else if (status === 'completed') {
        pickupCompleteList.classList.remove("hidden");
        pickupCompleteMenu.classList.add("active");
    }
}




/////////////////////////////////////////////////////
//// 주문확인중 -> 픽업대기중 상태로 변경

readyCompleteBtn.forEach(btn => {
    btn.addEventListener('click', function() {

        const isConfirm = confirm("'픽업대기중' 상태로 변경하시겠습니까?");

        if (isConfirm) {
            // orderId값 가져오기
            const orderId = btn.closest('li').getAttribute('data-id');
            console.log(orderId);

            // 상태 변경 fetch 요청
            fetch(`/seller/sales/updateReady/${orderId}`, {
                method: 'POST'
            }).then(response => {
                if (response.ok) {
                    alert('변경되었습니다.');
                    location.reload();
                }
            });

        }
    }); // addEventListener 끝
}); // forEach 끝




/////////////////////////////////////////////////////
//// 픽업대기중 -> 픽업완료 상태로 변경

pickupCompleteBtn.forEach(btn => {
    btn.addEventListener('click', function() {

        const isConfirm = confirm("'픽업완료' 상태로 변경하시겠습니까?");

        if (isConfirm) {
            // orderId값 가져오기
            const orderId = btn.closest('li').getAttribute('data-id');
            console.log(orderId);

            // 상태변경 fetch 요청
            fetch(`/seller/sales/updatePickup/${orderId}`, {
                method: 'POST'
            }).then(response => {
                if (response.ok) {
                    alert('변경되었습니다.');
                    location.reload();
                }
            });

        }
    }); // addEventListener 끝
}); // forEach 끝

// 페이지네이션..