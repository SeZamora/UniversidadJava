<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
        <body>
            <h1>JSTL Core</h1>
            <!-- Manipulacion de variables -->
            <c:set var="nombre" value="Ernesto" />
            <!-- Desplegamos el valor de la variable-->
            Variable nombre: <c:out value="${nombre}"/>
            <br/>
            <br/>
            <!-- Variable con codigo HTML-->
            Variable con codigo HTML:
            <c:out value="<h4>Hola</h4>" escapeXml="false" />
            
            <br/><!-- comment -->
            <br/>
            <!-- Uso de if-->
            <c:set var="bandera" value="true" />
            <c:if test="${bandera}">
                La bandera es verdadera
            </c:if>
             <br/><!-- comment -->
            <br/>
            <!-- Uso de SWITCH-->
            <c:if test="${param.opcion != null}">
                <c:choose> 
                    <c:when test="${param.opcion == 1}" > 
                            <br/>
                            Opcion 1 Seleccionada
                    </c:when>
                     <c:when test="${param.opcion == 2}" > 
                            <br/>
                            Opcion 2 Seleccionada
                    </c:when>
                    <c:otherwise>
                        <br/>
                        Opcion no existe
                    </c:otherwise>
                </c:choose>
            </c:if>
                        
            <!-- Iterar un arreglo -->
            <% 
                String nombres[] = {"Claudia", "Pedro", "Paula"};
                request.setAttribute("nombres", nombres);
            %>
            
            <br/>
            Lista Nombres:
            <br/>
            <ul>
                <c:forEach var="persona" items="${nombres}">
                    <li>Nombre: ${persona}</li>
                </c:forEach>
                
            </ul>
            
                
        </body>
        
    
</html>
