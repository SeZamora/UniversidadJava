package gt.com.web;

import gt.com.dao.AlumnoDao;
import gt.com.dao.ContactoDao;
import gt.com.dao.DomicilioDao;
import gt.com.domain.Alumno;
import gt.com.domain.Contacto;
import gt.com.domain.Domicilio;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AgregarAlumno")
public class AgregarAlumno extends HttpServlet {
     
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response){
           try {
               AlumnoDao alumnoDao = new AlumnoDao();
               DomicilioDao domicilioDao = new DomicilioDao();
               ContactoDao contactoDao = new ContactoDao();
               
               String nombre = request.getParameter("nombre");
               String apellido = request.getParameter("apellido");
               String calle = request.getParameter("calle");
               String noCalle = request.getParameter("noCalle");
               String pais = request.getParameter("pais");
               String email = request.getParameter("email");
               String telefono = request.getParameter("telefono");
               
               Contacto contacto = new Contacto();
               contacto.setEmail(email);
               contacto.setTelefono(telefono);
               contactoDao.insertar(contacto);
               
               Domicilio domicilio = new Domicilio();
              domicilio.setCalle(calle);
              domicilio.setNoCalle(noCalle);
              domicilio.setPais(pais);
              domicilioDao.insertar(domicilio);
              
              Alumno alumno = new Alumno();
              alumno.setNombre(nombre);
              alumno.setApellido(apellido);
              alumno.setDomicilio(domicilio);
              alumno.setContacto(contacto);
              alumnoDao.insertar(alumno);
              
               request.getRequestDispatcher("/WEB-INF/agregar.jsp").forward(request, response);
               
          } catch (Exception ex) {
              ex.printStackTrace(System.out);
          }
     }
}
