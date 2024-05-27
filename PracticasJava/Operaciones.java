import java.util.Scanner;

public class Operaciones {
    //Atributos
    int numero1;
    int numero2;
    int suma;
    int resta;
    int multiplicacion;
    int division;
    //Metodos

    public void sumar(int numero1,int numero2) {
        suma=numero1+numero2;
    }

    public void restar(int numero1,int numero2) {
        resta=numero1-numero2;
    }

    public void multiplicar(int numero1,int numero2) {
        multiplicacion=numero1*numero2;
    }

    public void division(int numero1,int numero2) {
        division=numero1/numero2;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite un numero: ");
        int n1 = input.nextInt();
        System.out.print("Digite otro numero: ");
        int n2 = input.nextInt();

        Operaciones operaciones=new Operaciones();
        operaciones.sumar(n1,n2);
        operaciones.restar(n1,n2);
        operaciones.multiplicar(n1,n2);
        operaciones.division(n1,n2);
        System.out.println("La suma es: "+operaciones.suma);
        System.out.println("La resta es: "+operaciones.resta);
        System.out.println("La multiplicacion es: "+operaciones.multiplicacion);
        System.out.println("La division es: "+operaciones.division);

        input.close();
    }
}
