let productPics = document.querySelectorAll(".productList-product-product-box-pic");
let tocart = document.querySelectorAll(".tocart");

productPics.forEach(function (productPic) {
    productPic.addEventListener('mouseover', function () {
        tocart.forEach(function (e) {
            e.style.display = "block"; // 각 tocart 요소에 대해 설정
        });
    });

    productPic.addEventListener('mouseleave', function () {
        tocart.forEach(function (e) {
            e.style.display = "none"; // 각 tocart 요소에 대해 설정
        });
    });
});

const tocartButtons = document.querySelectorAll(".tocart");

tocartButtons.forEach(function (e) {
    e.addEventListener('click', () => {
        if (confirm('장바구니에 추가할까요?')) {
            const cartDetail = {
                fgCartDetailQuantity: 10, // 기본 수량
                // fgProductId: e.getAttribute('data-product-id'), // 버튼에 제품 ID가 있는 경우
                fgProductId:1,
                fgCartId: 1 // 현재 장바구니 ID (예시)
            };

            fetch('http://localhost:9999/shop/cart/add', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(cartDetail)
            })
                .then(response => {
                    if (response.ok) {
                        alert("장바구니에 추가 완료");
                    } else {
                        alert("장바구니 추가 실패");
                    }
                });
        } else {
            alert("취소");
        }
    });
});

