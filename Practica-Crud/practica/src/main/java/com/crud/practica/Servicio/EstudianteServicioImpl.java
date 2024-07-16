package com.crud.practica.Servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.practica.Repositorio.EstudianteRepositorio;
import com.crud.practica.entidad.Estudiante;

@Service

public class EstudianteServicioImpl implements EstudianteServicio{
    @Autowired 
    private EstudianteRepositorio Repositorio;
    @Override
    public List<Estudiante> getEstudiantes() {
        return Repositorio.findAll();
    }
}
