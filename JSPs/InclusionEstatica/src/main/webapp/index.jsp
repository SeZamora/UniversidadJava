<%-- 
    Document   : index
    Created on : May 27, 2024, 12:21:30 PM
    Author     : SEBASTIAN ZAMORA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <br/>
        <ul>
            <li><%@include file="paginas/noticias1.html" %></li>
            <li><%@include file="paginas/noticias2.jsp" %></li>
        </ul>
    </body>
</html>
