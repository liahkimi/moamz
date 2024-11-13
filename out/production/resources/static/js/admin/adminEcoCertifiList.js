const pointBtn = document.getElementById("pointBtn");

//인증글 상세페이지로 이동
function goToDetailPage(event, fgPostId, fgProjectId) {
    event.preventDefault();
    const url = `/admin/eco/ecoCertDetail/${fgPostId}/${fgProjectId}`;
    window.location.href = url;
}


function goToDetailPageFin() {
  window.location.href = "adminEcoCertifiDetailFin.html";  // 상세 페이지 URL로 이동
}

// // 포인트 지급하기 버튼
// pointBtn.addEventListener("click",(e)=>{
//     e.preventDefault();
//     prompt("지급할 포인트를 입력해주세요");
// })




// // 모달 열기 함수
// function openModal(event) {
//   event.stopPropagation();  // 클릭 이벤트 전파 차단하여 tr 클릭을 방지
//   document.getElementById('myModal').style.display = "block";  // 모달 열기
// }

// // 모달 닫기 함수
//   function closeModal() {
//     document.getElementById('myModal').style.display = "none";  // 모달 닫기
//   }
//

// 모달 함수
function openModal(button) {

    // 버튼의 fgPostId 속성 값 가져오기
    const fgPostId = button.getAttribute("data-fg-post-id");

    // 숨겨진 필드에 fgPostId 값을 설정
    document.getElementById("modalFgPostId").value = fgPostId;

    // 모달 표시
    document.getElementById("myModal").style.display = "block";
}

function closeModal() {
    document.getElementById("myModal").style.display = "none";
}



  // 모달 외부를 클릭하면 닫기
  window.onclick = function(event) {
    const modal = document.getElementById('myModal');
    if (event.target === modal) {
      modal.style.display = "none";  // 모달 닫기
    }
  }

// 포인트지급하기 버튼에서 적용버튼 누르면
// 지급되었다는 알럿뜨고 모달 닫기
const submitBtn = document.getElementById('submitBtn');
submitBtn.addEventListener('click',(e)=>{
    e.preventDefault();
    alert('포인트 지급이 완료되었습니다!')
    const modal = document.getElementById('myModal');
    modal.style.display = "none";  // 모달 닫기
})

//
// pointBtn.addEventListener("click", function () {
//     const nickName = this.getAttribute('data-mem-nickname');
//     const memberNum = this.getAttribute('data-member-num');
//     fetch(`/admin/admMemberMgmt/details?memberNum=${memberNum}`)
//         .then(response => response.json())
//         .then(data => { … 내가 필요한 로직이나 불러올 값 }
//


















