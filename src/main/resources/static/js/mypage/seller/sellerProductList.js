const ongoingMenu = document.getElementById('ongoing-menu');
const completedMenu = document.getElementById('completed-menu');
const ongoingList = document.getElementById('ongoing-list');
const completedList = document.getElementById('completed-list');


///////////////////////////////////////////////////
//// 메뉴 스타일 고정

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





///////////////////////////////////////////////////
//// 상품 목록 불러오기 비동기 처리

// 현재 페이지, 상품 상태 초기화
let currentPage = 1;
let currentStatus = 'onSale';

// 초기 상품 목록 로드
loadProductList('onSale');

//
// 상품 목록 로드 함수 (페이지 지정을 하지 않을 경우 default = 1)
//
function loadProductList(status, page = 1) {
    currentPage = page;
    currentStatus = status;

    // 페이지네이션을 포함한 상품 목록 요청
    fetch(`/api/seller/product/list?status=${status}&page=${page}`, {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' },    // 요청 헤더에 json 타입 설정
    })
        .then(response => response.json())
        .then(data => {
            // 상품 상태(status 변수 의 값)에 따라
            // 보여질 상품 목록 컨테이너를 동적으로 결정한다.
            const productListContainer = document.getElementById(status === 'onSale' ? 'ongoing-product-list' : 'completed-product-list');

            // 상품 목록 초기화
            productListContainer.innerHTML = ``;

            // 각 상품을 html 요소로 생성한다.
            data.productListDTO.forEach(product => {
                const productElement = `
                <li class="product-list">
                    <div class="product-title-wrap">
                        <div class="product-name">${product.productName}</div>
                        <div class="btn-wrap">
                            ${status === 'onSale' ? `<button type="button" class="product-completed-btn">판매종료</button>` : ''}
                            <button type="button" class="product-delete-btn">삭제</button>
                        </div>
                    </div>
                    <div class="product-info-wrap">
                        <div class="product-item-img" style="background-image: url(/upload_moamz/${product.productFileRoot}/${product.productFileUuid}_${product.productFileName});"></div>
                        <div class="product-detail-wrap">
                            <div class="product-item"><p class="product-label">카테고리</p><p>${product.categoryId}</p></div>
                            <div class="product-item"><p class="product-label">상품가격</p><span>${product.productPrice}</span>원</div>
                            <div class="product-item"><p class="product-label">등록수량</p><span>${product.productStock}</span></div>
                            <div class="product-item"><p class="product-label">중량</p><span>${product.productWeight}</span>g</div>
                            <div class="product-item"><p class="product-label">소비기한</p><span>${product.productExpDate}</span></div>
                        </div>
                    </div>
                </li>`;
                productListContainer.innerHTML += productElement;
            });

            // 페이지네이션 정보를 업데이트하는 함수 호출
            updatePagination(data.page);
        })
        .catch(error => {
            console.error('상품 목록 로딩 실패:', error);
        });
}

//
// 페이지네이션 업데이트 함수
function updatePagination(page) {
    // 페이지네이션 컨테이너
    const paginationContainer = document.getElementById('pagination');
    // 페이지네이션 초기화
    paginationContainer.innerHTML = '';

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
        prevPage.onclick = () => loadProductList(currentStatus, page.startPage - 1);

        // 이전 페이지 버튼 생성
        const prevButton = document.createElement('li');
        // li 태그에 클래스를 추가한다.
        prevButton.classList.add('page-number');

        // 생성한 이전 페이지 링크를 li태그(버튼)에 추가한다.
        prevButton.appendChild(prevPage);

        // 페이지네이션 컨테이너에 이전 페이지 버튼을 추가한다.
        paginationContainer.appendChild(prevButton);
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
        pageLink.onclick = () => loadProductList(currentStatus, i);

        // 생성한 링크를 li태그(페이지 번호 버튼)에 추가
        pageItem.appendChild(pageLink);

        // 페이지네이션 컨테이너에 페이지 번호 추가
        paginationContainer.appendChild(pageItem);
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
        nextPage.onclick = () => loadProductList(currentStatus, page.endPage + 1);

        // 다음 페이지 버튼을 li 태그로 생성하고 클래스를 추가한다.
        const nextButton = document.createElement('li');
        nextButton.classList.add('page-number');

        // 다음 페이지 버튼에 링크를 추가한다.
        nextButton.appendChild(nextPage);

        // 페이지네이션 영역에 다음 페이지 버튼을 추가한다.
        paginationContainer.appendChild(nextButton);
    }
}




///////////////////////////////////////////////////
//// 상품 상태 변경 버튼 처리

// 동적으로 추가된 요소들은 해당 요소를 대상으로 이벤트 리스너를 설정해도 이벤트가 발생하지 않는다.
// 이벤트 위임으로 상위 요소를 찾아서 클릭 이벤트를 발생시키고,
// e.target이 상품 상태 변경버튼이거나 삭제버튼일 때 이벤트를 처리할 수 있다.

// 판매중인 상품 목록
document.getElementById('ongoing-product-list')
    .addEventListener('click', function(e) {
    if (e.target && e.target.classList.contains('product-completed-btn')) {
        const isConfirm = confirm("'판매종료' 상태로 변경하시겠습니까?");
        if (isConfirm) {

            //클릭된 요소의 data-id값(productId) 가져오기
            const productId = e.target.closest('.product-list').dataset.id;

            // 상품 상태 변경 요청
            // 일부만 업데이트 하는 경우 PATCH 요청
            fetch(`/api/seller/product/status/${productId}`, {
                method: 'PATCH',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => response.json())
                .then(data => {
                    alert("판매 종료되었습니다.");
                    // PATCH 요청이 수행되면 목록을 새로고침 한다.
                    loadProductList('onSale');
                })
                .catch(error => {
                    console.error('상품 상태 변경 실패:', error);
                    alert(`상품 상태 변경 실패: ${error.message}`);
                });
        }
    } else if (e.target && e.target.classList.contains('product-delete-btn')) {
        const isConfirm = confirm("상품을 삭제하시겠습니까?");
        if (isConfirm) {
            //클릭된 요소의 data-id값(productId) 가져오기
            const productId = e.target.closest('.product-list').dataset.id;

            // 상품 삭제 (DELETE 요청)
            fetch(`/api/seller/product/delete/${productId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => response.json())
                .then(data => {
                    alert("삭제되었습니다.");
                    // 상품 삭제 후 UI에서 해당 상품 항목 제거
                    e.target.closest('.product-list').remove();
                })
                .catch(error => {
                    console.error('상품 상태 변경 실패:', error);
                    alert(`상품 상태 변경 실패: ${error.message}`);
                });
        }
    }
});

document.getElementById('completed-product-list')
    .addEventListener('click', function(e) {
    if (e.target && e.target.classList.contains('product-delete-btn')) {
        const isConfirm = confirm("상품을 삭제하시겠습니까?");

        if (isConfirm) {
            //클릭된 요소의 data-id값(productId) 가져오기
            const productId = e.target.closest('.product-list').dataset.id;

            // 상품 삭제 (DELETE 요청)
            fetch(`/api/seller/product/delete/${productId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => response.json())
                .then(data => {
                    alert("삭제되었습니다.");
                    // 상품 삭제 후 UI에서 해당 상품 항목 제거
                    e.target.closest('.product-list').remove();
                })
                .catch(error => {
                    console.error('상품 상태 변경 실패:', error);
                    alert(`상품 상태 변경 실패: ${error.message}`);
                });
        }
    }
});

