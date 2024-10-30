/* 원래 코드 */
// 메뉴 클릭했을 때 css 고정
const menuItems = document.querySelectorAll('.menu-item a');

menuItems.forEach(item => {
    item.addEventListener('click', function() {
        // 나머지 태그에서 clicked 클래스 제거
        menuItems.forEach(item => {
            item.classList.remove('clicked');
        });
        // 클릭된 태그에 clicked 클래스 추가
        this.classList.add('clicked');
    })
});



/*
// 메뉴 클릭했을 때 css 고정
const menuItems = document.querySelectorAll('.menu-item a');

// 로컬 스토리지에서 마지막으로 클릭된 메뉴를 불러오기
const lastClicked = localStorage.getItem('clickedMenu');
    
if (lastClicked) {
    // 로컬 스토리지에 저장된 메뉴에 clicked 클래스 추가
    const activeMenu = document.querySelector(`.menu-item a[href="${lastClicked}"]`);
    if (activeMenu) {
        activeMenu.classList.add('clicked');
    }
}


menuItems.forEach(item => {
    item.addEventListener('click', function() {
        // 모든 메뉴에서 clicked 클래스 제거
        menuItems.forEach(item => {
            item.classList.remove('clicked');
        });
        // 클릭된 메뉴에 clicked 클래스 추가
        this.classList.add('clicked');
        
        // 로컬 스토리지에 클릭된 메뉴의 href 저장
        localStorage.setItem('clickedMenu', this.getAttribute('href'));
    });
});
*/