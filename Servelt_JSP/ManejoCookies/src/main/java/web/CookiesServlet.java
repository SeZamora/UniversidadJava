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
@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
            //suponemos que nos visita por primera vez
            boolean nuevoUsuario = true;
            //obtener arreglo cookies
            Cookie[] cookies = request.getCookies();
            //buscamos si ya existe una cookie creada con aterioridad
            //llamada visitanteRequrrente
            if (cookies != null){
                for (Cookie c: cookies){
                    if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")){
                        nuevoUsuario = false;
                        break;
                    }
                }
        }
            String mensaje = null;
            if(nuevoUsuario){
                Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
                response.addCookie(visitanteCookie);
                mensaje="Gracias por visitarnos por primra vez";
            }else{
                mensaje = "Gracias por visitarnos NUEVAMENTE";
            }
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.print("Mensaje:" + mensaje);
            out.close();
    }


}
