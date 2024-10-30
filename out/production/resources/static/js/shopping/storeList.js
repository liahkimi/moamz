
window.onload = function() {
    var mapContainer = document.getElementById('storeList-map'); 
    if (mapContainer) {
      var mapOption = { 
        center: new kakao.maps.LatLng(37.497, 127.036), 
        level: 3 
      };
  
      var map = new kakao.maps.Map(mapContainer, mapOption);
    } else {
      console.error('지도 없어요');
    }
  };

//   document.addEventListener('DOMContentLoaded', () => {
//     let storeProduct = document.getElementById('product');
//     storeInfo.addEventListener('click', () => {
//         storeProduct.style.color = 'black';
//         console.log('asdas');
//     });
// });
let storeInfo = document.getElementById('intro');
let storeProduct = document.getElementById('product');
let storeReview = document.getElementById('review');

let infoBox = document.getElementById('infoBox');
let productBox = document.getElementById('productBox');
let reviewBox = document.getElementById('reviewBox');

storeProduct.addEventListener('click', ()=>{
  // console.log('asdsa');
  storeProduct.style.color = "#000000";
  storeInfo.style.color = '#d9d9d9';
  storeReview.style.color = '#d9d9d9';
  infoBox.style.display = "none";
  productBox.style.display = "block";
  reviewBox.style.display = "none";
});

storeInfo.addEventListener('click', ()=>{
  // console.log('asdsa');
  storeProduct.style.color = "#d9d9d9";
  storeInfo.style.color = '#000000';
  storeReview.style.color = '#d9d9d9';
  infoBox.style.display = "block";
  productBox.style.display = "none";
  reviewBox.style.display = "none";
});

storeReview.addEventListener('click', ()=>{
  // console.log('asdsa');
  storeProduct.style.color = "#d9d9d9";
  storeInfo.style.color = '#d9d9d9';
  storeReview.style.color = '#000000';
  infoBox.style.display = "none";
  productBox.style.display = "none";
  reviewBox.style.display = "block";
});


