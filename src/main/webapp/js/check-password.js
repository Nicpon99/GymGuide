const pass1Element = document.querySelector('#pass1');
const pass2Element = document.querySelector('#pass2')
const errorMessageElement = document.querySelector('#error-message');
const buttonElement = document.querySelector('#button');

pass1Element.addEventListener('input', function(){
    if (pass1Element.value === "" || pass1Element.value !== pass2Element.value) {
        buttonElement.style.display = 'none';
        errorMessageElement.style.display = 'block';
    } else {
        buttonElement.style.display = 'block';
        errorMessageElement.style.display = 'none';
    }
});

pass2Element.addEventListener('input', function(){
    if (pass1Element.value === "" || pass1Element.value !== pass2Element.value) {
        buttonElement.style.display = 'none';
        errorMessageElement.style.display = 'block';
    } else {
        buttonElement.style.display = 'block';
        errorMessageElement.style.display = 'none';
    }
});
