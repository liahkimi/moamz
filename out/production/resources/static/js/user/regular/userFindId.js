// const find = document.getElementById("find-id-btn");
// const name = document.getElementById("find-name-check");
// const phone = document.getElementById("find-phone-check");
//
// find.addEventListener("click", () => {
//   if(!name.value.trim()){
//     alert("이름을 입력해주세요");
//     return;
//   }
//   if(!phone.value.trim()){
//     alert("휴대폰을 입력해주세요");
//     return;
//   }
//   const isConfirm = confirm("이메일은 qwdnqwi@gmail.com입니다.")
//   if(isConfirm){
//     location.href='userLogin.html';
//   }
//
// });

// ------------------------------------------------------------------------------------
function findId() {
  var name = $("#find-name-check").val();
  var phone = $("#find-phone-check").val();

  if (name && phone) {
    $.ajax({
      url: "/normal/user/findId",
      type: "GET",
      data: { name: name, phone: phone },
      success: function(response) {
        alert(response);  // 서버에서 받은 아이디 또는 오류 메시지 출력
      },
      error: function() {
        alert("아이디 찾기에 실패했습니다. 이름과 휴대폰번호를 확인해 주세요.");
      }
    });
  } else {
    alert("이름과 휴대폰번호를 모두 입력해주세요.");
  }
}

