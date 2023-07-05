const seriesElements = document.querySelectorAll('#series');
const buttonElement = document.querySelector('#button');
const errorSeriesElement = document.querySelector('#error-series');



seriesElements.forEach(function(element) {
    element.addEventListener('input', function() {
        if (element.value === '') {
            buttonElement.style.display = "none";
            errorSeriesElement.style.display = "block"
        } else {
            buttonElement.style.display = "block";
            errorSeriesElement.style.display = "none"
        }
    });
});








