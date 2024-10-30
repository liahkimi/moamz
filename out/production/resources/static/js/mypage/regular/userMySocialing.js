const socialingDeleteBtn = document.querySelectorAll('.socialing-delete-btn')

//  삭제 버튼 클릭
socialingDeleteBtn.forEach(btn => {
  btn.addEventListener('click', function() {
      const isConfirm = confirm("소셜링을 삭제할까요? 단체채팅방도 함께 종료됩니다.");
      if (isConfirm) {
      } else {
      }
  });
});