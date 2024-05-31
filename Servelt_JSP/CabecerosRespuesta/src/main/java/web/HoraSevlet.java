/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/HoraServlet")
public class HoraSevlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("refresh", "1");
            
            Date fecha = new Date();
            SimpleDateFormat formateador = new SimpleDateFormat(" 'Hora actualizada',HH::mm::ss ");
            String horaConFormato = formateador.format(fecha);

            PrintWriter out = response.getWriter();
            out.print(horaConFormato);
            
            out.close();
       
    }



}
