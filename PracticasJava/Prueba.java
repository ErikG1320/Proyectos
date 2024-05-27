import javax.swing.JOptionPane;
public class Prueba {
    public static void main(String[] args) {
        int edad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad"));
        String nombre=JOptionPane.showInputDialog("Ingrese su nombre");
        String apellido=JOptionPane.showInputDialog("Ingrese su apellido");
        double altura=Double.parseDouble(JOptionPane.showInputDialog("Ingrese su altura"));
        double peso=Double.parseDouble(JOptionPane.showInputDialog("Ingrese su peso"));
        String dni=JOptionPane.showInputDialog("Ingrese su dni");

        // JOptionPane.showMessageDialog(null,"Tu edad es :" +edad);
        // JOptionPane.showMessageDialog(null,"Tu nombre es :" +nombre);
        // JOptionPane.showMessageDialog(null,"Tu apellido es :" +apellido);
        // JOptionPane.showMessageDialog(null,"Tu altura es :" +altura);
        // JOptionPane.showMessageDialog(null, dni);
        System.out.println("Tu nombre es "+nombre);
        System.out.println("Tu apellido es "+apellido);
        System.out.println("Tu edad es "+edad);
        System.out.println("Tu altura es "+altura);
        System.out.println("Tu peso es "+peso);
        System.out.println("Tu dni es "+dni);
    }
}