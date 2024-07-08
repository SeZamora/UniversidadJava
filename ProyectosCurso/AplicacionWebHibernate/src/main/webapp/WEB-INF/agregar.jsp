<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Alumno</title>
    </head>
    <body>
        <h1>Agregar Alumno</h1>

        <form name="agregarAlumno" action="/AplicacionWebHibernate/AgregarAlumno">
            <label for="nombre">Nombre</label>
            <input type="text" name="nombre" required>
            <br/>
             <label for="apellido">Apelldio</label>
            <input type="text" name="apellido" required>
            <br/>
            <h4>Datos Domicilio</h4>
             <label for="calle">Calle</label>
            <input type="text" name="calle" required>
            <br/>
            <label for="noCalle">No. Calle</label>
            <input type="text" name="noCalle" required>
            <br/>
            <label for="pais">Pais</label>
            <input type="text" name="pais" required>
            <br/>
            <h4>Datos de Contacto</h4>
            <label for="email">Email</label>
            <input type="text" name="email" required>
            <br/>
            <label for="telefono">Telefono</label>
            <input type="text" name="telefono" required>
            <br/>
            
            <button class="btn" type="submit">Enviar</button>
            
        </form>
        <br/>
        <a href="/AplicacionWebHibernate/ServletListar">Regresar</a>
        
        
    </body>
</html>
