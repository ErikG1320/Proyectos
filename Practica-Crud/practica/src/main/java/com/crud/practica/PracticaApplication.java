package com.crud.practica;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
// import com.crud.practica.Repositorio.EstudianteRepositorio;
// import com.crud.practica.entidad.Estudiante;
@SpringBootApplication
public class PracticaApplication implements CommandLineRunner{

	public static void main(String[] args){
		SpringApplication.run(PracticaApplication.class, args);
	}
	@Autowired
	// private EstudianteRepositorio repo;
	@Override
	public void run(String... args) throws Exception {
		// Estudiante estudiante1 = new Estudiante("Juan Perez", "juan@example.com", "99999999", 18, "10");
		// Estudiante estudiante2 = new Estudiante("Maria Garcia", "maria@example.com", "88888888", 20, "12");
		// repo.save(estudiante1);
		// repo.save(estudiante2);
		throw new UnsupportedOperationException("Unimplemented method 'run'");
	}
}
