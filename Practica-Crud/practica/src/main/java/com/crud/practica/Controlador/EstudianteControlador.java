package com.crud.practica.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.crud.practica.Servicio.EstudianteServicio;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EstudianteControlador {
    @Autowired
    private EstudianteServicio servicio;
    @GetMapping({"/estudiantes ","/"})
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", servicio.getEstudiantes());
        return "estudiantes";
    }
}