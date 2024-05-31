/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author SEBASTIAN ZAMORA
 */
@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");

        //creamos o recuperamos http sesion
        HttpSession sesion = request.getSession();
        //recuperar la lista de articulos agregados previamente si existe
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");
        

        //verificamos si la lista articulos existe
        if (articulos == null){
            //inicializar la lista articulos
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos",articulos);
            
        }
        
         //parametro el nuevo articulo
        String articuloNuevo = request.getParameter("articulo");
        
        //revisamos y agregamos el articulo nuevo
        // trim es para quitar los espacion en blanco derecha y izquierda
        if(articuloNuevo != null && !articuloNuevo.trim().equals("")){
            articulos.add(articuloNuevo);
        }
        
        try ( //imprimir lista articulos
               PrintWriter out = response.getWriter()) {
            out.print("<h1>Lista de articlos</h1>");
            out.print("<br>");
            //imprimos la lista
            for (String articulo: articulos){
                out.print("<li>" + articulo +"</li>");
            }
            
            out.print("<br>");
            out.print("<a href='/EjemploCarritoCompras'>Regresar al inicio </a> ");
        }
        
    }


}
