const salesCompleteBtn = document.getElementById('sales-complete-btn');
const productDeleteBtn = document.getElementById('product-delete-btn');
const productId = document.querySelector('.btn-container').getAttribute('data-id');
console.log(salesCompleteBtn);
console.log(productDeleteBtn);
console.log(productId);

//////////////////////////////////////////////////
///// 판매완료 처리 버튼

if(salesCompleteBtn) {
    salesCompleteBtn.addEventListener('click', () => {
        const isConfirm = confirm("'판매완료' 상태로 변경하시겠습니까?");
        if (isConfirm) {

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
                    // PATCH 요청이 수행되면 현재 화면을 새로고침 한다.
                    location.reload();
                })
                .catch(error => {
                    console.error('상품 상태 변경 실패:', error);
                    alert(`상품 상태 변경 실패: ${error.message}`);
                });


        }
    });
}

//////////////////////////////////////////////////
///// 상품 삭제 버튼

if(productDeleteBtn) {
    productDeleteBtn.addEventListener('click', () => {
        const isConfirm = confirm("상품을 삭제하시겠습니까?");
        if (isConfirm) {
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
                    // 상품 삭제 후 상품 목록으로 이동
                    location.href='/seller/product/list';
                })
                .catch(error => {
                    console.error('상품 상태 변경 실패:', error);
                    alert(`상품 상태 변경 실패: ${error.message}`);
                });

        }
    });
}

    
    