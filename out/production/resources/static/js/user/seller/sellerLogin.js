const loginBtn = document.getElementById("login_but");

loginBtn.addEventListener('click', (e) => {
    // form태그 자동 제출 막기
    e.preventDefault();

    var checkedId = $("#fgUserId").val();
    var checkedPassword = $("#fgUserPassword").val();

    if (checkedId && checkedPassword) {
        $.ajax({
            url: "/seller/loginCheck",
            type: "POST",
            data: { checkedId: checkedId , checkedPassword: checkedPassword}, // 서버로 전송할 데이터 (checkedId 파라미터에 입력된 아이디 값 전달)
            success: function(response) { // 서버 응답이 성공적일 때 실행되는 콜백 함수
                alert(response);

                switch (response) {
                    case "MOAMZ에 오신걸 환영합니다.":
                        // form태그를 자바스크립트에서 직접 제출
                        document.querySelector('form').submit();
                        break;
                    case "아이디 혹은 비밀번호를 확인해주세요.":
                        // 화면 새로고침
                        location.reload(true);
                        break;
                }

            },
            error: function() { // 서버 요청이 실패했을 때 실행되는 콜백 함수
                alert("알 수 없는 에러");
            }
        });
    } else {
        // 아이디 입력란이 비어있으면 경고 메시지를 띄움
        alert("아이디 혹은 비밀번호를 입력해 주세요.");
    }
})