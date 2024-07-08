package gt.com.web;

import gt.com.dao.AlumnoDao;
import gt.com.domain.Alumno;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletListar")
public class ServletListar extends HttpServlet {

     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) {
          String accion = request.getParameter("accion");
          if (accion != null) {
               switch (accion) {
                    case "agregar": {
                         try {
                              request.getRequestDispatcher("/WEB-INF/agregar.jsp").forward(request, response);
                         } catch (ServletException ex) {
                              ex.printStackTrace(System.out);
                         } catch (IOException ex) {
                              ex.printStackTrace(System.out);
                         }

                    }
                    break;

                    default:
                         this.Listar(request, response);

               }
          } else {
               this.Listar(request, response);
          }
     }

     private void Listar(HttpServletRequest request, HttpServletResponse response) {
          try {
               AlumnoDao alumnoDao = new AlumnoDao();
               List<Alumno> alumnos = alumnoDao.listar();

               request.setAttribute("alumnos", alumnos);

               request.getRequestDispatcher("/WEB-INF/listado.jsp").forward(request, response);
          } catch (ServletException ex) {
               ex.printStackTrace(System.out);
          } catch (IOException ex) {
               ex.printStackTrace(System.out);
          }
     }
}
