import java.util.Scanner;

public class operacion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingrese el primer número entero: ");
        int numero1 = input.nextInt();
        System.out.print("Ingrese el segundo número entero: ");
        int numero2 = input.nextInt();

        // SUMA
        int suma = numero1 + numero2;
        System.out.println("SUMA: " + suma);

        // DIFERENCIA
        int diferencia = numero1 - numero2;
        System.out.println("DIFERENCIA: " + diferencia);

        // PRODUCTO
        int producto = numero1 * numero2;
        System.out.println("PRODUCTO: " + producto);

        // DIVISIÓN
        double division = numero1 / (double)numero2;
        System.out.println("DIVISIÓN: " + division);

        // POTENCIA
        double potencia = Math.pow(numero1, numero2);
        System.out.println("POTENCIA: " + potencia);

        // RAÍZ CUADRADA de cada número
        double raizCuadrada1 = Math.sqrt(numero1);
        double raizCuadrada2 = Math.sqrt(numero2);
        System.out.println("RAÍZ CUADRADA del primer número: " + raizCuadrada1);
        System.out.println("RAÍZ CUADRADA del segundo número: " + raizCuadrada2);

        input.close();
    }
}
