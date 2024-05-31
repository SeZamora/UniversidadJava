<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriptlets</title>
    </head>
    <body>
        <h1>Jsp con Scriptles!</h1>
        <br><!-- comment -->
        <%-- Scriplet para enviar infromacion al navegador --%>
        <%
            out.print("Saludos desde un scriplet");
         %>
         <%-- Scrplet para manipular los objetos --%>
         <%
            String nombreAplicacion = request.getContextPath();
            out.print("nombre de la aplicacion: "+ nombreAplicacion);
         %>
         <br><!-- comment -->
         <%-- NO ES BUENA PRACTICA pero se puede encontrar --%>
         <%-- Scrplet codigo condicional --%>
         <%
            if(session != null && session.isNew()){
            
         %>
         la sesion SI es nueva
         <%
             }else if(session != null){
            
         %>
         La sesion NO es nueva
         <% } %>
         <br><!-- comment -->
        <a href="index.html"> Volver </a>
    </body>
</html>
