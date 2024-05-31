package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        //1. Procesar parametros
        String accion = request.getParameter("accion");
        
        //2. Crear Java Beans
        Rectangulo recRequest = new Rectangulo(1,2);
        Rectangulo recSession = new Rectangulo(3,4);
        Rectangulo recAplicacion = new Rectangulo(5,6);
        
        //3.Agregamos  el alcance al JavaBean
        
        //revisar la accion proporcionada
        if("agregarVariables".equals(accion)){
            //alcance request
            request.setAttribute("recRequest", recRequest);
            //alcance session
             HttpSession session = request.getSession();
             session.setAttribute("recSession",recSession);
             
             //alcance Aplicacion
             ServletContext application = this.getServletContext();
             application.setAttribute("recAplicacion", recAplicacion);
             
             //agregamos un mensaje
             request.setAttribute("mensaje","Las variables fueron agregadas");
             
             //4.Redireccionamos al jsp Index
             request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if("listarVariables".equals(accion)){
            //4.Redireccion al jsp que despliega las variables
            request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
        }else{
            //4.Redireccionamos a la pagina de inicio
            request.setAttribute("mensaje", "Accion no proporcionada");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
            //Esto no propaga informacion solo redirige
            
            //response.sendRedirect("index.jsp");
        }
      
        
        //5. redireccionamos a la vista seleccionada
        
    }
    
    
}
