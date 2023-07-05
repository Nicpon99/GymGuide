const likeElements = document.querySelectorAll('#like')
const likeButtonElements = document.querySelectorAll('#likeButton');

for (let i = 0; i < likeElements.length; i++){
    const likeValue = likeElements[i].textContent;

    if (likeValue === "false"){
        likeButtonElements[i].style.color = "green";
        likeButtonElements[i].innerText = "Dodaj do ulubionych";
    } else {
        likeButtonElements[i].style.color = "red";
        likeButtonElements[i].innerText = "Usuń z ulubionych";
    }
}