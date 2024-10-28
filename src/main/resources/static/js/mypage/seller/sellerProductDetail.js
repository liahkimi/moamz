const salesCompleteBtn = document.getElementById('sales-complete-btn');
const productDeleteBtn = document.getElementById('product-delete-btn');

// 판매완료 버튼
salesCompleteBtn.addEventListener('click', () => {
    const isConfirm = confirm("'판매완료' 상태로 변경하시겠습니까?");
    if (isConfirm) {
        //상태변경
        alert('변경되었습니다.');
    } else {
    }
});

// 상품 삭제버튼
productDeleteBtn.addEventListener('click', () => {
    const isConfirm = confirm("상품을 삭제하시겠습니까?");
    if (isConfirm) {
        //삭제
        alert('삭제되었습니다.');
        location.href='sellerProductList.html';
    } else {
    }
});
    
    
    