const ongoingBtn = document.getElementById("ongoing-eco__btn");
const finishedBtn = document.getElementById("finished-eco__btn");
const ongoingEco = document.getElementById("ongoing-eco");
const finishedEco = document.getElementById("finished-eco");

ongoingBtn.addEventListener("click", () => {
  ongoingEco.classList.remove("banner-hidden");
  finishedEco.classList.add("banner-hidden");
  ongoingBtn.classList.add("active-btn");
  finishedBtn.classList.remove("active-btn");
});

finishedBtn.addEventListener("click", () => {
  ongoingEco.classList.add("banner-hidden");
  finishedEco.classList.remove("banner-hidden");
  finishedBtn.classList.add("active-btn");
  ongoingBtn.classList.remove("active-btn");
});

// 배너클릭시 인증목록 페이지로 이동
function goToDetailPage(){
  window.location.href="adminEcoCertifiList.html";
}
//수정하기버튼만 클릭했을때 배너클릭이랑 안겹치게 만들기
function editEco(event){
  event.stopPropagation();
  window.location.href="adminEcoModify.html";
}

function changeStatus(event){
  event.stopPropagation();
  if(confirm("완료된 프로젝트로 변경하시겠습니까?")){
    //비동기처리되어 완료된 프로젝트로 변경시키기
  }else{
    //변경 취소하고 컨펌창만 닫기
  }

}