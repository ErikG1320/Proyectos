import java.util.Scanner;

public class primos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese cuántos números primos desea imprimir: ");
        int n = scanner.nextInt();
        int count = 0, i = 2;
        while (count < n) {
            boolean esPrimo = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    esPrimo = false;
                    break;
                }
            }
            if (esPrimo) {
                System.out.println(i);
                count++;
            }
            i++;
        }
        scanner.close();
    }
}
