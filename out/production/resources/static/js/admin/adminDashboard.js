let myShoppingChart = document.getElementById('shoppingChart');
let myEcoChart = document.getElementById('ecoCertifyChart');

let myShoppingCht = new Chart(myShoppingChart, {
  type: 'bar',
  data: {
    labels: ['2020', '2021', '2022', '2023'],
    datasets: [
      {
        label: '월별 쇼핑몰 총 구매 건 수 등락 추이',
        data: [10,20,30,40],
      }
    ]
  },
});

let myEcoCht = new Chart(myEcoChart, {
    type: 'bar',
    data: {
      labels: ['2020', '2021', '2022', '2023'],
      datasets: [
        {
          label: '월별 에코프로젝트 총 인증글 수 등락 추이',
          data: [10,20,30,40],
        }
      ]
    },
  });