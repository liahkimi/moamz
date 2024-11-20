$(document).ready(function() {
    // .cart-product-count-btn 클래스에 대해 반복
    $(".cart-product-count-btn").each(function() {
        let count = 1; // 초기 카운트 설정

        const $countDisplay = $(this).find(".cart-product-count-num"); // 카운트 표시 선택
        const $incrementButton = $(this).find(".inc"); // 증가 버튼 선택
        const $decrementButton = $(this).find(".dec"); // 감소 버튼 선택
        const $productWeightDisplay = $(this).closest(".cart-product-detail-product").find(".cart-product-detail-product-intro-text-weight"); // 무게 표시 선택
        const $productPriceDisplay = $(this).closest(".cart-product-detail-product").find(".cart-product-detail-product-intro-text-price"); // 가격 표시 선택

        // data-* 속성 값 가져오기
        let productWeight = parseFloat($productWeightDisplay.data("fg-product-weight"));
        let productPrice = parseInt($productPriceDisplay.data("fg-product-price"));

        // 값이 올바르게 가져와졌는지 확인 (디버깅용)
        console.log('Weight:', productWeight);
        console.log('Price:', productPrice);

        // 초기 카운트, 무게, 가격 표시 설정
        updateCartDisplay(count);

        // 증가 버튼 클릭 이벤트
        $incrementButton.click(function() {
            count += 1;
            updateCartDisplay(count);  // 수량 증가 후 디스플레이 업데이트
        });

        // 감소 버튼 클릭 이벤트
        $decrementButton.click(function() {
            if (count > 1) {
                count -= 1;
                updateCartDisplay(count);  // 수량 감소 후 디스플레이 업데이트
            } else {
                alert("수량은 1 이하로 설정할 수 없습니다.");  // 경고창 표시
            }
        });

        // 카운트, 가격, 무게를 업데이트하는 함수
        function updateCartDisplay(count) {
            // 수량에 따른 무게, 가격 계산 후 업데이트
            const totalWeight = (productWeight * count).toFixed(2);  // 무게 계산
            const totalPrice = (productPrice * count).toLocaleString();  // 가격 계산 (천 단위 구분)

            // 화면에 표시
            $countDisplay.text(count);  // 카운트 표시 업데이트
            $productWeightDisplay.text(totalWeight + ' kg');  // 무게 업데이트
            $productPriceDisplay.text(totalPrice + '원');  // 가격 업데이트
        }
    });
});





// const deleteBtn = document.querySelectorAll('.cart-delete');

// 모든 삭제 버튼에 대해 클릭 이벤트 추가
$('.cart-delete').each(function () {
    let fgCartDetailId = $(this).data('fg-cart-detail-id'); // data-값 가져오기

    $(this).on('click', function () {
        let isConfirmed = confirm("삭제할까요?");
        if (isConfirmed) {
            console.log(fgCartDetailId); // 각 data- 값 출력

            $.ajax({
                url: `http://localhost:9999/shop/cart/delete/` + fgCartDetailId,
                type: 'DELETE',
                success: function () {
                    alert("삭제 완료");
                    location.reload(); // 페이지 새로고침
                },
                error: function () {
                    alert("삭제 실패");
                }
            });
        }
    });
});
