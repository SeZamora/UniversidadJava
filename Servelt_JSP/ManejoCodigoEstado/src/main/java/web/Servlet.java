package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    
        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException{
            //Simulado los valores correctos
            String usuarioOk = "Juan";
            String passwordOk = "123";
            
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
             PrintWriter out = response.getWriter();
            if (usuarioOk.equals(usuario) && passwordOk.equals(password)){
                out.print("<h1>");
                out.print("Datos Correctos");
                out.print("</h1>");
                
            }else{
                response.sendError(response.SC_UNAUTHORIZED, "Las credenciales son incorrectas");
                
            }
            out.close();
        }
    
    
}
