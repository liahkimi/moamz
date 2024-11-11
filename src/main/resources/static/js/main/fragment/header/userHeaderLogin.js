document.addEventListener('DOMContentLoaded', function () {
    const notificationIcon = document.querySelector('.btn-img:nth-child(4) img'); // 알림 아이콘
    const notificationDropdown = document.querySelector('.notification-dropdown'); // 알림창

    // 알림 아이콘을 클릭할 때 알림창 토글
    notificationIcon.addEventListener('click', function (event) {
        event.stopPropagation(); // 클릭 이벤트 전파를 막아서 알림창이 닫히지 않게 함
        notificationDropdown.classList.toggle('active');
    });

    // 알림창 외부를 클릭하면 알림창 닫기
    document.addEventListener('click', function (event) {
        if (!notificationDropdown.contains(event.target) && !notificationIcon.contains(event.target)) {
            notificationDropdown.classList.remove('active');
        }
    });
});


// -----------------------------------------------------------
const logoutBtn = document.getElementById("logout");

logoutBtn.addEventListener("click", () => {
    alert("로그아웃 되었습니다.");
});
