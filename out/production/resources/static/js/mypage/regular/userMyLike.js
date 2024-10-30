const mylikeStore = document.getElementById('mylike-store-btn');
const mylikeEco = document.getElementById('mylike-eco-btn');
const mylikeReceipe = document.getElementById('mylike-receipe-btn');
const mylikeFree = document.getElementById('mylike-free-btn');
const mylikeStoreList = document.querySelector('.mylike-store-list');
const mylikeEcoList = document.querySelector('.mylike-eco-list');
const mylikeReceipeList = document.querySelector('.mylike-receipe-list');
const mylikeFreeList = document.querySelector('.mylike-free-list');




//업체 메뉴 눌렀을 때
mylikeStore.addEventListener('click', () => {
    mylikeStore.classList.add('active');
    mylikeEco.classList.remove('active');
    mylikeReceipe.classList.remove('active');
    mylikeFree.classList.remove('active');
    mylikeStoreList.classList.remove('hidden');
    mylikeEcoList.classList.add('hidden');
    mylikeReceipeList.classList.add('hidden');
    mylikeFreeList.classList.add('hidden');
});

//에코프로젝트 메뉴 눌렀을 때
mylikeEco.addEventListener('click', () => {
  mylikeStore.classList.remove('active');
  mylikeEco.classList.add('active');
  mylikeReceipe.classList.remove('active');
  mylikeFree.classList.remove('active');
  mylikeStoreList.classList.add('hidden');
  mylikeEcoList.classList.remove('hidden');
  mylikeReceipeList.classList.add('hidden');
  mylikeFreeList.classList.add('hidden');
});

//레시피 메뉴 눌렀을 때
mylikeReceipe.addEventListener('click', () => {
  mylikeStore.classList.remove('active');
  mylikeEco.classList.remove('active');
  mylikeReceipe.classList.add('active');
  mylikeFree.classList.remove('active');
  mylikeStoreList.classList.add('hidden');
  mylikeEcoList.classList.add('hidden');
  mylikeReceipeList.classList.remove('hidden');
  mylikeFreeList.classList.add('hidden');
});

//자유게시판 메뉴 눌렀을 때
mylikeFree.addEventListener('click', () => {
  mylikeStore.classList.remove('active');
  mylikeEco.classList.remove('active');
  mylikeReceipe.classList.remove('active');
  mylikeFree.classList.add('active');
  mylikeStoreList.classList.add('hidden');
  mylikeEcoList.classList.add('hidden');
  mylikeReceipeList.classList.add('hidden');
  mylikeFreeList.classList.remove('hidden');
});