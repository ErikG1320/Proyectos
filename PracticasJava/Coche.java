public class Coche {
//Atributos
    String marca;
    String modelo;
    int año;
    int kilometraje;
    int placa;
    public static void main(String[] args) {
        Coche coche1=new Coche();
        coche1.marca="Ford";
        coche1.modelo="Mustang";
        coche1.año=2018;
        coche1.kilometraje=2000;
        coche1.placa=123456;
        System.out.println("La marca del coche es:"+coche1.marca);
        System.out.println("El modelo del coche es:"+coche1.modelo);
        System.out.println("El año del coche es:"+coche1.año);
        System.out.println("El kilometraje del coche es:"+coche1.kilometraje);
        System.out.println("La placa del coche es:"+coche1.placa);
        Coche coche2=new Coche();
        coche2.marca="Mercedes";
        coche2.modelo="C200";
        coche2.año=2019;
        coche2.kilometraje=2500;
        coche2.placa=654321;
        System.out.println("La marca del coche es:"+coche2.marca);
        System.out.println("El modelo del coche es:"+coche2.modelo);
        System.out.println("El año del coche es:"+coche2.año);
        System.out.println("El kilometraje del coche es:"+coche2.kilometraje);
        System.out.println("La placa del coche es:"+coche2.placa);
    }
}