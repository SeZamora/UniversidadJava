<%-- 
    Document   : index
    Created on : May 25, 2024, 1:41:22 PM
    Author     : SEBASTIAN ZAMORA
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType= "text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hola mundo JSPs</title>
    </head>
    <body>
        <h1>HolaMundo JSPs</h1>
        <ul>
            <li><% out.print("Hola mundo con Scriplets");   %> </li>
            <li> ${"Hola Mundo con Expresion Language(EL)"}</li>
            <li><%= "Hola Mundo con Expresiones" %></li>
            <li> <c:out value= "HolaMundo con JSTL" /></li>
        </ul>
    </body>
</html>
