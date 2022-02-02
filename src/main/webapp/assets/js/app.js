const closeBtn = document.querySelector(".close");
closeBtn.addEventListener("click", () => {
    switchFormVisibility();
});

const switchFormVisibility = () => {
    const form = document.querySelector(".form");
    alert(form.getAttributeNames());
}