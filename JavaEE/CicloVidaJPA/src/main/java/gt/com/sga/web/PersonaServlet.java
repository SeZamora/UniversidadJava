package gt.com.sga.web;

import gt.com.sga.domain.Persona;
import gt.com.sga.servicio.PersonaService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/personas")
public class PersonaServlet extends HttpServlet {
    @Inject
    PersonaService personaService ;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Persona> personas = personaService.listarPersonas();
        System.out.println("personas: "+personas);
        request.setAttribute("personas", personas);
        request.getRequestDispatcher("/listadoPersonas.jsp").forward(request, response);
    }
}
