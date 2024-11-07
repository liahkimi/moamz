// 현재 페이지 URL 경로를 가져옴
const currentUrl = window.location.pathname;

// 모든 메뉴 항목을 선택
const menuItems = document.querySelectorAll('.menu-item a');

// 각 메뉴 항목을 순회하면서 현재 URL과 일치하는 경우 `active` 클래스를 추가
menuItems.forEach(link => {
    // 메뉴 항목의 href 속성값을 가져옴
    const linkUrl = link.getAttribute('href');

    // 현재 URL이 링크 URL과 일치하면 'active' 클래스를 추가
    if (currentUrl === linkUrl) {
        link.parentElement.classList.add('active');
    }

    // 클릭 이벤트 추가
    link.addEventListener('click', () => {
        // 모든 메뉴 항목에서 'active' 클래스 제거
        menuItems.forEach(item => item.parentElement.classList.remove('active'));

        // 클릭한 항목에 'active' 클래스 추가
        link.parentElement.classList.add('active');
    });
});