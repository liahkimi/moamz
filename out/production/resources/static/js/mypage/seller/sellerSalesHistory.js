// 주문확인, 픽업대기, 픽업완료 메뉴 버튼
const productReadyMenu = document.getElementById('product-ready-btn');
const readyToPickupMenu = document.getElementById('product-pickup-btn');
const pickupCompleteMenu = document.getElementById('product-completed-btn');

// 판매 목록
const productReadyList = document.getElementById('product-ready-list');
const readyToPickupList = document.getElementById('product-pickup-list');
const pickupCompleteList = document.getElementById('product-completed-list');

// 상품준비완료 버튼
const readyCompleteBtn = document.querySelectorAll('.ready-complete-btn');
// 고객픽업완료 버튼
const pickupCompleteBtn = document.querySelectorAll('.pickup-complete-btn');

// 페이지네이션 ul 태그
const pageContainer = document.getElementById('pagination');

// 현재 페이지, 게시글 상태 초기화
let currentPage = 1;
let currentStatus = 'ready';

// 초기 화면에서 주문확인중 내역 로드
loadSalesList('ready', 1);




/////////////////////////////////////////////////////
//// 픽업 상태별 판매내역 로드하는 함수

function loadSalesList(status, page = 1) {

    currentPage = page;
    currentStatus = status;


    // 페이지네이션을 포함한 판매 내역 요청
    fetch(`/api/seller/sales/list?status=${status}&page=${page}`, {
        method: 'GET'
    }).then(response => response.json())
        .then(data => {
            // 응답 결과 객체를 비구조화 할당
            const {salesList, page} = data;

            // 픽업 상태에 맞는 컨테이너 설정하기
            const listContainer = document.getElementById(`product-${status}-list`);

            // 판매 내역을 뿌려줄 ul 태그 선택
            const listContainerUl = listContainer.querySelector('ul');

            // 목록 초기화
            listContainerUl.innerHTML = ``;

            // 가져온 판매 내역을 html 요소로 생성한다.
            salesList.forEach(list => {

                // 픽업 상태에 따라 보여줄 버튼
                let pickupBtn = '';
                if(status === 'ready') {
                    pickupBtn = `<button type="button" class="ready-complete-btn">상품 준비 완료</button>`;
                } else if (status === 'pickup') {
                    pickupBtn = `<button type="button" class="pickup-complete-btn">고객 픽업 완료</button>`;
                }

                // 픽업 상태에 따라 픽업예정시간, 픽업완료시간을 보여줌
                let timeWrapHtml = '';
                if(status === 'completed') {
                    timeWrapHtml = `
                        <div class="time-wrap">
                            <p class="list-title">픽업완료시간</p>
                            <p>${list.pickupCompleteTime}</p>
                        </div>
                    `;
                } else {
                    timeWrapHtml = `
                        <div class="time-wrap">
                            <p class="list-title">픽업예정시간</p>
                            <p>${list.pickupSchedule}</p>
                        </div>
                    `;
                }

                // html 요소 생성
                const listElement = `
                    <li class="product-list" data-id="${list.orderId}">
                        <div class="order-info">
                            <span class="order-time">${list.orderDate}</span>
                            ${pickupBtn}
                        </div>
                        <div class="product-info">
                            <!-- 상품이미지 -->
                            <div class="product-item-img"
                                 style="background-image: url('/upload_moamz/${list.productFileRoot}/${list.productFileUuid}_${list.productFileName}');">
                            </div>
                            <div class="product-wrap">
                                <p class="list-title">${list.productName}</p>
                                <span>${list.orderPerPrice}</span>원
                            </div>
                            ${timeWrapHtml}
                            <div class="nickname-wrap">
                                <p class="list-title">고객명</p>
                                <p>${list.normalNickname}</p>
                            </div>
                            <div class="request-wrap">
                                <p class="list-title">요청사항</p>
                                <p>${list.pickupRequest}</p>
                            </div>
                        </div>
                        <div>
                            <p class="move-to-detail" onclick="location.href='/seller/sales/detail/${list.orderId}'">자세히 보러가기 ></p>
                        </div>
                    </li>
                `;

                // 생성한 html 태그를 ul 태그에 추가한다.
                listContainerUl.innerHTML += listElement;

            }); // forEach 끝


            // 모든 판매내역 숨기기
            productReadyList.classList.add('hidden');
            readyToPickupList.classList.add('hidden');
            pickupCompleteList.classList.add('hidden');

            // 요청이 들어온 판매내역 목록만 보여주기
            listContainer.classList.remove('hidden');

            // 페이지네이션 업데이트
            updatePagination(page);
        });
}





/////////////////////////////////////////////////////
//// 페이지네이션 초기화 함수

