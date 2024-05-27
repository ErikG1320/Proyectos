package com.Proyectosjava;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class FormularioAlumno extends JFrame implements ActionListener {
    private JTextField txtMatricula, txtNombres, txtApellidoPaterno, txtApellidoMaterno, txtTelefono, txtDireccion;
    private JSpinner spEdad;
    private JComboBox<String> cbGenero;
    private JTable tablaAlumnos;
    private DefaultTableModel modeloTabla;

    public FormularioAlumno() {
        setTitle("Insertar Alumno");
        setLayout(new BorderLayout());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        connectToDatabase();

        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;

        txtMatricula = new JTextField();
        txtNombres = new JTextField();
        txtApellidoPaterno = new JTextField();
        txtApellidoMaterno = new JTextField();
        txtTelefono = new JTextField();
        txtDireccion = new JTextField();
        spEdad = new JSpinner(new SpinnerNumberModel(18, 0, 100, 1));
        cbGenero = new JComboBox<>(new String[]{"M", "F"});

        panelFormulario.add(new JLabel("Matricula:"), c);
        c.gridy++;
        panelFormulario.add(txtMatricula, c);
        c.gridy++;
        panelFormulario.add(new JLabel("Nombre:"), c);
        c.gridy++;
        panelFormulario.add(txtNombres, c);
        c.gridy++;
        panelFormulario.add(new JLabel("Apellido Paterno:"), c);
        c.gridy++;
        panelFormulario.add(txtApellidoPaterno, c);
        c.gridy++;
        panelFormulario.add(new JLabel("Apellido Materno:"), c);
        c.gridy++;
        panelFormulario.add(txtApellidoMaterno, c);
        c.gridy++;
        panelFormulario.add(new JLabel("Edad:"), c);
        c.gridy++;
        panelFormulario.add(spEdad, c);
        c.gridy++;
        panelFormulario.add(new JLabel("Genero:"), c);
        c.gridy++;
        panelFormulario.add(cbGenero, c);
        c.gridy++;
        panelFormulario.add(new JLabel("Telefono:"), c);
        c.gridy++;
        panelFormulario.add(txtTelefono, c);
        c.gridy++;
        panelFormulario.add(new JLabel("Direccion:"), c);
        c.gridy++;
        panelFormulario.add(txtDireccion, c);

        // Botones
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnnuevo = new JButton("Nuevo");
        JButton btnGuardar = new JButton("Guardar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnSalir = new JButton("Salir");
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnnuevo);
        panelBotones.add(btnGuardar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnSalir);

        // Tabla de alumnos
        String[] titulos = {"Matricula", "Nombre", "A.paterno", "A.materno", "Edad", "Genero", "Telefono", "Direccion"};
        modeloTabla = new DefaultTableModel(titulos, 0);
        tablaAlumnos = new JTable(modeloTabla);

        // Agregar componentes al frame
        add(panelFormulario, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(new JScrollPane(tablaAlumnos), BorderLayout.SOUTH);

        // Agregar listeners a los botones
        btnLimpiar.addActionListener(this);
        btnGuardar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnSalir.addActionListener(this);

        // Mostrar ventana
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new FormularioAlumno();
    }

    private void connectToDatabase() {
        String url = "jdbc:mysql://localhost:7070/proyecto";
        String user = "root";
        String password = "60797472";
        
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Conexion exitosa con la base de datos");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos " + e, "Error ", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Manejar eventos de los botones
        if (e.getActionCommand().equals("Limpiar")) {
            // Lógica para limpiar los campos del formulario
            txtMatricula.setText("");
            txtNombres.setText("");
            txtApellidoPaterno.setText("");
            txtApellidoMaterno.setText("");
            txtTelefono.setText("");
            txtDireccion.setText("");
            spEdad.setValue(18);
            cbGenero.setSelectedIndex(0);
        } else if (e.getActionCommand().equals("Guardar")) {
            // Lógica para guardar el alumno en la base de datos
            guardarAlumno();
        } else if (e.getActionCommand().equals("Eliminar")) {
            // Lógica para eliminar el alumno seleccionado de la base de datos
            eliminarAlumno();
        } else if (e.getActionCommand().equals("Salir")) {
            // Lógica para salir de la aplicación
            System.exit(0);
        }
    }

    private void guardarAlumno() {
        String matricula = txtMatricula.getText();
        String nombres = txtNombres.getText();
        String apellidoPaterno = txtApellidoPaterno.getText();
        String apellidoMaterno = txtApellidoMaterno.getText();
        String telefono = txtTelefono.getText();
        String direccion = txtDireccion.getText();
        int edad = (int) spEdad.getValue();
        String genero = (String) cbGenero.getSelectedItem();
        String sql = "INSERT INTO alumnos (matricula, nombres, apellido_paterno, apellido_materno, edad, genero, telefono, direccion) VALUES (?,?,?,?,?,?,?,?)";


    }

    private void eliminarAlumno() {
        // Lógica para eliminar el alumno seleccionado de la base de datos
    }

    public void setSpEdad(JSpinner spEdad) {
        this.spEdad = spEdad;
    }
}
