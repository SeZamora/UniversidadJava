package gt.com.web;


import gt.com.domain.Persona;
import gt.com.servicio.ServicioPersonas;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response){
          try {
               ServicioPersonas servicioPersonas = new ServicioPersonas();
               List<Persona> personas = servicioPersonas.listarPersonas();
               
              request.setAttribute("personas", personas);
               
               request.getRequestDispatcher("/WEB-INF/listado.jsp").forward(request, response);
          } catch (ServletException ex) {
               ex.printStackTrace(System.out);
          } catch (IOException ex) {
               ex.printStackTrace(System.out);
          }
     }
}
