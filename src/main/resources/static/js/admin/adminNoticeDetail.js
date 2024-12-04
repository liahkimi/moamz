const deleteBtn = document.getElementById('delete-btn');




// 게시글 삭제 버튼

function deleteNotice(event, fgPostId) {
    event.stopPropagation();
    event.preventDefault();
    if (confirm("해당 글을 삭제하시겠습니까?")) {
        window.location.href = `/admin/notice/remove/${fgPostId}`;
    }

}


// if (deleteBtn) {
//     deleteBtn.addEventListener('click', function(event) {
//         const isConfirm = confirm('해당 글을 삭제하시겠습니까?');
//         // event.target을 사용하여 버튼을 참조
//         let fgPostId = event.target.closest('button').dataset.id;
//         console.log(fgPostId);
//
//         if (isConfirm) {
//             location.href = `/admin/notice/remove?fgPostId=${fgPostId}`;
//         }
//     });
// } else {
//     console.log("삭제 버튼을 찾을 수 없습니다.");
// }

//게시글 수정버튼
const modifyBtn = document.getElementById('btn-modify');

modifyBtn.addEventListener("click", function(){
    // console.log("클릭함");
       let fgPostId = this.dataset.id;
       // console.log(fgPostId);
    if (confirm("해당 글을 수정하시겠습니까?")) {
        window.location.href = `/admin/notice/modify?fgPostId=${fgPostId}`;
    }

   })
