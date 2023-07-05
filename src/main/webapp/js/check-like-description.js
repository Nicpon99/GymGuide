const likeElement = document.querySelector('#like');
const likeButtonElement = document.querySelector('#likeButton');

const likeValue = likeElement.textContent;

if (likeValue === "false"){
    likeButtonElement.style.color = "green";
    likeButtonElement.innerText = "DODAJ DO ULUBIONYCH";
} else {
    likeButtonElement.style.color = "red";
    likeButtonElement.innerText = "USUŃ Z ULUBIONYCH";
}