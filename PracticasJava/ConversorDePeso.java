import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Conversordepeso {
    private static final Map<String, Double> FACTORES_CONVERSION = new HashMap<>();
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
        frame.setSize(400, 220);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel userLabel = new JLabel("Valor:");
        JTextField userText = new JTextField(10);
        JLabel origenLabel = new JLabel("Unidad Origen:");
        JComboBox<String> origenComboBox = new JComboBox<>(new String[]{"libra", "miligramo", "gramo", "kilogramo", "tonelada"});
        JLabel destinoLabel = new JLabel("Unidad Destino:");
        JComboBox<String> destinoComboBox = new JComboBox<>(new String[]{"libra", "miligramo", "gramo", "kilogramo", "tonelada"});
        JButton convertirButton = new JButton("Convertir");
        JLabel resultadoLabel = new JLabel("Resultado:");

        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                convertir();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                convertir();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                convertir();
            }

            private void convertir() {
                try {
                    double valor = Double.parseDouble(userText.getText());
                    String unidadOrigen = (String) origenComboBox.getSelectedItem();
                    String unidadDestino = (String) destinoComboBox.getSelectedItem();
                    double valorConvertido = Conversordepeso.convertir(valor, unidadOrigen, unidadDestino);
                    resultadoLabel.setText("Resultado: " + valorConvertido + " " + unidadDestino);
                } catch (NumberFormatException ex) {
                    // Ignora el error si el texto no es un número válido
                }
            }
        };

        userText.getDocument().addDocumentListener(documentListener);
        origenComboBox.addActionListener(e -> documentListener.insertUpdate(null));
        destinoComboBox.addActionListener(e -> documentListener.insertUpdate(null));

        frame.add(userLabel);
        frame.add(userText);
        frame.add(origenLabel);
        frame.add(origenComboBox);
        frame.add(destinoLabel);
        frame.add(destinoComboBox);
        frame.add(convertirButton);
        frame.add(resultadoLabel);

        frame.setVisible(true);
    }
}