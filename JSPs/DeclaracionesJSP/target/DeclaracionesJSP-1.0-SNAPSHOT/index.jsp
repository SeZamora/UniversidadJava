<%-- Agregamos una declaracion de JSP  --%>
<%! 
 //Declarar una variable con su metodo get
private String usuario = "Arlberto";
    
public String getUsuario(){
    return this.usuario;
}

//Declaramos el contador visitas
private int contadorVisitas = 1;
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de declariones con JSP</title>
    </head>
    <body>
        <h1>Declaraciones con JSP</h1>  
        Valor de usuario por medio del atributo: <%= this.usuario %>
        <br><!-- comment -->
        Valor usuario por medio del metodo: <%= this.getUsuario() %>
        <br><!-- comment -->
        Contador de visitas: <%= this.contadorVisitas++ %>
        
    </body>
</html>
