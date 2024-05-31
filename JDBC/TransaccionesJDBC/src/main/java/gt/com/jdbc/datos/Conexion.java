package gt.com.jdbc.datos;

import java.sql.*;


public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
    private static final String JDBC_user = "root";
    private static final String JDBC_pass = "root";

    public static Connection getConnection() throws SQLException{
        Connection conexion = DriverManager.getConnection(JDBC_URL,JDBC_user,JDBC_pass);
        return conexion;
    }

    public static void close(ResultSet rs) throws SQLException{
        rs.close();

    }

    public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }

    public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }

    public static void close(Connection conexion) throws SQLException{
        conexion.close();
    }

}
