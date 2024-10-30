const cancleBtn = document.getElementById('cancle-btn');
const writeBtn = document.getElementById('write-btn');

// 취소버튼
cancleBtn.addEventListener('click', () => {
    const isConfirm = confirm('글 작성을 취소하시겠습니까? 작업중인 내용이 저장되지 않습니다.');
    if (isConfirm) {
        window.location.href = 'userPurchaseHistory.html';
    } else {
    }
});

// 등록버튼 -> 모든 폼 요소가 입력되었을 때만 confirm창이 떠야함
writeBtn.addEventListener('click', (e) => {
    e.preventDefault(); // 기본 submit 동작 막기

    const starRating = document.getElementById('star-rating');
    const reviewContent = document.getElementById('review-content');

    // 폼 요소 값 입력되었는지
    if (!starRating.value.trim() || starRating.value<0 || starRating.value>5) {
        alert('별점을 입력해주세요. 0부터 5까지 정수값만 입력 가능합니다.');
        starRating.focus();
        return;
    }
    if (!reviewContent.value.trim()) {
        alert('리뷰 내용을 입력해주세요.');
        reviewContent.focus();
        return;
    }

    // 모든 필드가 입력되었을 때 confirm
    const isConfirm = confirm('리뷰를 등록하시겠습니까?');
    if (isConfirm) {
        alert('등록되었습니다.')
        location.href='userMyReview.html';
    } else {

    }
});
