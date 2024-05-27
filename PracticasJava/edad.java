import java.util.Scanner;

public class edad {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int edad = -1;

        while (edad < 0) {
            System.out.print("Ingresa tu edad: ");
            edad = input.nextInt();

            if (edad < 0) {
                System.out.println("Error: La edad no puede ser un número negativo. Por favor, intenta de nuevo.");
            }
        }

        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        } else if (edad < 18) {
            System.out.println("Eres menor de edad");
        }

        input.close();
    }
}
