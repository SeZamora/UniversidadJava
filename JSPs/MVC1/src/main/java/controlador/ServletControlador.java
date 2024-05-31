package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
        
        //2. Crear Java Beans
        Rectangulo rec = new Rectangulo(3,6);
        
        //3.Agregamos un alcance  request al JavaBean
        request.setAttribute("mensaje","Saludos desde el Servlet");
        
        //4. Compartir el rectangulo en alcance session
        HttpSession session = request.getSession();
        session.setAttribute("rectangulo",rec);
        
        //5. redireccionamos a la vista seleccionada
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariables.jsp");
        rd.forward(request, response);
    }
    
    
}
