const girardivdos=()=>{
    let div2=document.querySelectorAll("dos");
    div2.forEach(div=>{
        div.style.transform="rotate(90deg)";
    });
}
const cargarimg=()=>{
    let div2=document.getElementById("dos")
    div2.innerHTML = '<img src="HTML.jpeg" style="width:100%: height:100%:"></img>'
}