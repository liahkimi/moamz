const eatTogetherBtn = document.getElementById('eat-together-btn');
const goTogetherBtn = document.getElementById('go-together-btn');
const volunteerBtn = document.getElementById('volunteer-btn');
const hobbyBtn = document.getElementById('hobby-btn');
const activityBtn = document.getElementById('activity-btn');
const improvementBtn =document.getElementById('improvement-btn');
const challengeBtn = document.getElementById('challenge-btn');

const eatTogetherList = document.getElementById('eat-together-list');
const goTogetherList= document.getElementById('go-together-list');
const volunteerList = document.getElementById('volunteer-list');
const hobbyList=document.getElementById('hobby-list');
const activityList = document.getElementById('activity-list');
const improvementList = document.getElementById('improvement-list');
const challengeList = document.getElementById('challenge-list');

const searchBtn = document.querySelector('.search-btn');

eatTogetherBtn.addEventListener('click',()=>{
    eatTogetherBtn.classList.add('active');
    goTogetherBtn.classList.remove('active');
    volunteerBtn.classList.remove('active');
    hobbyBtn.classList.remove('active');
    activityBtn.classList.remove('active');
    improvementBtn.classList.remove('active');
    challengeBtn.classList.remove('active');

    eatTogetherList.classList.remove('hidden');
    goTogetherList.classList.add('hidden');
    volunteerList.classList.add('hidden');
    hobbyList.classList.add('hidden');
    activityList.classList.add('hidden');
    improvementList.classList.add('hidden');
    challengeList.classList.add('hidden');

});

goTogetherBtn.addEventListener('click',()=>{
    eatTogetherBtn.classList.remove('active');
    goTogetherBtn.classList.add('active');
    volunteerBtn.classList.remove('active');
    hobbyBtn.classList.remove('active');
    activityBtn.classList.remove('active');
    improvementBtn.classList.remove('active');
    challengeBtn.classList.remove('active');

    eatTogetherList.classList.add('hidden');
    goTogetherList.classList.remove('hidden');
    volunteerList.classList.add('hidden');
    hobbyList.classList.add('hidden');
    activityList.classList.add('hidden');
    improvementList.classList.add('hidden');
    challengeList.classList.add('hidden');

});
volunteerBtn.addEventListener('click',()=>{
    eatTogetherBtn.classList.remove('active');
    goTogetherBtn.classList.remove('active');
    volunteerBtn.classList.add('active');
    hobbyBtn.classList.remove('active');
    activityBtn.classList.remove('active');
    improvementBtn.classList.remove('active');
    challengeBtn.classList.remove('active');

    eatTogetherList.classList.add('hidden');
    goTogetherList.classList.add('hidden');
    volunteerList.classList.remove('hidden');
    hobbyList.classList.add('hidden');
    activityList.classList.add('hidden');
    improvementList.classList.add('hidden');
    challengeList.classList.add('hidden');

});
hobbyBtn.addEventListener('click',()=>{
    eatTogetherBtn.classList.remove('active');
    goTogetherBtn.classList.remove('active');
    volunteerBtn.classList.remove('active');
    hobbyBtn.classList.add('active');
    activityBtn.classList.remove('active');
    improvementBtn.classList.remove('active');
    challengeBtn.classList.remove('active');

    eatTogetherList.classList.add('hidden');
    goTogetherList.classList.add('hidden');
    volunteerList.classList.add('hidden');
    hobbyList.classList.remove('hidden');
    activityList.classList.add('hidden');
    improvementList.classList.add('hidden');
    challengeList.classList.add('hidden');

});
activityBtn.addEventListener('click',()=>{
    eatTogetherBtn.classList.remove('active');
    goTogetherBtn.classList.remove('active');
    volunteerBtn.classList.remove('active');
    hobbyBtn.classList.remove('active');
    activityBtn.classList.add('active');
    improvementBtn.classList.remove('active');
    challengeBtn.classList.remove('active');

    eatTogetherList.classList.add('hidden');
    goTogetherList.classList.add('hidden');
    volunteerList.classList.add('hidden');
    hobbyList.classList.add('hidden');
    activityList.classList.remove('hidden');
    improvementList.classList.add('hidden');
    challengeList.classList.add('hidden');

});
improvementBtn.addEventListener('click',()=>{
    eatTogetherBtn.classList.remove('active');
    goTogetherBtn.classList.remove('active');
    volunteerBtn.classList.remove('active');
    hobbyBtn.classList.remove('active');
    activityBtn.classList.remove('active');
    improvementBtn.classList.add('active');
    challengeBtn.classList.remove('active');

    eatTogetherList.classList.add('hidden');
    goTogetherList.classList.add('hidden');
    volunteerList.classList.add('hidden');
    hobbyList.classList.add('hidden');
    activityList.classList.add('hidden');
    improvementList.classList.remove('hidden');
    challengeList.classList.add('hidden');

});
challengeBtn.addEventListener('click',()=>{
    eatTogetherBtn.classList.remove('active');
    goTogetherBtn.classList.remove('active');
    volunteerBtn.classList.remove('active');
    hobbyBtn.classList.remove('active');
    activityBtn.classList.remove('active');
    improvementBtn.classList.remove('active');
    challengeBtn.classList.add('active');

    eatTogetherList.classList.add('hidden');
    goTogetherList.classList.add('hidden');
    volunteerList.classList.add('hidden');
    hobbyList.classList.add('hidden');
    activityList.classList.add('hidden');
    improvementList.classList.add('hidden');
    challengeList.classList.remove('hidden');

});


// 이미 유저가 직접 생성한 소셜링이 있는 경우,
searchBtn.addEventListener('click',()=>{
    alert('이미 생성한 소셜링이 있습니다!\n소셜링 생성은 1회만 가능합니다!');
})