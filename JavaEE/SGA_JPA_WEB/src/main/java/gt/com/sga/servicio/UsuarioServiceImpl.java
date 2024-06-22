package gt.com.sga.servicio;

import gt.com.sga.domain.Usuario;
import gt.com.sga.datos.UsuarioDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UsuarioServiceImpl implements UsuarioServiceRemote, UsuarioService {
    
    @Inject
    private UsuarioDAO usuarioDao;
    
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.findAllPerson();
    }

    @Override
    public Usuario encontrarUsuarioId(Usuario usuario) {
        return usuarioDao.findUsuarioId(usuario);
    }


    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDao.insertUsuario(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
      usuarioDao.updateUsuario(usuario);
    }   

    @Override
    public void elimiarUsuario(Usuario usuario) {
        usuarioDao.deleteUsuario(usuario);
    }
    
}
