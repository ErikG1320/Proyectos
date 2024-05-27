package com.Proyectosjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Proyecto {

    private JFrame frame;
    private JTextField userField;
    private JPasswordField passwordField;
    private Connection connection;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Proyecto window = new Proyecto();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Proyecto() {
        initialize();
        connectToDatabase();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);
        frame.setTitle("Login");

        JLabel lblNewLabel = new JLabel("Bienvenido al sistema");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 11, 420, 27);
        frame.getContentPane().add(lblNewLabel);

        userField = new JTextField();
        userField.setBounds(190, 70, 96, 20);
        frame.getContentPane().add(userField);
        userField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(190, 101, 96, 20);
        frame.getContentPane().add(passwordField);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(109, 73, 75, 14);
        frame.getContentPane().add(lblUsuario);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setBounds(109, 104, 75, 14);
        frame.getContentPane().add(lblContraseña);

        JButton btnLogin = new JButton("Iniciar sesión");
        btnLogin.setBounds(175, 132, 120, 23);
        frame.getContentPane().add(btnLogin);

        // Agrega un ActionListener al botón de inicio de sesión
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtiene el nombre de usuario y la contraseña ingresados por el usuario
                String username = userField.getText();
                String password = new String(passwordField.getPassword());

                // Realiza la consulta a la base de datos para verificar las credenciales
                try {
                    String query = "SELECT * FROM Usuarios WHERE Usuario = ? AND Contraseña = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, username);
                    statement.setString(2, password);

                    // Ejecutar la consulta
                    if (statement.executeQuery().next()) {
                        // Usuario autenticado correctamente
                        JOptionPane.showMessageDialog(frame, "¡Inicio de sesión exitoso!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                        mostrarNuevoFormulario();
                    } else {
                        // Usuario no encontrado o contraseña incorrecta
                        JOptionPane.showMessageDialog(frame, "Nombre de usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    // Cerrar los recursos
                    statement.close();
                } catch (SQLException ex) {
                    // Manejar cualquier error de SQL
                    ex.printStackTrace();
                }
            }
        });

        JButton btnForgotPassword = new JButton("¿Olvidaste tu contraseña?");
        btnForgotPassword.setBounds(135, 166, 185, 23);
        frame.getContentPane().add(btnForgotPassword);

        // Agregamos un actionlistener al botón recuperar contraseña
        btnForgotPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirNuevoFormularioRecuperarContraseña();
            }
        });

        // Agrega un mensaje y un botón de registro para los usuarios que aún no tienen una cuenta
        JLabel lblNoAccount = new JLabel("¿No tienes una cuenta?");
        lblNoAccount.setBounds(135, 200, 185, 14);
        frame.getContentPane().add(lblNoAccount);

        JButton btnRegister = new JButton("Regístrate");
        btnRegister.setBounds(175, 225, 120, 23);
        frame.getContentPane().add(btnRegister);

        // Agregamos un ActionListener al botón de registro para abrir un nuevo formulario de registro
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirNuevoFormularioRegistro();
            }
        });
    }

    private void mostrarNuevoFormulario() {
        JFrame nuevoFormulario = new JFrame("Nuevo Formulario");
        nuevoFormulario.setSize(400, 200);
        nuevoFormulario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevoFormulario.setLocationRelativeTo(frame);
        nuevoFormulario.setLayout(null);

        JLabel userLabel = new JLabel("Usuario admin:");
        userLabel.setBounds(10, 20, 120, 25);
        nuevoFormulario.getContentPane().add(userLabel);

        // Hacer visible el nuevo formulario
        nuevoFormulario.setVisible(true);
    }

    private void abrirNuevoFormularioRegistro() {
        JFrame registroFrame = new JFrame("Registro");
        registroFrame.setSize(300, 250);
        registroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registroFrame.setLocationRelativeTo(frame);

        JPanel panel = new JPanel();
        registroFrame.add(panel);
        placeComponents(panel, registroFrame);
        registroFrame.setVisible(true); // Debes hacer visible el formulario después de agregar los componentes
    }

    private void abrirNuevoFormularioRecuperarContraseña() {
        JFrame forgotPasswordFrame = new JFrame("Recuperar contraseña");
        forgotPasswordFrame.setSize(300, 150);
        forgotPasswordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        forgotPasswordFrame.setLocationRelativeTo(frame);

        JPanel panel = new JPanel();
        forgotPasswordFrame.add(panel);
        placeComponentsRecuperarContraseña(panel, forgotPasswordFrame);

        forgotPasswordFrame.setVisible(true);
    }

    private void placeComponents(JPanel panel, JFrame registroFrame) {
        panel.setLayout(null);

        JLabel username = new JLabel("Nombre:");
        username.setBounds(10, 20, 80, 25);
        panel.add(username);

        JTextField userField = new JTextField(20);
        userField.setBounds(100, 20, 165, 25);
        panel.add(userField);

        JLabel userapellido = new JLabel("Apellidos");
        userapellido.setBounds(10, 50, 80, 25);
        panel.add(userapellido);

        JTextField userapellidoText = new JTextField(20);
        userapellidoText.setBounds(100, 50, 165, 25);
        panel.add(userapellidoText);

        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setBounds(10, 80, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 80, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(10, 110, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 110, 165, 25);
        panel.add(passwordText);

        JLabel emailLabel = new JLabel("Correo electrónico:");
        emailLabel.setBounds(10, 140, 120, 25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(140, 140, 165, 25);
        panel.add(emailText);

        JLabel addressLabel = new JLabel("Dirección:");
        addressLabel.setBounds(10, 170, 80, 25);
        panel.add(addressLabel);

        JTextField addressText = new JTextField(20);
        addressText.setBounds(100, 170, 205, 25);
        panel.add(addressText);

        JButton registerButton = new JButton("Registrar");
        registerButton.setBounds(100, 200, 95, 25);
        panel.add(registerButton);


        // Agregar ActionListener al botón de registro
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Verificar si los campos obligatorios están llenos
                if (userText.getText().isEmpty() || passwordText.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(registroFrame, "Por favor, complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    registrarUsuario(userText.getText(), new String(passwordText.getPassword()));
                    // Cerrar el formulario de registro después de registrar al usuario
                    registroFrame.dispose();
                }
            }
        });
    }

    private void placeComponentsRecuperarContraseña(JPanel panel, JFrame forgotPasswordFrame) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Ingrese su número:");
        userLabel.setBounds(10, 20, 120, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(140, 20, 135, 25);
        panel.add(userText);

        JButton sendButton = new JButton("Enviar");
        sendButton.setBounds(100, 60, 95, 25);
        panel.add(sendButton);

        // Agregar ActionListener al botón de envío
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obtener el número ingresado por el usuario
                String phoneNumber = userText.getText();

                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(forgotPasswordFrame, "Mensaje enviado exitosamente al número: " + phoneNumber, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    // Método para registrar al usuario en la base de datos
    private void registrarUsuario(String username, String password) {
        String url = "jdbc:mysql://localhost:7070/Pruebas";
        String user = "root";
        String dbPassword = "60797472";

        // Consulta SQL para insertar el usuario en la tabla correspondiente
        String insertQuery = "INSERT INTO registro (Nombre,Apellido,Email,Usuario, Contraseña,Direccion) VALUES (?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, dbPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            // Preparar la consulta SQL con los parámetros
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            // preparedStatement.setString(3, emailText.getText());
            // preparedStatement.setString(4, addressText.getText());

            // Ejecutar la consulta para insertar el usuario
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(frame, "¡Registro exitoso!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Error al registrar usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            // Manejar cualquier excepción que pueda ocurrir durante la inserción de datos
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error al registrar usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void connectToDatabase() {
        String url = "jdbc:mysql://localhost:7070/Pruebas";
        String user = "root";
        String password = "60797472";

        try {
            connection = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(frame, "Conexión exitosa con la base de datos");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Error al conectar con la base de datos " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
