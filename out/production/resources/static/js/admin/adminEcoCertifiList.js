// 상세 페이지로 이동하는 함수
function goToDetailPage() {
    window.location.href = "adminEcoCertifiDetail.html";  // 상세 페이지 URL로 이동
  }
  
  // 모달 열기 함수
  function openModal(event) {
    event.stopPropagation();  // 클릭 이벤트 전파 차단하여 tr 클릭을 방지
    document.getElementById('myModal').style.display = "block";  // 모달 열기
  }
  
  // 모달 닫기 함수
  function closeModal() {
    document.getElementById('myModal').style.display = "none";  // 모달 닫기
  }
  
//   // 모달 외부를 클릭하면 닫기
//   window.onclick = function(event) {
//     const modal = document.getElementById('myModal');
//     if (event.target === modal) {
//       modal.style.display = "none";  // 모달 닫기
//     }
//   }

// 포인트지급하기 버튼에서 적용버튼 누르면 
// 지급되었다는 알럿뜨고 모달 닫기
const submitBtn = document.getElementById('subminBtn');
submitBtn.addEventListener('click',(e)=>{
    e.preventDefault();
    alert('포인트 지급이 완료되었습니다!')
    const modal = document.getElementById('myModal');
    modal.style.display = "none";  // 모달 닫기
})