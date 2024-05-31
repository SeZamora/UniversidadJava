<%@page  errorPage="/WEB-INF/ManejoErrores.jsp" %>
<%@page import="utilerias.Conversiones, java.util.Date" %>
<%@page  contentType="application/vad.ms-excel" %>
<%
    String nombreArchivo = "resporte.xls";
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Resporte de excel</title>
    </head>
    <body>
        <h1>Resporte excel</h1>
        <br>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripcion</th>
                <th>Fecha</th>            
            </tr>
            <tr>
                <td>1. Fundamentos Java</td>
                <td>Aprendemos sitaxis Java</td>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
            <tr>
                <td>2. Programacion con Java</td>
                <td>Conceptos Java</td>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
            
        </table>
    </body>
</html>
