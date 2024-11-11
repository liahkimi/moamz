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


//진행중인 에코리스트 배너클릭시 해당 인증목록 페이지로 이동
function goToDetailPage(event, fgPostId) {
    event.stopPropagation();
    event.preventDefault();
    window.location.href = `/admin/eco/ecoCertList/${fgPostId}`;
}
//완료된 에코리스트 배너클릭시 해당 인증목록 페이지로 이동
function goToDetailPageFin(event, fgPostId) {
    event.stopPropagation();
    event.preventDefault();
    window.location.href = `/admin/eco/finEcoCertList/${fgPostId}`;
}


//삭제 버튼
function deleteEco(event, fgPostId) {
    event.stopPropagation();
    event.preventDefault();
    if(confirm("해당 에코프로젝트를 삭제하시겠습니까?")){
        window.location.href = `/admin/eco/remove/${fgPostId}`;
    }

}

// 배너의 종료시키기 버튼 클릭시 이벤트
function changeStatus(event , fgPostId) {
    console.log(event.target);
    event.stopPropagation();
    event.preventDefault();
    // console.log(fgPostId);

    if (confirm("완료된 프로젝트로 변경하시겠습니까?")) {
            //비동기처리되어 완료된 프로젝트로 변경시키기
            // window.location.href = `/admin/eco/list/modifyEcoStatus/${fgPostId}`;


            fetch(`http://localhost:9999/admin/eco/list/modifyEcoStatus/${fgPostId}`, {
                method: 'post'
            }).then(response => {
                if(response.ok){
                    location.reload();
                }else{
                    alert('ㅠㅠ');
                }
            })
        } else {
            //변경 취소하고 컨펌창만 닫기
        }
    }





