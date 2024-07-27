package Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import Entity.Usuario;
 
public interface UsuarioRepository extends JpaRepository <Usuario , Integer> {
    Usuario findByUserName (String userName);
}