let currentSlideIndex = 0; // 현재 슬라이드 인덱스
const slides = document.querySelectorAll('.main-slider img'); // 모든 이미지 선택
const totalSlides = slides.length; // 전체 슬라이드 수
const slider = document.querySelector('.main-slider'); // 슬라이드 요소

// 오른쪽으로 이동 (다음 슬라이드)
function moveToNextSlide() {
    currentSlideIndex++; // 다음 슬라이드로 이동
    if (currentSlideIndex >= totalSlides) {
        currentSlideIndex = 0; // 마지막 슬라이드 이후에는 첫 번째 슬라이드로 돌아옴
    }
    updateSliderPosition();
}

// 왼쪽으로 이동 (이전 슬라이드)
function moveToPreviousSlide() {
    currentSlideIndex--; // 이전 슬라이드로 이동
    if (currentSlideIndex < 0) {
        currentSlideIndex = totalSlides - 1; // 첫 번째 슬라이드 이전에는 마지막 슬라이드로 돌아옴
    }
    updateSliderPosition();
}

// 슬라이더 위치 업데이트 함수
function updateSliderPosition() {
    // 슬라이더 이동 (각 슬라이드의 크기만큼 이동)
    slider.style.transform = `translateX(-${currentSlideIndex * 1000}px)`; // 슬라이드 이동
}
