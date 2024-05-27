import javax.swing.JOptionPane;

public class operaciones1 {
    public static void main(String[] args) {
        String menu = "----- Menú de Opciones -----\n" +
                    "----- Ingrese la operación -----\n" +
                    "1. Suma\n2. Resta\n3. Multiplicación\n4. División\n5. Potenciación\n6. Salir";
        int opcion;
        double num1, num2, resultado;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcion) {
                case 1: // Suma
                    num1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer número:"));
                    num2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el segundo número:"));
                    resultado = num1 + num2;
                    JOptionPane.showMessageDialog(null, "El resultado de la suma es: " + resultado);
                    break;
                case 2: // Resta
                    num1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer número:"));
                    num2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el segundo número:"));
                    resultado = num1 - num2;
                    JOptionPane.showMessageDialog(null, "El resultado de la resta es: " + resultado);
                    break;
                case 3: // Multiplicación
                    num1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el primer número:"));
                    num2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el segundo número:"));
                    resultado = num1 * num2;
                    JOptionPane.showMessageDialog(null, "El resultado de la multiplicación es: " + resultado);
                    break;
                case 4: // División
                    num1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el numerador:"));
                    num2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el denominador:"));
                    if (num2 != 0) {
                        resultado = num1 / num2;
                        JOptionPane.showMessageDialog(null, "El resultado de la división es: " + resultado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: No se puede dividir por cero.");
                    }
                    break;
                case 5: // Potenciación
                    num1 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la base:"));
                    num2 = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el exponente:"));
                    resultado = Math.pow(num1, num2);
                    JOptionPane.showMessageDialog(null, "El resultado de la potenciación es: " + resultado);
                    break;
                case 6: // Salir
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, ingrese una opción del 1 al 6.");
                    break;
            }
        } while (opcion != 6);
    }
}
