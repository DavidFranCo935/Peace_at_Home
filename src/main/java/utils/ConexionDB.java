package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    // URL de conexión para SQL Server local apuntando a tu base de datos PeaceAtHome
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=PeaceAtHome;trustServerCertificate=true;";
    private static final String USER = "tu_usuario_sql"; // Por ejemplo: sa
    private static final String PASSWORD = "tu_contrasena_sql";

    public static Connection getConexion() throws SQLException {
        try {
            // Cargar el driver de SQL Server que agregamos en el pom.xml
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver de SQL Server no encontrado en el proyecto", e);
        }
    }
}