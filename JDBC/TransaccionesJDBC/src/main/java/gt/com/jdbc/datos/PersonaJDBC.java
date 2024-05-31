package gt.com.jdbc.datos;

import gt.com.jdbc.domain.Persona;

import java.sql.*;
import java.util.*;

public class PersonaJDBC {
    private Connection conexionTransacion;
    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idpersona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idpersona = ?";

    public PersonaJDBC(){

    }
    public PersonaJDBC(Connection conexion) {
        this.conexionTransacion = conexion;
    }

    public List<Persona> seleccionar() throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = this.conexionTransacion != null ? this.conexionTransacion : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                int idPersona = rs.getInt("idpersona");
                String nombre = rs.getNString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                persona = new Persona(idPersona, nombre, apellido, email, telefono);

                personas.add(persona);


            }
        }finally {

            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransacion == null){
                Conexion.close(conn);
            }
        }
        return personas;
    }

    public int insertar(Persona persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = this.conexionTransacion != null ? this.conexionTransacion : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3 , persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            registro = stmt.executeUpdate();

        }finally {
            Conexion.close(stmt);
            if (this.conexionTransacion == null){
                Conexion.close(conn);
            }

        }
        return registro;

    }

    public void actualizar(Persona persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = this.conexionTransacion != null ? this.conexionTransacion : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3 , persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());
            stmt.executeUpdate();
        }finally {
            Conexion.close(stmt);
            if (this.conexionTransacion == null) {
                Conexion.close(conn);
            }
        }
    }
    public void eliminar(Persona persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = this.conexionTransacion != null ? this.conexionTransacion : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            stmt.executeUpdate();
        }finally {
            Conexion.close(stmt);
            if (this.conexionTransacion == null){
                Conexion.close(conn);
            }

        }
    }
}
