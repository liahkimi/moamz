const currentUrl = window.location.pathname.split("/").pop();;//현재페이지 url 가져오기
// console.log(currentUrl);
const navLinks = document.querySelectorAll('.nav-link');
// console.log(navLinks);

// 클릭한 네비게이션의 페이지가 화면에 나오고
// 클릭한 네비게이션만 강조되어 고정되기.
navLinks.forEach(link => {
    const onclickValue = link.getAttribute('onclick');
    const url = onclickValue.match(/location\.href='([^']+)'/)[1]; // 정규식을 사용해 href 추출
    //console.log(url); // 'adminSellerInquiryList.html' 등 나옴
    if(url === currentUrl){
       link.classList.add('active'); 
    //    console.log(link);
    }

  });
  
