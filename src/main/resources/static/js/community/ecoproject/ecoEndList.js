let onGoingBtn = document.getElementById('ongoing-eco__btn');
let endBtn = document.getElementById('finished-eco__btn');
let onGoingDiv = document.getElementById('ongoing-eco');
let endDiv = document.getElementById('finished-eco');
let onGoingPage = document.getElementById('ongoing-page');  // 진행중 페이지네이션
let endPage = document.getElementById('end-page');  // 완료 페이지네이션

onGoingBtn.addEventListener('click', () => {
    // 진행중 페이지와 페이지네이션 보이기
    onGoingDiv.style.display = 'block';
    onGoingPage.style.display = 'block';  // 진행중 페이지네이션 보이기
    endDiv.style.display = 'none';
    endPage.style.display = 'none';  // 완료 페이지네이션 숨기기

    // 버튼 스타일 변경
    onGoingBtn.classList.add('active-btn');
    endBtn.classList.remove('active-btn');

    // 추가 클래스 토글
    onGoingDiv.classList.remove('banner-hidden');
    endDiv.classList.add('banner-hidden');
});

endBtn.addEventListener('click', () => {
    // 완료 페이지와 페이지네이션 보이기
    endDiv.style.display = 'block';
    endPage.style.display = 'block';  // 완료 페이지네이션 보이기
    onGoingDiv.style.display = 'none';
    onGoingPage.style.display = 'none';  // 진행중 페이지네이션 숨기기

    // 버튼 스타일 변경
    endBtn.classList.add('active-btn');
    onGoingBtn.classList.remove('active-btn');

    // 추가 클래스 토글
    endDiv.classList.remove('banner-hidden');
    onGoingDiv.classList.add('banner-hidden');
});
