// const counters = document.querySelectorAll(".cart-product-count-btn");
//
// counters.forEach(counter => {
//     let count = 3; // 초기 카운트 설정
//     const countDisplay = counter.querySelectorAll(".count");
//     const incrementButton = counter.querySelectorAll(".inc");
//     const decrementButton = counter.querySelectorAll(".dec");
//
//     // 초기 카운트 표시 설정
//     countDisplay[0].textContent = count;
//     // 증가 버튼 클릭 이벤트
//     incrementButton.forEach(function (inc) {
//         inc.addEventListener('click', () => {
//             console.log("12");
//             countDisplay.forEach(function (quantity) {
//                 count += 1;
//                 quantity.textContent = count;
//             })
//         })
//     })
// });
// incrementButton.addEventListener("click", () => {
//     count += 1;
//     countDisplay.textContent = count;
// });

// 감소 버튼 클릭 이벤트
//     decrementButton.addEventListener("click", () => {
//         if (count > 1) {
//             count -= 1;
//             countDisplay.textContent = count;
//         } else {
//             alert("수량은 1 이하로 설정할 수 없습니다."); // 경고창 표시
//         }
//     });
// });
const counters = document.getElementsByClassName("cart-product-count-btn");

Array.from(counters).forEach(counter => {
    let count = 1; // 초기 카운트 설정
    const countDisplay = counter.getElementsByClassName("cart-product-count-num"); // 카운트 표시 선택
    const incrementButton = counter.getElementsByClassName("inc"); // 증가 버튼 선택
    const decrementButton = counter.getElementsByClassName("dec"); // 감소 버튼 선택

    // countDisplay, incrementButton, decrementButton이 올바르게 선택되었는지 확인
    if (countDisplay.length > 0 && incrementButton.length > 0 && decrementButton.length > 0) {
        // 초기 카운트 표시 설정
        countDisplay[0].textContent = count; // 첫 번째 카운트 표시

        // 증가 버튼 클릭 이벤트
        incrementButton[0].addEventListener("click", () => {
            count += 1;
            countDisplay[0].textContent = count; // 카운트 표시 업데이트
        });

        // 감소 버튼 클릭 이벤트
        decrementButton[0].addEventListener("click", () => {
            if (count > 1) {
                count -= 1;
                countDisplay[0].textContent = count; // 카운트 표시 업데이트
            } else {
                alert("수량은 1 이하로 설정할 수 없습니다."); // 경고창 표시
            }
        });
    } else {
        console.error("요소를 찾을 수 없습니다.");
    }
});

const deleteBtn = document.querySelectorAll('.cart-delete');

deleteBtn.forEach((e) => {
    e.addEventListener('click', () => {
        const isConfirmed = confirm("삭제할까요?");
        if (isConfirmed) {
            const fgCartDetailId = e.getAttribute('data-cart-detail-id');

            fetch(`http://localhost:9999/shop/cart/delete/${fgCartDetailId}`, {
                method: 'DELETE',
            })
                .then(response => {
                    if (response.ok) {
                        alert("삭제 완료");
                        location.reload(); // 페이지 새로고침
                    } else {
                        alert("삭제 실패");
                    }
                });
        }
    });
});
