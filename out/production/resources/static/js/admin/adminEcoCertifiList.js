    const pointBtn = document.getElementById("pointBtn");

    //인증글 상세페이지로 이동
    function goToDetailPage(event, fgPostId, fgProjectId) {
        event.preventDefault();
        const url = `/admin/eco/ecoCertDetail/${fgPostId}/${fgProjectId}`;
        window.location.href = url;
    }

    //완료된 에코프젝 인증글 상세페이지 이동
    function goToDetailPageFin() {
      window.location.href = "adminEcoCertifiDetailFin.html";  // 상세 페이지 URL로 이동
    }



    // 모달 열기 함수
    function openModal(event) {
      event.stopPropagation();  // 클릭 이벤트 전파 차단하여 tr 클릭을 방지
      const fgPostId = event.target.getAttribute("data-fg-post-id");
        console.log(fgPostId);  // 값 확인
      document.getElementById("modalFgPostId").value = fgPostId; //숨겨진 필드에 fgPostId 설정
      document.getElementById('myModal').style.display = "block";  // 모달 열기
    }

    // 모달 닫기 함수
      function closeModal() {
        document.getElementById('myModal').style.display = "none";  // 모달
          // 닫기
      }


    // 폼 데이터 제출 처리

    document.getElementById('pointForm').addEventListener('submit', function (e) {
        e.preventDefault(); // 기본 동작 중단
        const postId = document.getElementById('modalFgPostId').value;
        const points = document.getElementById('pointInput').value;

        console.log(postId);
        console.log(points);

        if (!points || points <= 0) {
            alert('포인트는 0보다 큰 값을 입력해야 합니다.');
            return;
        }

        // body에 fgPostId와 fgPointReceived를 포함시킴
        const requestBody = {
            fgPostId: postId,
            fgPointReceived: points
        };

        fetch(`/admin/eco/updatePoint`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(requestBody),  // requestBody로 전달
        })
            .then(response => {
                if (response.ok) {
                    alert('포인트 지급이 완료되었습니다!');
                    closeModal();
                    location.reload(); // 페이지 새로고침
                } else {
                    return response.json().then(err => {
                        throw new Error(err.message);
                    });
                }
            })
            .catch(err => {
                alert(`오류 발생: ${err.message}`);
            });
    });


















