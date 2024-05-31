package gt.com.jdbc;

import gt.com.jdbc.datos.Conexion;
import gt.com.jdbc.datos.PersonaJDBC;
import gt.com.jdbc.domain.Persona;

import java.sql.*;
import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {

        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            PersonaJDBC personaJDBC= new PersonaJDBC(conexion);

            Persona personaUpdate = new Persona(2, "Karla", "Ivonne", "cambio2@gmail.com", "67895432");
            personaJDBC.actualizar(personaUpdate);

            Persona personaNew = new Persona();
            personaNew.setNombre("Gerardo");
            personaNew.setApellido("Gomezzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            personaNew.setEmail("new@gmail.com");
            personaNew.setTelefono("56784321");
            personaJDBC.insertar(personaNew);
            conexion.commit();



        } catch (SQLException e) {
            e.printStackTrace(System.out);
            System.out.println("Se hizo rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }



    }
}
