const find = document.getElementById("find-id-btn");
const name = document.getElementById("find-name-check");
const phone = document.getElementById("find-phone-check");

find.addEventListener("click", () => {
  if(!name.value.trim()){
    alert("이름을 입력해주세요");
    return;
  }
  if(!phone.value.trim()){
    alert("휴대폰을 입력해주세요");
    return;
  }
  const isConfirm = confirm("이메일은 qwdnqwi@gmail.com입니다.")
  if(isConfirm){
    location.href='sellerLogin.html';
  }
  
});