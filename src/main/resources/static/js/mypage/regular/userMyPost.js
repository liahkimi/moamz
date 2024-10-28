const mypostEco = document.getElementById('mypost-eco-btn');
const mypostReceipe = document.getElementById('mypost-receipe-btn');
const mypostFree = document.getElementById('mypost-free-btn');
const mypostEcoList = document.querySelector('.mypost-eco-list');
const mypostReceipeList = document.querySelector('.mypost-receipe-list');
const mypostFreeList = document.querySelector('.mypost-free-list');


//에코프로젝트 메뉴 눌렀을 때
mypostEco.addEventListener('click', () => {
    mypostEco.classList.add('active');
    mypostReceipe.classList.remove('active');
    mypostFree.classList.remove('active');
    mypostEcoList.classList.remove('hidden');
    mypostReceipeList.classList.add('hidden');
    mypostFreeList.classList.add('hidden');
});

//레시피 메뉴 눌렀을 때
mypostReceipe.addEventListener('click', () => {
  mypostEco.classList.remove('active');
  mypostReceipe.classList.add('active');
  mypostFree.classList.remove('active');
  mypostEcoList.classList.add('hidden');
  mypostReceipeList.classList.remove('hidden');
  mypostFreeList.classList.add('hidden');
});

//자유게시판 메뉴 눌렀을 때
mypostFree.addEventListener('click', () => {
  mypostEco.classList.remove('active');
  mypostReceipe.classList.remove('active');
  mypostFree.classList.add('active');
  mypostEcoList.classList.add('hidden');
  mypostReceipeList.classList.add('hidden');
  mypostFreeList.classList.remove('hidden');
});
