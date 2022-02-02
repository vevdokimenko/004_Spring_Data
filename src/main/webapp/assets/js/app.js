const switchFormVisibility = (id) => {
    document.querySelector(id).classList.toggle("active");
    document.querySelector('.dark').classList.toggle("active");
}