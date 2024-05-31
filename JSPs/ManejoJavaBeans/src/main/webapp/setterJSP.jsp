<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP que modifica un java bean</title>
    </head>
    <body>
        <h1>JSP setter</h1>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session"></jsp:useBean>
        Modificamos los atributos:
        <br/>
        <% 
            int baseV =5;
            int alturaV = 10;
        %>
        <jsp:setProperty name="rectangulo" property="base" value="<%= baseV %>" />
        <jsp:setProperty name="rectangulo" property="altura" value="<%= alturaV %>" />
        
        Nuevo valor base: <%= baseV %>
        <br/>
        Nuevo Valor altura <%= alturaV %>

        
    </body>
</html>
