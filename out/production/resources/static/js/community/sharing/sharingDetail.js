const deleteBtn = document.getElementById('delete-btn');

deleteBtn.addEventListener('click', () => {
    const isConfirm = confirm('해당 글을 삭제하시겠습니까?');
    if (isConfirm) {
        window.location.href = 'sharingList.html';
    } else {
    }
});