import java.util.Scanner;
public class numeroentero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingresa un numero: ");
        int num = input.nextInt();
        System.out.println("El numero ingresado es: " + num);
        if(num>0){
            System.out.println("El numero es positivo");
        }
        else if(num<0){
            System.out.println("El numero es negativo");
        }
        else if(num==0){
            System.out.println("El numero es cero");
        }
        input.close();
    }
}
