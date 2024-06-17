const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
  });
  
  const adivinarNumero = () => {
    const numeroSecreto = Math.floor(Math.random() * 100) + 1;
    let intentos = 0;
  
    const preguntarNumero = () => {
      readline.question('Adivina el número entre 1 y 100: ', (numero) => {
        intentos++;
        numero = parseInt(numero);
        if (numero === numeroSecreto) {
          console.log(`¡Correcto! El número era ${numeroSecreto}. Lo adivinaste en ${intentos} intentos.`);
          readline.close();
        } else if (numero < numeroSecreto) {
          console.log('Demasiado bajo. Intenta de nuevo.');
          preguntarNumero();
        } else if (numero > numeroSecreto) {
          console.log('Demasiado alto. Intenta de nuevo.');
          preguntarNumero();
        } else {
          console.log('Por favor, ingresa un número válido.');
          preguntarNumero();
        }
      });
    };
    preguntarNumero();
  };
  
  adivinarNumero();
  