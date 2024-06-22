package gt.com.sga.datos;

import gt.com.sga.domain.Usuario;
import java.util.List;


public interface UsuarioDAO {
    public List<Usuario> findAllPerson();
    public Usuario findUsuarioId(Usuario usuario);
    public void insertUsuario(Usuario usuario);
    public void updateUsuario(Usuario usuario);
    public void deleteUsuario(Usuario usuario);
    
    
}
