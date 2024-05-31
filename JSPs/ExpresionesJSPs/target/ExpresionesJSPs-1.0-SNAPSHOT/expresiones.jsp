<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Expresiones</title>
    </head>
    <body>
        <h1>JSP con Expresiones</h1>
        Concatenacion: <%= "Saludos " + " JSP" %>
        <br><!-- comment -->
        Operacion matematica: <%= 2 * 3  / 2 %>
        <br><!-- comment -->
        Session id: <%= session.getId() %>
        <br><!-- comment -->
        <a href="index.html" >Regresar al index</a>
    </body>
</html>
