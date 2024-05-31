<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance Variables</title>
    </head>
    <body>
        <h1>Alcance Variables!</h1>
        <br/>
        Variable request:
        Base:${recRequest.base}
        Altura: ${recRequest.altura}
        Area: ${recRequest.area}
        
        <br/><br/>
        
        Variable session
        Base:${recSession.base}
        Altura: ${recSession.altura}
        Area: ${recSession.area}
        <br/><br/>
        
        Variable aplication
        Base:${recAplicacion.base}
        Altura: ${recAplicacion.altura}
        Area: ${recAplicacion.area}
        
        <a href="${pageContext.request.contextPath}/index.jsp">Regresar</a>
    </body>
</html>
