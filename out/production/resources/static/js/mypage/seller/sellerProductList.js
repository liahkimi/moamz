const ongoingMenu = document.getElementById('ongoing-menu');
const completedMenu = document.getElementById('completed-menu');
const ongoingList = document.getElementById('ongoing-list');
const completedList = document.getElementById('completed-list');
const productCompletedBtn = document.querySelectorAll('.product-completed-btn');
const productDeleteBtn = document.querySelectorAll('.product-delete-btn');

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
//// 상품 상태 변경 버튼 처리

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

///////////////////////////////////////////////////
//// 상품 목록 불러오기 비동기 처리

// 페이지 처음 로드했을 때 판매중인 상품 목록이 보여야 함
loadProductList('onSale');

function loadProductList(status) {
    // onSale 메뉴이면 ongoing-product-list, 아니면 completed-product-list에 목록 추가
    const productListContainer = document.getElementById(status === 'onSale'
        ? 'ongoing-product-list' : 'completed-product-list');

    // Ajax 요청으로 상품 목록 가져오기
    fetch(`/api/seller/product/list?status=${status}`, {
        method: 'GET',
        headers: { 'Content-Type': 'application/json', },
    })
        .then(response => {
            // 네트워크 응답상태 확인
            if (!response.ok) {
                throw new Error('❌❌❌❌❌네트워크 응답 에러');
            }
            return response.json();
        })
        .then(data => {
            // 기존 목록 초기화
            productListContainer.innerHTML = '';

            // 서버에서 받아온 상품 목록을 DOM에 추가
            data.forEach(productListDTO => {
                const productElement = `
                    <li class="product-list">
                        <div class="product-title-wrap">
                            <div class="product-name">${productListDTO.productName}</div>
                            <div class="btn-wrap">
                                ${status === 'onSale' ? `<button type="button" class="product-completed-btn">판매완료</button>` : ''}
                                <button type="button" class="product-delete-btn">삭제</button>
                            </div>
                        </div>
                        <div class="product-info-wrap">
                            <div class="product-item-img" style="background-image: url(/upload_moamz/${productListDTO.productFileRoot}/${productListDTO.productFileUuid}_${productListDTO.productFileName});"></div>
                            <div class="product-detail-wrap">
                                <div class="product-item">
                                    <p class="product-label">카테고리</p>
                                    <p>${productListDTO.categoryId}</p>
                                </div>
                                <div class="product-item">
                                    <p class="product-label">상품가격</p>
                                    <span>${productListDTO.productPrice}</span>원
                                </div>
                                <div class="product-item">
                                    <p class="product-label">등록수량</p>
                                    <span>${productListDTO.productStock}</span>
                                </div>
                                <div class="product-item">
                                    <p class="product-label">중량</p>
                                    <span>${productListDTO.productWeight}</span>g
                                </div>
                                <div class="product-item">
                                    <p class="product-label">소비기한</p>
                                    <span>${productListDTO.productExpDate}</span>까지
                                </div>
                                <div class="product-item">
                                    <p class="product-label">상품등록일</p>
                                    <span>${productListDTO.productTime}</span>
                                </div>
                            </div>
                            <div>
                                <div class="product-item">
                                    <p class="product-label">상품상세</p>
                                    <span class="product-detail">${productListDTO.productContent}</span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <p class="move-to-detail" onclick="location.href='sellerProductDetail.html'">자세히 보러가기 ></p>
                        </div>
                    </li>
                `;
                productListContainer.innerHTML += productElement;
            });
        })
        .catch(error => console.error('상품 목록을 가져오는 데 실패했습니다:', error));
}

