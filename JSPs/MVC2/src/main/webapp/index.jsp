<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC 2</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo MVC2</h1>
        <br/>
        <div style="color : red">${mensaje}</div>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador">Controlador servlet SIN parametros</a>
        <br/><br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregarVariables">Controlador para agregar variables</a>
        <br/><br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">Controlador para listar variables</a>
    </body>
</html>