function updatePagination(page) {
    // 페이지네이션 컨테이너 초기화
    pageContainer.innerHTML = '';

    // 이전 페이지 버튼
    if (page.prev) {    // 이전 페이지가 존재하는 경우
        // a 태그(이전 페이지 링크)를 생성하고 링크 주소를 #으로 설정한다.
        const prevPage = document.createElement('a');
        prevPage.href = '#';

        // a 태그에 클래스를 추가한다.
        prevPage.classList.add('page-a');

        // < 값 설정
        prevPage.innerHTML = `&lt;`;

        // 이전 페이지 버튼을 클릭했을 때 로드할 페이지 지정
        prevPage.onclick = () => loadSalesList(currentStatus, page.startPage - 1);

        // 이전 페이지 버튼 생성
        const prevButton = document.createElement('li');
        // li 태그에 클래스를 추가한다.
        prevButton.classList.add('page-number');

        // 생성한 이전 페이지 링크를 li태그(버튼)에 추가한다.
        prevButton.appendChild(prevPage);

        // 페이지네이션 컨테이너에 이전 페이지 버튼을 추가한다.
        pageContainer.appendChild(prevButton);
    }

    // 페이지 번호 생성 (시작페이지 ~ 끝페이지를 반복)
    for (let i = page.startPage; i <= page.endPage; i++) {
        // 각 페이지 번호를 표시하는 li태그 생성하고 클래스 지정하기
        const pageItem = document.createElement('li');
        pageItem.classList.add('page-number');

        // 페이지 번호 링크 설정하고 링크 주소를 #으로 설정
        const pageLink = document.createElement('a');
        pageLink.href = '#';
        pageLink.classList.add('page-a');

        // 현재 페이지일 때 active 클래스 설정
        if (i === page.criteria.page) {
            pageLink.classList.add('active');
        }


        // 페이지 번호를 나타내는 텍스트
        pageLink.textContent = i;

        // 각 페이지를 표시하는 li클래스를 클릭했을 때 보여줄 페이지 설정
        pageLink.onclick = () => loadSalesList(currentStatus, i);

        // 생성한 링크를 li태그(페이지 번호 버튼)에 추가
        pageItem.appendChild(pageLink);

        // 페이지네이션 컨테이너에 페이지 번호 추가
        pageContainer.appendChild(pageItem);
    }

    // 다음 페이지 버튼
    if (page.next) {    // 다음 페이지가 존재하는 경우
        // 다음 페이지 링크를 생성하고 링크 주소를 #으로 설정한다.
        const nextPage = document.createElement('a');
        nextPage.href = '#';

        // a태그에 클래스 추가
        nextPage.classList.add('page-a');

        // < 값 설정
        nextPage.innerHTML = `&gt;`;

        // 다음 페이지 버튼을 클릭했을 때 보여줄 페이지 지정
        nextPage.onclick = () => loadSalesList(currentStatus, page.endPage + 1);

        // 다음 페이지 버튼을 li 태그로 생성하고 클래스를 추가한다.
        const nextButton = document.createElement('li');
        nextButton.classList.add('page-number');

        // 다음 페이지 버튼에 링크를 추가한다.
        nextButton.appendChild(nextPage);

        // 페이지네이션 영역에 다음 페이지 버튼을 추가한다.
        pageContainer.appendChild(nextButton);
    }
}





/////////////////////////////////////////////////////
//// 메뉴 버튼 활성화 함수

function setActiveBtn(btn) {
    // 모든 메뉴에서 active 클래스 제거
    productReadyMenu.classList.remove('active');
    readyToPickupMenu.classList.remove('active');
    pickupCompleteMenu.classList.remove('active');

    // 요청이 들어온 버튼만 active 클래스 추가
    btn.classList.add('active');
}





/////////////////////////////////////////////////////
//// 픽업상태 메뉴를 클릭했을 때 이벤트 처리

// 주문확인 메뉴 눌렀을 때
productReadyMenu.addEventListener('click', () => {
    loadSalesList('ready', 1);
    setActiveBtn(productReadyMenu);
});

// 픽업대기 메뉴 눌렀을 때
readyToPickupMenu.addEventListener('click', () => {
    loadSalesList('pickup', 1);
    setActiveBtn(readyToPickupMenu);
});

// 픽업완료 메뉴 눌렀을 때
pickupCompleteMenu.addEventListener('click', () => {
    loadSalesList('completed', 1);
    setActiveBtn(pickupCompleteMenu);
});






/////////////////////////////////////////////////////
//// 주문확인중 -> 픽업대기중 상태로 변경

productReadyList.addEventListener('click', (e) => {
    if(e.target && e.target.classList.contains('ready-complete-btn')) {
        const isConfirm = confirm("'픽업대기중' 상태로 변경하시겠습니까?");

        if(isConfirm) {
            // 클릭된 요소의 data-id값(productId) 가져오기
            const orderId = e.target.closest('.product-list').dataset.id;

            // 픽업 상태 변경 요청
            fetch(`/api/seller/sales/updateReady/${orderId}`, {
                method: 'PATCH'
            }).then(response => {
                if(response.ok) {
                    alert('변경되었습니다.');
                    // 변경 후 목록 새고로침
                    loadSalesList(currentStatus, currentPage);
                } else {
                    console.log('상품 상태 변경 실패 : ', response.error);
                }
            });
        }
    }
});



/////////////////////////////////////////////////////
//// 픽업대기중 -> 픽업완료 상태로 변경

readyToPickupList.addEventListener('click', (e) => {
    if(e.target && e.target.classList.contains('pickup-complete-btn')) {
        const isConfirm = confirm("'픽업완료' 상태로 변경하시겠습니까?");

        if(isConfirm) {
            // 클릭된 요소의 data-id값(productId) 가져오기
            const orderId = e.target.closest('.product-list').dataset.id;

            // 픽업 상태 변경 요청
            fetch(`/api/seller/sales/updatePickup/${orderId}`, {
                method: 'PATCH'
            }).then(response => {
                if(response.ok) {
                    alert('변경되었습니다.');
                    // 변경 후 목록 새고로침
                    loadSalesList(currentStatus, currentPage);
                } else {
                    console.log('상품 상태 변경 실패 : ', response.error);
                }
            });
        }
    }
});

