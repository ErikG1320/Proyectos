package Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.AuthRequest;

@RestController
public class UsuarioController {

    @PostMapping("/api/login")
    public ResponseEntity<String> login(AuthRequest request){
        // Aquí iría la lógica de autenticación
        return ResponseEntity.ok("Token de acceso generado correctamente");
    }
}
