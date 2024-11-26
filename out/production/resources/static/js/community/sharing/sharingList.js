// 나눔가능, 예약중, 나눔완료 버튼
const availableBtn = document.getElementById('sharing-available-btn');
const reservedBtn = document.getElementById('sharing-reserved-btn');
const completedBtn = document.getElementById('sharing-completed-btn');    

// 각각의 게시글 목록
const availableList = document.getElementById('sharing-available-list');
const reservedList = document.getElementById('sharing-reserved-list');
const completedList = document.getElementById('sharing-completed-list');

// 페이지네이션 ul 태그
const pageContainer = document.getElementById('pagination');

// 현재 페이지, 게시글 상태 초기화
let currentPage = 1;
let currentStatus = 'available';

// 초기 화면에서 나눔 가능 게시글 로드
loadSharingList('available', 1);





////////////////////////////////////////////////////////
///// 상태별 게시글 목록 로드 함수

function loadSharingList(status, page=1) {

    currentPage = page;
    currentStatus = status;

    // 페이지네이션을 포함한 나눔게시판 목록 요청
    fetch(`/api/sharing/list/${status}?page=${page}`, {
        method: 'GET'
    }).then(response => response.json())
        .then(data => {
            // 비구조화할당
            const {sharingList, page} = data;

            // 나눔글 상태에 맞는 컨테이너 선택하기
            const listContainer = document.getElementById(`sharing-${status}-list`);

            // 목록을 뿌려줄 ul 태그 선택
            const listContainerUl = listContainer.querySelector('ul');

            // 목록 html 태그를 담을 변수
            let listElement = '';

            // 목록 초기화
            listContainerUl.innerHTML = ``;

            // 가져온 각 목록을 html 요소로 생성한다.
            sharingList.forEach(list => {
                listElement = `
                    <li class="sharing-card-view" onclick="location.href='/sharing/detail/${list.postId}'">
                        <img src="/upload_moamz/${list.postFileRoot}/${list.postFileUuid}_${list.postFileName}" 
                             alt="나눔물품 이미지">
                        <div class="sharing-title">${list.postTitle}</div>
                        <div class="sharing-wrap">
                            <div class="sharing-nickname">${list.normalNickname}</div>
                            <div class="sharing-status ${status}">${list.sharingStatus}</div>
                        </div>
                    </li>
                `;

                // 생성된 html 태그를 ul태그에 추가
                listContainerUl.innerHTML += listElement;

                // // 모든 게시글 목록 숨기기
                // availableList.classList.add('hidden');
                // reservedList.classList.add('hidden');
                // completedList.classList.add('hidden');
                //
                // // 요청이 들어온 상태의 목록만 보여주기
                // listContainer.classList.remove('hidden');
                //
                // // 페이지네이션 업데이트
                // updatePagination(page);

            }); //forEach 끝

                // // 생성된 html 태그를 ul태그에 추가
                // listContainerUl.innerHTML += listElement;
                //
                // 모든 게시글 목록 숨기기
                availableList.classList.add('hidden');
                reservedList.classList.add('hidden');
                completedList.classList.add('hidden');

                // 요청이 들어온 상태의 목록만 보여주기
                listContainer.classList.remove('hidden');

                // 페이지네이션 업데이트
                updatePagination(page);
        });
}





////////////////////////////////////////////////////////
///// 페이지네이션 초기화 함수

