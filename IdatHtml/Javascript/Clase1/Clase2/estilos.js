const estilos=()=>{
    let divs=document.querySelectorAll(".cajas");
    divs.forEach(div=>{
        div.style.width="150px";
        div.style.height="150px";
        div.style.backgroundColor="red";
        div.style.border="solid 1px blue";
        div.style.margin="10px";
    });
}

const cambiandocolor=()=>{
    let divs=document.querySelectorAll(".cajas");
    divs.forEach(div=>{
        div.style.backgroundColor="#7FFFD4";
    });
}