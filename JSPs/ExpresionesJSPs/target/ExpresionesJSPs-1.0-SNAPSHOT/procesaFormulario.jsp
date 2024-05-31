<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesa Formulario</title>
    </head>
    <body>
        <h1>Resultado de procesar el fomrulario</h1>
        Usuario: <%=  request.getParameter("usuario") %>
        <br>
        Password: <%= request.getParameter("password") %>
        <br><!-- comment -->
        <a href="index.html" >Regresar al index</a>
    </body>
</html>
