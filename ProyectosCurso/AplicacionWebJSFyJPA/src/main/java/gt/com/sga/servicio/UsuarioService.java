package gt.com.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import gt.com.sga.domain.Usuario;

@Local
public interface UsuarioService {
      public List<Usuario> listarUsuarios();
    
    public Usuario encontrarUsuarioPorId(Usuario usuario);
    
    public void registrarUsuario(Usuario usuario);
    
    public void modificarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
    
}
