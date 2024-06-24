const mostrarmensaje=(event)=>{
    event.preventDefault();
    alert("Hiciste click derecho");
}
document.addEventListener("contextmenu",mostrarmensaje);