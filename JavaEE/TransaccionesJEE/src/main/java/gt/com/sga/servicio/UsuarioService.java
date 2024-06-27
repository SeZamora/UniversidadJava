package gt.com.sga.servicio;

import gt.com.sga.domain.Usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UsuarioService {

    public List<Usuario> listarUsuarios();

    public Usuario encontrarUsuarioId(Usuario usuario);

    public void registrarUsuario(Usuario usuario);

    public void modificarUsuario(Usuario usuario);

    public void elimiarUsuario(Usuario usuario);
}
