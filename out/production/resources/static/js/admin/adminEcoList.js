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



function showIngList() {
    document.getElementById('ongoing-eco__btn').classList.remove('active-btn');
    document.getElementById('finished-eco__btn').classList.add('active-btn');
}

function showFinList() {
    document.getElementById('ongoing-eco__btn').classList.remove('active-btn');
    document.getElementById('finished-eco__btn').classList.add('active-btn');
}




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
// function deleteEco(event, fgPostId) {
//     event.stopPropagation();
//     event.preventDefault();
//     if(confirm("해당 에코프로젝트를 삭제하시겠습니까?")){
//         window.location.href = `/admin/eco/remove/${fgPostId}`;
//     }
//
// }
function deleteEco(event, fgPostId) {
    event.stopPropagation();
    event.preventDefault();

    // 세션 유효성 먼저 확인 (GET 요청)
    fetch(`/admin/eco/remove/${fgPostId}`, {
        method: "GET",
        redirect: "follow", // 리다이렉트 허용
    }).then(response => {
        if (response.redirected) {
            // 세션이 만료되어 리다이렉트된 경우
            window.location.href = response.url;
        } else if (response.ok) {
            // 서버 접근 성공 시 삭제 확인
            if (confirm("해당 에코프로젝트를 삭제하시겠습니까?")) {
                window.location.href = `/admin/eco/remove/${fgPostId}`;
            }
        } else {
            alert("삭제 요청에 실패했습니다.");
        }
    }).catch(error => {
        console.error("세션 확인 중 오류 발생:", error);
        alert("요청 중 문제가 발생했습니다.");
    });
}



// // 배너의 종료시키기 버튼 클릭시 이벤트
// function changeStatus(event , fgPostId) {
//     console.log(event.target);
//     event.stopPropagation();
//     event.preventDefault();
//     // console.log(fgPostId);
//
//     if (confirm("완료된 프로젝트로 변경하시겠습니까?")) {
//             fetch(`http://localhost:9999/admin/eco/list/modifyEcoStatus/${fgPostId}`, {
//                 method: 'post'
//             }).then(response => {
//                 if(response.ok){
//                     location.reload();
//                 }else{
//                     alert('ㅠㅠ');
//                 }
//             })
//         } else {
//             //변경 취소하고 컨펌창만 닫기
//         }
//     }

// // 배너의 종료시키기 버튼 클릭시 이벤트
function changeStatus(event, fgPostId) {
    console.log(event.target);
    event.stopPropagation();
    event.preventDefault();

    // 서버로 먼저 세션과 상태 요청
    fetch(`http://localhost:9999/admin/eco/list/modifyEcoStatus/${fgPostId}`, {
        method: 'post',
    }).then(response => {
        if (response.redirected) {
            // 세션이 만료되어 리다이렉트된 경우
            window.location.href = response.url;
        } else if (response.ok) {
            // 서버 처리 성공 시 확인창 띄우기
            if (confirm("완료된 프로젝트로 변경하시겠습니까?")) {
                location.reload(); // 필요 시 새로고침
            }
        } else {
            alert("상태 변경 요청에 실패했습니다.");
        }
    }).catch(error => {
        console.error("요청 중 오류 발생:", error);
        alert("요청 중 문제가 발생했습니다.");
    });
}





