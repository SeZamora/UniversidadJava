package gt.com.jdbc;

import java.sql.*;


public class Conexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,"root","root");
            Statement instruccion = conexion.createStatement();
            var sql ="SELECT idpersona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()){
                System.out.println("idPersona: " + resultado.getInt("idpersona") );
                System.out.println("nombre: "+ resultado.getString("nombre"));
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

    }
}
