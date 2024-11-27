// const eatTogetherBtn = document.getElementById('eat-together-btn');
// const goTogetherBtn = document.getElementById('go-together-btn');
// const volunteerBtn = document.getElementById('volunteer-btn');
// const hobbyBtn = document.getElementById('hobby-btn');
// const activityBtn = document.getElementById('activity-btn');
// const improvementBtn =document.getElementById('improvement-btn');
// const challengeBtn = document.getElementById('challenge-btn');
//
// const eatTogetherList = document.getElementById('eat-together-list');
// const goTogetherList= document.getElementById('go-together-list');
// const volunteerList = document.getElementById('volunteer-list');
// const hobbyList=document.getElementById('hobby-list');
// const activityList = document.getElementById('activity-list');
// const improvementList = document.getElementById('improvement-list');
// const challengeList = document.getElementById('challenge-list');
//
// const searchBtn = document.querySelector('.search-btn');
//
// eatTogetherBtn.addEventListener('click',()=>{
//     eatTogetherBtn.classList.add('active');
//     goTogetherBtn.classList.remove('active');
//     volunteerBtn.classList.remove('active');
//     hobbyBtn.classList.remove('active');
//     activityBtn.classList.remove('active');
//     improvementBtn.classList.remove('active');
//     challengeBtn.classList.remove('active');
//
//     eatTogetherList.classList.remove('hidden');
//     goTogetherList.classList.add('hidden');
//     volunteerList.classList.add('hidden');
//     hobbyList.classList.add('hidden');
//     activityList.classList.add('hidden');
//     improvementList.classList.add('hidden');
//     challengeList.classList.add('hidden');
//
// });
//
// goTogetherBtn.addEventListener('click',()=>{
//     eatTogetherBtn.classList.remove('active');
//     goTogetherBtn.classList.add('active');
//     volunteerBtn.classList.remove('active');
//     hobbyBtn.classList.remove('active');
//     activityBtn.classList.remove('active');
//     improvementBtn.classList.remove('active');
//     challengeBtn.classList.remove('active');
//
//     eatTogetherList.classList.add('hidden');
//     goTogetherList.classList.remove('hidden');
//     volunteerList.classList.add('hidden');
//     hobbyList.classList.add('hidden');
//     activityList.classList.add('hidden');
//     improvementList.classList.add('hidden');
//     challengeList.classList.add('hidden');
//
// });
// volunteerBtn.addEventListener('click',()=>{
//     eatTogetherBtn.classList.remove('active');
//     goTogetherBtn.classList.remove('active');
//     volunteerBtn.classList.add('active');
//     hobbyBtn.classList.remove('active');
//     activityBtn.classList.remove('active');
//     improvementBtn.classList.remove('active');
//     challengeBtn.classList.remove('active');
//
//     eatTogetherList.classList.add('hidden');
//     goTogetherList.classList.add('hidden');
//     volunteerList.classList.remove('hidden');
//     hobbyList.classList.add('hidden');
//     activityList.classList.add('hidden');
//     improvementList.classList.add('hidden');
//     challengeList.classList.add('hidden');
//
// });
// hobbyBtn.addEventListener('click',()=>{
//     eatTogetherBtn.classList.remove('active');
//     goTogetherBtn.classList.remove('active');
//     volunteerBtn.classList.remove('active');
//     hobbyBtn.classList.add('active');
//     activityBtn.classList.remove('active');
//     improvementBtn.classList.remove('active');
//     challengeBtn.classList.remove('active');
//
//     eatTogetherList.classList.add('hidden');
//     goTogetherList.classList.add('hidden');
//     volunteerList.classList.add('hidden');
//     hobbyList.classList.remove('hidden');
//     activityList.classList.add('hidden');
//     improvementList.classList.add('hidden');
//     challengeList.classList.add('hidden');
//
// });
// activityBtn.addEventListener('click',()=>{
//     eatTogetherBtn.classList.remove('active');
//     goTogetherBtn.classList.remove('active');
//     volunteerBtn.classList.remove('active');
//     hobbyBtn.classList.remove('active');
//     activityBtn.classList.add('active');
//     improvementBtn.classList.remove('active');
//     challengeBtn.classList.remove('active');
//
//     eatTogetherList.classList.add('hidden');
//     goTogetherList.classList.add('hidden');
//     volunteerList.classList.add('hidden');
//     hobbyList.classList.add('hidden');
//     activityList.classList.remove('hidden');
//     improvementList.classList.add('hidden');
//     challengeList.classList.add('hidden');
//
// });
// improvementBtn.addEventListener('click',()=>{
//     eatTogetherBtn.classList.remove('active');
//     goTogetherBtn.classList.remove('active');
//     volunteerBtn.classList.remove('active');
//     hobbyBtn.classList.remove('active');
//     activityBtn.classList.remove('active');
//     improvementBtn.classList.add('active');
//     challengeBtn.classList.remove('active');
//
//     eatTogetherList.classList.add('hidden');
//     goTogetherList.classList.add('hidden');
//     volunteerList.classList.add('hidden');
//     hobbyList.classList.add('hidden');
//     activityList.classList.add('hidden');
//     improvementList.classList.remove('hidden');
//     challengeList.classList.add('hidden');
//
// });
// challengeBtn.addEventListener('click',()=>{
//     eatTogetherBtn.classList.remove('active');
//     goTogetherBtn.classList.remove('active');
//     volunteerBtn.classList.remove('active');
//     hobbyBtn.classList.remove('active');
//     activityBtn.classList.remove('active');
//     improvementBtn.classList.remove('active');
//     challengeBtn.classList.add('active');
//
//     eatTogetherList.classList.add('hidden');
//     goTogetherList.classList.add('hidden');
//     volunteerList.classList.add('hidden');
//     hobbyList.classList.add('hidden');
//     activityList.classList.add('hidden');
//     improvementList.classList.add('hidden');
//     challengeList.classList.remove('hidden');
//
// });
//
//
// // 이미 유저가 직접 생성한 소셜링이 있는 경우,
// searchBtn.addEventListener('click',()=>{
//     alert('이미 생성한 소셜링이 있습니다!\n소셜링 생성은 1회만 가능합니다!');
// })
//
//
// document.querySelectorAll('.sharing-category-btn').forEach(function(button) {
//     button.addEventListener('click', function() {
//         let selectedCategory = button.getAttribute('data-category'); // 클릭한 버튼의 카테고리 값
//         let currentPage = new URL(window.location.href); // 현재 URL을 가져옴
//
//         // 'category' 파라미터를 업데이트
//         currentPage.searchParams.set('category', selectedCategory);
//
//         // 페이지를 새로 고침하면서 URL에 'category' 파라미터를 포함시킴
//         window.location.href = currentPage.toString();
//     });
// });
//

