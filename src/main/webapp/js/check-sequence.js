const sequenceElements = document.querySelectorAll('select[name="sequence"]');
const buttonElement = document.querySelector('#button');
const errorSequenceElement = document.querySelector('#error-sequence');

sequenceElements.forEach(function(element) {
    element.addEventListener('change', function() {
        const values = Array.from(sequenceElements).map(function(el) {
            return el.value;
        });

        if (hasDuplicates(values)) {
            buttonElement.style.display = "none";
            errorSequenceElement.style.display = "block";
        } else {
            buttonElement.style.display = "block";
            errorSequenceElement.style.display = "none";
        }
    });
});

function hasDuplicates(array) {
    const uniqueValues = new Set(array);
    return uniqueValues.size !== array.length;
}