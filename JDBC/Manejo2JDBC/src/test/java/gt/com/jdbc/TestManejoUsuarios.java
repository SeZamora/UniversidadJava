package gt.com.jdbc;

import gt.com.jdbc.datos.UsuarioDAO;
import gt.com.jdbc.domain.Usuario;

import java.util.ArrayList;
import java.util.List;

public class TestManejoUsuarios {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        //insertar objeto
        Usuario usuarioInsert = new Usuario("usuario3", "contr3");
        usuarioDAO.insertar(usuarioInsert);

        //update

        Usuario usuarioUpdate = new Usuario(1,"nuevouser", "nuevacontra");
        usuarioDAO.actualizar(usuarioUpdate);

        //elimnar
        Usuario usuarioDelete = new Usuario(2);
        usuarioDAO.eliminar(usuarioDelete);

        //select
        List<Usuario> usuarios = new ArrayList<>();

        usuarios = usuarioDAO.seleccionar();

        usuarios.forEach(user -> {
            System.out.println(user);
        });


    }

}
