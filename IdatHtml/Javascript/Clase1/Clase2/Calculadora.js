function cuadrado(){
    let num = document.getElementById("n1");
    document.getElementById("n1").value = parseInt(num.value) * parseInt(num.value);
}
 function vaciar() {
     document.getElementById("n1").value = "";
 }
 function raizcuadrada() {
    let num = document.getElementById("n1");
    const valor = parseFloat(num.value);
    const raiz = Math.sqrt(valor);
    document.getElementById("n1").value = raiz;
}
function inversa(){
    let num = document.getElementById("n1");
    document.getElementById("n1").value = 1 / parseFloat(num.value);
}
const botoninversa=()=>{
    let num = document.getElementById("n1");
    num.value=num.value*numero.value;
}
let inversa=document.getElementById("inversa_n1");
botoninversa.AddEventListener("click",inversa);
 function restar(){
     let num1 = document.getElementById("n1");
     let num2 = document.getElementById("n2");
     let num3 = document.getElementById("n3");
     num3.value = parseInt(num1.value) - parseInt(num2.value);
 }
 function multiplicar(){
     let num1 = document.getElementById("n1");
     let num2 = document.getElementById("n2");
     let num3 = document.getElementById("n3");
     num3.value = parseInt(num1.value) * parseInt(num2.value);
 }
 function dividir(){
     let num1 = document.getElementById("n1");
     let num2 = document.getElementById("n2");
     num3.value = parseInt(num1.value) / parseInt(num2.value);
 }