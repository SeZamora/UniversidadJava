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
@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            int contador = 0;
            
            //Revisar existe contador visitas
            Cookie[] cookies = request.getCookies();
            if (cookies != null){
                for ( Cookie c: cookies){
                    if(c.getName().equals("contadorVisitas")){
                        contador = Integer.parseInt(c.getValue());
       
                    }
                }
            }
            
            //incrementar en contador en 1
            contador++;
            //Agragar la respuesta al navegador
            Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));
            //Solo se almacena la cookie 1h en el cliente (3600seg)
            c.setMaxAge(3600);
            response.addCookie(c);
            
            //mandamos el mensaje al navegador 
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print("Contador de visita cada cliente: "+ contador);
                    
            
        
    }

 

}
