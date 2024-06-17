const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
  });
  
  readline.question('Ingresa un número para sumar los pares hasta él: ', n => {
    n = parseInt(n);
    sumaNumerosPares(n);
    readline.close();
  });
  
  function sumaNumerosPares(n) {
    let suma = 0;
    let i = 1;
    while (i <= n) {
      if (i % 2 === 0) {
        suma += i;
      }
      i++;
    }
    console.log(`La suma de todos los números pares desde 1 hasta ${n} es: ${suma}`);
  }
  