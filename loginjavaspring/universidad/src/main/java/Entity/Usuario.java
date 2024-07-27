package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int user_id;
    private String user_name;
    private String pass;
    private String apellidos;
    private int edad;
    private String email;
    private boolean vigencia;
    private int tipo_usuario;

    //Constructor vacio
    public Usuario() {
    }

    // Constructor con id
    public Usuario(int user_id, String user_name, String pass, String apellidos, int edad, String email,
            boolean vigencia,
            int tipo_usuario) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.pass = pass;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.vigencia = vigencia;
        this.tipo_usuario = tipo_usuario;
    }

    // Constructor sin id

    public Usuario(String user_name, String pass, String apellidos, int edad, String email, boolean vigencia,
            int tipo_usuario) {
        this.user_name = user_name;
        this.pass = pass;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.vigencia = vigencia;
        this.tipo_usuario = tipo_usuario;
    }

    // Getters y Setters

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVigencia() {
        return vigencia;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    @Override
    public String toString() {
        return "Usuario [user_id=" + user_id + ", user_name=" + user_name + ", pass=" + pass + ", apellidos="
                + apellidos
                + ", edad=" + edad + ", email=" + email + ", vigencia=" + vigencia + ", tipo_usuario=" + tipo_usuario
                + "]";
    }
}