function updatePagination(page) {
    // 페이지네이션 컨테이너 초기화
    pageContainer.innerHTML = '';

    // 이전 페이지 버튼
    if (page.prev) {    // 이전 페이지가 존재하는 경우
        // a 태그(이전 페이지 링크)를 생성하고 링크 주소를 #으로 설정한다.
        const prevPage = document.createElement('a');
        prevPage.href = '#';

        // a 태그에 클래스를 추가한다.
        prevPage.classList.add('page-a');

        // < 값 설정
        prevPage.innerHTML = `&lt;`;

        // 이전 페이지 버튼을 클릭했을 때 로드할 페이지 지정
        prevPage.onclick = () => loadSharingList(currentStatus, page.startPage - 1);

        // 이전 페이지 버튼 생성
        const prevButton = document.createElement('li');
        // li 태그에 클래스를 추가한다.
        prevButton.classList.add('page-number');

        // 생성한 이전 페이지 링크를 li태그(버튼)에 추가한다.
        prevButton.appendChild(prevPage);

        // 페이지네이션 컨테이너에 이전 페이지 버튼을 추가한다.
        pageContainer.appendChild(prevButton);
    }

    // 페이지 번호 생성 (시작페이지 ~ 끝페이지를 반복)
    for (let i = page.startPage; i <= page.endPage; i++) {
        // 각 페이지 번호를 표시하는 li태그 생성하고 클래스 지정하기
        const pageItem = document.createElement('li');
        pageItem.classList.add('page-number');

        // 페이지 번호 링크 설정하고 링크 주소를 #으로 설정
        const pageLink = document.createElement('a');
        pageLink.href = '#';
        pageLink.classList.add('page-a');

        // 현재 페이지일 때 active 클래스 설정
        if (i === page.criteria.page) {
            pageLink.classList.add('active');
        }


        // 페이지 번호를 나타내는 텍스트
        pageLink.textContent = i;

        // 각 페이지를 표시하는 li클래스를 클릭했을 때 보여줄 페이지 설정
        pageLink.onclick = () => loadSharingList(currentStatus, i);

        // 생성한 링크를 li태그(페이지 번호 버튼)에 추가
        pageItem.appendChild(pageLink);

        // 페이지네이션 컨테이너에 페이지 번호 추가
        pageContainer.appendChild(pageItem);
    }

    // 다음 페이지 버튼
    if (page.next) {    // 다음 페이지가 존재하는 경우
        // 다음 페이지 링크를 생성하고 링크 주소를 #으로 설정한다.
        const nextPage = document.createElement('a');
        nextPage.href = '#';

        // a태그에 클래스 추가
        nextPage.classList.add('page-a');

        // < 값 설정
        nextPage.innerHTML = `&gt;`;

        // 다음 페이지 버튼을 클릭했을 때 보여줄 페이지 지정
        nextPage.onclick = () => loadSharingList(currentStatus, page.endPage + 1);

        // 다음 페이지 버튼을 li 태그로 생성하고 클래스를 추가한다.
        const nextButton = document.createElement('li');
        nextButton.classList.add('page-number');

        // 다음 페이지 버튼에 링크를 추가한다.
        nextButton.appendChild(nextPage);

        // 페이지네이션 영역에 다음 페이지 버튼을 추가한다.
        pageContainer.appendChild(nextButton);
    }
}





////////////////////////////////////////////////////////
///// 메뉴 버튼 활성화 함수

function setActiveBtn(btn) {
    // 모든 메뉴에서 active 클래스 제거
    availableBtn.classList.remove('active');
    reservedBtn.classList.remove('active');
    completedBtn.classList.remove('active');

    // 요청이 들어온 버튼만 active 클래스 추가
    btn.classList.add('active');
}





////////////////////////////////////////////////////////
///// 각 게시글 메뉴 클릭했을 때 이벤트 처리

// 나눔가능 버튼 눌렀을 떄
availableBtn.addEventListener('click', () => {
    loadSharingList('available', 1);
    setActiveBtn(availableBtn);
});

// 예약중 버튼 눌렀을 때
reservedBtn.addEventListener('click', () => {
    loadSharingList('reserved', 1);
    setActiveBtn(reservedBtn);
});

// 나눔완료 버튼 눌렀을 때
completedBtn.addEventListener('click', () => {
    loadSharingList('completed', 1);
    setActiveBtn(completedBtn);
});
