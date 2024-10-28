
window.onload = function() {
    var mapContainer = document.getElementById('productDetail-map'); 
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
  