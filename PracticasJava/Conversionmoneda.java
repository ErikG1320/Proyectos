import java.util.Scanner;

public class Conversionmoneda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese la cantidad de soles: ");
        double soles = scanner.nextDouble();
        
        double dolares = soles / 3.85;
        double euros = soles / 4;
        
        System.out.println(soles + " soles es igual a " + dolares + " dólares.");
        System.out.println(soles + " soles es igual a " + euros + " euros.");
        
        scanner.close();
    }
}
