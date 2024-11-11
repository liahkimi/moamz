let onGoingBtn = document.getElementById('ongoing-eco__btn');
let endBtn = document.getElementById('finished-eco__btn');
let onGoingDiv = document.getElementById('ongoing-eco');
let endDiv = document.getElementById('finished-eco');

onGoingBtn.addEventListener('click', () => {
    onGoingDiv.style.display = 'block';
    endDiv.style.display = 'none';
    onGoingBtn.classList.add('active-btn');
    endBtn.classList.remove('active-btn');
    onGoingDiv.classList.remove('banner-hidden');
    endDiv.classList.add('banner-hidden');
    console.log('asdas');
});

endBtn.addEventListener('click', () =>{
    onGoingDiv.style.display = 'none';
    endDiv.style.display = 'block';
    endBtn.classList.add('active-btn');
    endDiv.classList.remove('banner-hidden');
    onGoingBtn.classList.remove('active-btn')
    onGoingDiv.classList.add('banner-hidden');
})