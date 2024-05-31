/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author SEBASTIAN ZAMORA
 */
@WebServlet("/SesionesServlet")
public class SesionesServlet extends HttpServlet {

   
        
    

    // 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html; charset=UTF-8");
            HttpSession sesion=request.getSession();
            String titulo = null;
            
            //Pedir atributo contadorVisitas a la orden
            Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
            //si es null, primera vez que accedemos
            if(contadorVisitas==null){
                contadorVisitas=1;
                titulo = "Bienvenido por primera vez";
                
            }else{
                contadorVisitas++;
                titulo="Bienvenido Nuevamente";
                
            }
            //agregamos un nuevo valor de sesion
            sesion.setAttribute("contadorVisitas", contadorVisitas);
            //imprimimos
            PrintWriter out = response.getWriter();
            out.print(titulo);
            out.print("<br>");
            out.print("no. accesos al recurso: "+contadorVisitas);
            out.print("<br>");
            out.print("ID de sesion: "+ sesion.getId());
            out.close();
                    
              
    }

}
