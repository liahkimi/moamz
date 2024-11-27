// 인증글 상세페이지로 이동
function goToDetailPage(event, fgPostId, fgProjectId) {
    event.preventDefault(); // 기본 동작(링크 이동)을 막음
    const url = `/admin/eco/ecoCertDetail/${fgPostId}/${fgProjectId}`; // 이동할 URL을 동적으로 생성
    window.location.href = url; // 생성된 URL로 페이지 이동
}

// 완료된 에코프로젝트 인증글 상세페이지 이동
function goToDetailPageFin() {
    window.location.href = "adminEcoCertifiDetailFin.html";  // 특정 상세 페이지 URL로 이동
}

// 모달 열기 함수
function openModal(event) {
    event.stopPropagation();  // 클릭 이벤트 전파를 차단하여 tr 클릭 이벤트 방지
    const fgPostId = event.target.getAttribute("data-fg-post-id"); // 클릭된 요소에서 `data-fg-post-id` 속성 값을 가져옴
    // console.log(fgPostId);  // 가져온 `fgPostId` 값을 콘솔에 출력하여 확인
    document.getElementById("modalFgPostId").value = fgPostId; // 숨겨진 input 필드에 `fgPostId` 값 설정
    document.getElementById('myModal').style.display = "block";  // 모달 창을 보이도록 설정
}

// 모달 닫기 함수
function closeModal() {
    document.getElementById('myModal').style.display = "none";  // 모달 창을 보이지 않도록 설정
}

// 모달 폼 데이터 제출 처리
document.getElementById('pointForm').addEventListener('submit', function (e) {
    e.preventDefault(); // 폼의 기본 제출 동작을 중단
    const postId = document.getElementById('modalFgPostId').value; // 숨겨진 input에서 `postId` 값 가져오기
    const points = document.getElementById('pointInput').value; // 입력된 포인트 값 가져오기

    console.log(postId); // `postId`를 콘솔에 출력하여 확인
    console.log(points); // 입력된 포인트 값을 콘솔에 출력하여 확인

    // 포인트가 입력되지 않았거나 0 이하의 값을 입력한 경우 경고 메시지 표시 후 종료
    if (!points || points <= 0) {
        alert('포인트는 0보다 큰 값을 입력해야 합니다.');
        return;
    }

    // 요청 본문에 포함될 데이터를 객체로 구성
    const requestBody = {
        fgPostId: postId,          // 게시글 ID
        fgPointReceived: points   // 지급할 포인트
    };

    // 서버에 데이터를 전달하기 위해 fetch API 호출
    fetch(`/admin/eco/updatePoint`, {
        method: 'POST', // POST 요청으로 서버에 데이터 전송
        headers: {
            'Content-Type': 'application/json', // 요청 본문의 데이터 형식을 JSON으로 지정
        },
        body: JSON.stringify(requestBody),  // JSON으로 변환된 데이터를 요청 본문으로 설정
    })
        .then(response => {
            if (response.ok) { // 서버로부터의 응답이 성공적인 경우
                alert('포인트 지급이 완료되었습니다!'); // 성공 메시지 표시
                closeModal(); // 모달 창 닫기
                location.reload(); // 페이지 새로고침
            } else { // 응답이 성공적이지 않은 경우
                return response.json().then(err => { // 서버에서 전달된 오류 메시지를 파싱
                    throw new Error(err.message); // 파싱된 오류 메시지를 예외로 던짐
                });
            }
        })
        .catch(err => { // 요청 도중 오류가 발생한 경우
            alert(`오류 발생: ${err.message}`); // 오류 메시지 표시
        });
});
