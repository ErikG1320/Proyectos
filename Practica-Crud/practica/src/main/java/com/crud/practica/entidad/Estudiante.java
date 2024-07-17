package com.crud.practica.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombrecompleto", nullable = false, length = 100)
    private String nombrecompleto;
    
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "telefono", nullable = false)
    private String telefono;
    
    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name="Grado", nullable = false)
    private String Grado;

    // Constructor vacío
    public Estudiante() {}

    // Constructor sin id
    public Estudiante(String nombrecompleto, String email, String telefono, int edad, String grado) {
        this.nombrecompleto = nombrecompleto;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
        this.Grado = grado;
    }

    // Constructor con id al final
    public Estudiante(Long id, String nombrecompleto, String email, String telefono, int edad, String grado) {
        this.id = id;
        this.nombrecompleto = nombrecompleto;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
        Grado = grado;
    }
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGrado() {
        return Grado;
    }

    public void setGrado(String grado) {
        this.Grado = grado;
    }

    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", nombrecompleto=" + nombrecompleto + ", email=" + email + ", telefono="
                + telefono + ", edad=" + edad + ", Grado=" + Grado + "]";
    }
}