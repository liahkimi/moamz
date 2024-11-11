// 슬라이드 이미지 배열
const images = [
    "/img/main/main/mainPage.png",
    "/img/main/main/mainPage2.png"
];

let currentIndex = 0;

// 슬라이드 이미지 변경 함수
function changeSlide() {
    const slider = document.querySelector('.main-slider');
    slider.style.transform = `translateX(-${currentIndex * 100}%)`;

    // 버튼 텍스트 변경
    const mainBtn = document.getElementById('mainBtn');
    console.log('현재 인덱스:', currentIndex); // 현재 인덱스를 확인하기 위해 콘솔에 출력
    if (currentIndex === 0) {
        mainBtn.textContent = "우리 동네 상품 보러가기 →";
        mainBtn.setAttribute('data-href', '/shop/list'); // 상품페이지로 이동
    } else {
        mainBtn.textContent = "커뮤니티로 이동 →";
        mainBtn.setAttribute('data-href', '/ecoproject/projectList'); // 커뮤니티 페이지로 이동
    }
}

// 왼쪽 버튼 클릭 시 이전 슬라이드로 이동 (두 번째 이미지만 활성화)
function prevSlide() {
    if (currentIndex === 1) { // 두 번째 이미지일 때만 왼쪽 버튼 작동
        currentIndex = (currentIndex - 1 + images.length) % images.length; // 인덱스를 순환
        changeSlide();
    }
}

// 오른쪽 버튼 클릭 시 다음 슬라이드로 이동 (첫 번째 이미지일 때만 활성화)
function nextSlide() {
    if (currentIndex === 0) { // 첫 번째 이미지일 때만 오른쪽 버튼 작동
        currentIndex = (currentIndex + 1) % images.length; // 인덱스를 순환
        changeSlide();
    }
}

// 버튼 클릭 시 경로 이동 처리
function handleButtonClick() {
    const mainBtn = document.getElementById('mainBtn');
    const targetHref = mainBtn.getAttribute('data-href'); // 버튼에 설정된 data-href 속성값을 가져옴
    location.href = targetHref; // 해당 경로로 이동
}

// 초기 페이지 로드 시, 첫 번째 이미지로 설정하고 버튼 텍스트 초기화
document.addEventListener('DOMContentLoaded', function() {
    changeSlide();
});





// 레시피
