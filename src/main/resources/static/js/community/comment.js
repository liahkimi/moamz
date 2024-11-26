
/*
 * 댓글 관련 모듈
 * CommentRestController로 비동기 요청 보냄
 */


//////////////////////////////////////////////////
///// 댓글 목록 가져오기 모듈 (페이지네이션x)

export function getList(postId, callback) {
    fetch(`/api/comment/list/${postId}`, {
        method : 'GET'
    }).then(response => response.json())  // 서버 응답을 json으로 변환
        .then(commentList => {      // 변환된 json 데이터가 commentList에 담김
            callback(commentList)   // commentList를 callback 함수로 전달함
        });
}




//////////////////////////////////////////////////
///// 댓글 목록 가져오기 모듈 (페이지네이션O)

export function getListAll(postId, page, callback) {
    fetch(`/api/comment/list/${postId}/comm?page=${page}`, {
        method : 'GET'
    }).then(response => response.json())  // 서버 응답을 json으로 변환
        .then(commentList => {       // 변환된 json 데이터가 commentList에 담김
            callback(commentList)    // commentList를 callback 함수로 전달함
        });
}



//////////////////////////////////////////////////
///// 댓글 작성 모듈 (POST)

export function insertComm(commInfo, callback) {
    console.log(commInfo);
    fetch(`/api/comment/insert/${commInfo.postId}`, {
        method : 'POST',
        headers : { 'Content-Type' : 'application/json' },      // 요청 데이터가 JSON 형식이라고 알려줌
        body : JSON.stringify(                                  // JSON을 문자열 형식으로 변한
            { fgCommentContent : commInfo.commentContent} // 요청 본문에 commentContent를 추가함
        )
    }).then(response => {
        console.log(response);
        // 서버 응답 상태가 성공(200)인 경우, callback 함수를 호출한다.
        if(response.status === 200) { callback(); }
    });
}




//////////////////////////////////////////////////
///// 댓글 수정 모듈 (PATCH)

export function updateComm(updateInfo, callback) {
    fetch(`/api/comment/update/${updateInfo.commentId}`, {
        method : 'PATCH',
        headers : { 'Content-Type' : 'application/json' },    // 요청 데이터가 JSON 형식이라고 알려줌
        body : JSON.stringify(                                 // JSON을 문자열 형식으로 변한
            { fgCommentContent : updateInfo.commentContent}       // 요청 본문에 commentContent를 추가함
        )
    }).then(response => {
        // 서버 응답 상태가 성공(200)인 경우, callback 함수를 호출한다.
        if(response.status === 200) { callback(); }
    });
}



//////////////////////////////////////////////////
///// 댓글 삭제 모듈 (DELETE)

export function removeComm(commentId, callback) {
    fetch(`/api/comment/delete/${commentId}`, {
        method : 'DELETE'
    }).then(response => {
        // 서버 응답 상태가 성공(200)인 경우, callback 함수를 호출한다.
        if(response.status === 200) { callback(); }
    });
}