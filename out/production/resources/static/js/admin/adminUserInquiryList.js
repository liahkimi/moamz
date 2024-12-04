const userMngBtn = document.getElementById('user-management-btn');
const sellerMngBtn = document.getElementById('seller-management-btn');
const userList = document.getElementById('user-table-container');
const sellerList = document.getElementById('seller-table-container');


// userMngBtn.addEventListener('click',function(){
//     this.classList.add('active-btn');
//     sellerMngBtn.classList.remove('active-btn');
//     userList.classList.remove('table-hidden');
//     sellerList.classList.add('table-hidden');
// })
// sellerMngBtn.addEventListener('click',function(){
//     this.classList.add('active-btn');
//     userMngBtn.classList.remove('active-btn');
//     sellerList.classList.remove('table-hidden');
//     userList.classList.add('table-hidden');
//
// })

// 상세 페이지로 이동하는 함수
function goToDetailPage(event, fgPostId) {
    window.location.href = "adminUserInquiryDetail.html";  // 상세 페이지 URL로 이동
  }

// 답변 상태 바꾸는 함수
function changeStatus(event, fgPostId) {
    event.stopPropagation();  // 클릭 이벤트 전파를 차단하여 tr 클릭 이벤트 방지

    // 세션 확인 API 요청
    fetch('/api/checkSession', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    })
        .then(response => {
            if (response.status === 401) {  // 세션이 없으면 401 Unauthorized
                // 로그인 페이지로 리디렉션
                location.href = '/admin/login?error=sessionExpired';
            } else {
                // 세션이 있으면, 상태 변경 요청 전에 confirm 창을 띄운다
                // confirm 창을 세션 확인 후에 띄우도록 변경
                return confirm("답변완료로 변경하시겠습니까?");
            }
        })
        .then(isConfirmed => {
            if (isConfirmed) {
                console.log(fgPostId);
                // 상태 변경 요청
                fetch(`http://localhost:9999/admin/userInquiry/list/modifyEcoStatus/${fgPostId}`, {
                    method: 'POST'
                })
                    .then(response => {
                        if (response.ok) {
                            location.reload(); // 상태 변경 후 페이지 리로드
                        } else {
                            alert("ㅠㅠ 상태 변경 실패");
                        }
                    })
                    .catch(err => {
                        alert("상태 변경 중 오류 발생");
                    });
            }
        })
        .catch(err => {
            alert('세션 확인 중 오류 발생');
        });
}
