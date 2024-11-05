window.onload = function() {
    var mapContainer = document.getElementById('payment-map');
    if (mapContainer) {
        var mapOption = {
            center: new kakao.maps.LatLng(37.497, 127.036),
            level: 3
        };

        var map = new kakao.maps.Map(mapContainer, mapOption);
    } else {
        console.error('지도 없어요');
    }
};

document.addEventListener("DOMContentLoaded", () => {
    // 초기 카운트 설정
    let count = 1;
    const countDisplay = document.getElementById("counting");
    const incrementButton = document.getElementById("inc");
    const decrementButton = document.getElementById("dec");

    // 초기 카운트 표시 설정
    countDisplay.textContent = count;

    // 증가 버튼 클릭 이벤트
    incrementButton.addEventListener("click", () => {
        count += 1;
        countDisplay.textContent = count;
    });

    // 감소 버튼 클릭 이벤트
    decrementButton.addEventListener("click", () => {
        if (count > 1) {
            count -= 1;
            countDisplay.textContent = count;
        } else {
            alert("수량은 1 이하로 설정할 수 없습니다."); // 경고창 표시
        }
    });
});

