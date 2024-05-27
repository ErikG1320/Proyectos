import java.util.Scanner;

public class perro {
    // Atributos
    String nombre;
    int edad;
    String raza;

    // Constructor
    public perro(String nombre, int edad, String raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
    }

    // Métodos
    public void ladrar() {
        System.out.println("Guau Guau");
    }
    
    public void mostrarEdadEnAnosHumanos() {
        System.out.println("La edad en años humanos es: " + edad * 7);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del perro:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la edad del perro:");
        int edad = scanner.nextInt(); // Cambiado a 'int' para leer un entero
        scanner.nextLine(); // Consumir la nueva línea restante
        System.out.println("Ingrese la raza del perro:");
        String raza = scanner.nextLine();

        perro miPerro = new perro(nombre, edad, raza);

        // Ejecutar métodos
        miPerro.ladrar();
        miPerro.mostrarEdadEnAnosHumanos();

        scanner.close(); // Para cerrar el escáner
    }
}
