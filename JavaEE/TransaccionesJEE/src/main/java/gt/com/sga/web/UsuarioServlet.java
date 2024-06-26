package gt.com.sga.web;

import gt.com.sga.domain.Usuario;
import gt.com.sga.servicio.UsuarioService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
    @Inject
    UsuarioService usuarioService ;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        System.out.println("usuarios: "+usuarios);
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/listadoUsuarios.jsp").forward(request, response);
    }
}