// 1. 초기화: URL 파라미터 기반으로 상태 설정
window.addEventListener('DOMContentLoaded', () => {
    const currentPage = new URL(window.location.href);
    const category = currentPage.searchParams.get('category'); // URL에서 'category' 파라미터 가져오기

    // 모든 버튼과 리스트 초기화
    document.querySelectorAll('.sharing-category-btn').forEach(btn => btn.classList.remove('active'));
    document.querySelectorAll('.sharing-list-container').forEach(list => list.classList.add('hidden'));

    // URL 파라미터에 해당하는 버튼과 리스트 활성화 또는 기본값 설정
    if (category) {
        const activeButton = Array.from(document.querySelectorAll('.sharing-category-btn')).find(button =>
            button.getAttribute('data-category') === category
        );

        if (activeButton) {
            activeButton.classList.add('active');
            const listId = activeButton.id.replace('-btn', '-list');
            const activeList = document.getElementById(listId);
            if (activeList) {
                activeList.classList.remove('hidden');
            }
        }
    } else {
        // 기본값: 첫 번째 버튼과 리스트 활성화
        const firstButton = document.querySelector('.sharing-category-btn');
        const firstListId = firstButton.id.replace('-btn', '-list');
        const firstList = document.getElementById(firstListId);

        if (firstButton && firstList) {
            firstButton.classList.add('active');
            firstList.classList.remove('hidden');
        }
    }
});

// 2. 버튼 클릭 이벤트 처리
document.querySelectorAll('.sharing-category-btn').forEach(function(button) {
    button.addEventListener('click', function() {
        // 2.1 모든 버튼 및 리스트 초기화
        document.querySelectorAll('.sharing-category-btn').forEach(btn => btn.classList.remove('active'));
        document.querySelectorAll('.sharing-list-container').forEach(list => list.classList.add('hidden'));

        // 2.2 현재 버튼 및 리스트 활성화
        button.classList.add('active');
        const listId = button.id.replace('-btn', '-list');
        const selectedList = document.getElementById(listId);
        if (selectedList) {
            selectedList.classList.remove('hidden');
        }

        // 2.3 URL 파라미터 업데이트 및 새로고침
        let selectedCategory = button.getAttribute('data-category'); // 클릭한 버튼의 카테고리 값
        let currentPage = new URL(window.location.href); // 현재 URL 가져오기
        currentPage.searchParams.set('category', selectedCategory);

        // 새 URL로 페이지 리로드
        window.location.href = currentPage.toString();
    });
});
