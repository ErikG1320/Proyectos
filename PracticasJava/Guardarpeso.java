import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Guardarpeso {
    private static final Map<String, Double> FACTORES_CONVERSION = new HashMap<>();
    private static final Vector<String> historialConversiones = new Vector<>();
    static {
        FACTORES_CONVERSION.put("libra", 453.59237);
        FACTORES_CONVERSION.put("miligramo", 0.001);
        FACTORES_CONVERSION.put("gramo", 1.0);
        FACTORES_CONVERSION.put("kilogramo", 1000.0);
        FACTORES_CONVERSION.put("tonelada", 1000000.0);
    }

    public static double convertir(double valor, String unidadOrigen, String unidadDestino) {
        double valorEnGramos = valor * FACTORES_CONVERSION.get(unidadOrigen);
        return valorEnGramos / FACTORES_CONVERSION.get(unidadDestino);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Conversor de Peso");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel userLabel = new JLabel("Valor:");
        JTextField userText = new JTextField(10);
        JLabel origenLabel = new JLabel("Unidad Origen:");
        JComboBox<String> origenComboBox = new JComboBox<>(new String[]{"libra", "miligramo", "gramo", "kilogramo", "tonelada"});
        JLabel destinoLabel = new JLabel("Unidad Destino:");
        JComboBox<String> destinoComboBox = new JComboBox<>(new String[]{"libra", "miligramo", "gramo", "kilogramo", "tonelada"});
        JButton convertirButton = new JButton("Convertir");
        JLabel resultadoLabel = new JLabel("Resultado:");
        JList<String> historialList = new JList<>(historialConversiones);
        JScrollPane historialScroll = new JScrollPane(historialList);
        JButton guardarHistorialButton = new JButton("Guardar Historial");

        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = Double.parseDouble(userText.getText());
                    String unidadOrigen = (String) origenComboBox.getSelectedItem();
                    String unidadDestino = (String) destinoComboBox.getSelectedItem();
                    double valorConvertido = convertir(valor, unidadOrigen, unidadDestino);
                    String resultado = "Resultado: " + valorConvertido + " " + unidadDestino;
                    resultadoLabel.setText(resultado);
                    historialConversiones.add(resultado);
                    historialList.setListData(historialConversiones);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese un número válido.");
                }
            }
        });

        guardarHistorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (FileWriter writer = new FileWriter("historial.txt")) {
                    for (String conversion : historialConversiones) {
                        writer.write(conversion + System.lineSeparator());
                    }
                    JOptionPane.showMessageDialog(frame, "Historial guardado exitosamente.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error al guardar el historial.");
                }
            }
        });

        historialScroll.setPreferredSize(new Dimension(350, 100));

        frame.add(userLabel);
        frame.add(userText);
        frame.add(origenLabel);
        frame.add(origenComboBox);
        frame.add(destinoLabel);
        frame.add(destinoComboBox);
        frame.add(convertirButton);
        frame.add(resultadoLabel);
        frame.add(historialScroll);
        frame.add(guardarHistorialButton);

        frame.setVisible(true);
    }
}