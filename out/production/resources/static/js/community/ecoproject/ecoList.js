let onGoingBtn = document.getElementById('ongoing-eco__btn');
let endBtn = document.getElementById('finished-eco__btn');
let onGoingDiv = document.getElementById('ongoing-eco');
let endDiv = document.getElementById('finished-eco');

onGoingBtn.addEventListener('click', () => {
    onGoingDiv.style.display = 'block';
    endDiv.style.display = 'none';
    onGoingBtn.classList.add('active-btn');
    endBtn.classList.remove('active-btn');
    console.log('asdas');
});

endBtn.addEventListener('click', () =>{
    onGoingDiv.style.display = 'none';
    endDiv.style.display = 'block';
    endBtn.classList.add('active-btn');
    onGoingBtn.classList.remove('active-btn');
})