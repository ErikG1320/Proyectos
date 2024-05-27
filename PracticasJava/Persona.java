
public class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public void mostrardatos(){
        System.out.println("Tu Nombre es : "+ nombre);
        System.out.println("Tu Edad es: "+ edad);
        }
    public static void main(String[] args) {
        Persona p1=new Persona("Erik",17);
        p1.mostrardatos();
    }
}