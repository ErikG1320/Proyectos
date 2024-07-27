package Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import Entity.Usuario;
import Repository.UsuarioRepository;

@Service
public class UsuarioService  implements UserDetailsService{
    @Autowired
    private UsuarioRepository usuariorepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null) {
            throw new UsernameNotFoundException("Username cannot be null");
        }
        Usuario usuario = usuariorepository.findByUserName(username);
        throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }
}
