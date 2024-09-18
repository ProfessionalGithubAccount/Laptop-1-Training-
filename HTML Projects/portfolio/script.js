function toggleMenu(){
    // This function will be helpful in making the hamburger toggle 
    const menu=document.querySelector(".menu-links");
    // using the above line we are targeting all the about projects etc section
    const icon=document.querySelector(".hamburger-icon");

    menu.classList.toggle("open");
    icon.classList.toggle("open");


}