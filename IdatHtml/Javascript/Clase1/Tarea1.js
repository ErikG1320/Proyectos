const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
  });
  
  readline.question('Ingresa un número para ver su tabla de multiplicar: ', numero => {
    numero = parseInt(numero);
    mostrarTablaMultiplicar(numero);
    readline.close();
  });
  
  function mostrarTablaMultiplicar(numero) {
    console.log(`Tabla de multiplicar del ${numero}:`);
    for (let i = 1; i <= 10; i++) {
      console.log(`${numero} x ${i} = ${numero * i}`);
    }
  }
  