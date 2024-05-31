<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jsp GETTER</title>
    </head>
    <body>
        <h1>JSP que lee JavaBean</h1>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session"/>
        <br/>
        Valor Base: <jsp:getProperty name="rectangulo" property="base"/>
        <br/>
        Valor Altura <jsp:getProperty name="rectangulo" property="altura"/>
        <br/>
        Valor Area <jsp:getProperty name="rectangulo" property="area"/>
        <br/>
        <a href="index.jsp">regresar</a>
        
    </body>
</html>
