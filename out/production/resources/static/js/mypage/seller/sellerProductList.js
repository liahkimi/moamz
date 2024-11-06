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

// 페이지 처음 로드했을 때 판매중인 상품 목록이 보여야 함
loadProductList('onSale');

// 상품 목록 비동기 처리 함수
function loadProductList(status) {
    // onSale 메뉴이면 ongoing-product-list
    // 아니면 completed-product-list에 목록 추가
    const productListContainer = document.getElementById(status === 'onSale'
        ? 'ongoing-product-list' : 'completed-product-list');

    // ajax 요청으로 상품 목록 가져오기
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

            // 컨트롤러에서 받아온 productListDTO를 DOM에 뿌리기
            // 판매 종료 버튼은 completed-product-list에만 보여야 한다.
            data.forEach(productListDTO => {
                const productElement = `
                    <li class="product-list" data-id="${productListDTO.productId}">
                        <div class="product-title-wrap">
                            <div class="product-name">${productListDTO.productName}</div>
                            <div class="btn-wrap">
                                ${status === 'onSale' ? `<button type="button" class="product-completed-btn">판매종료</button>` : ''}
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
                            <p class="move-to-detail" onclick="location.href='/seller/product/detail/${productListDTO.productId}'">자세히 보러가기 ></p>
                        </div>
                    </li>
                `;
                productListContainer.innerHTML += productElement;
            });
        })
        .catch(error => console.error('상품 목록을 가져오는 데 실패했습니다:', error));
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

