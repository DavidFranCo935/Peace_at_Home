package data;

import utils.ConexionDB;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    
    // Método para validar las credenciales en el Login
    public boolean validarLogin(String correo, String contrasenaPlain) {
        // Tu tabla se llama 'Usuario' y el campo es 'correo' según tu script schema.sql
        String sql = "SELECT contrasena FROM Usuario WHERE correo = ?";
        
        try (Connection con = ConexionDB.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, correo);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Obtenemos la contraseña encriptada (hash) que está guardada en la BD
                    String contrasenaHash = rs.getString("contrasena");
                    
                    // Comparamos la clave que ingresa el usuario con el hash seguro de la BD
                    return BCrypt.checkpw(contrasenaPlain, contrasenaHash);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al validar el login en la base de datos: " + e.getMessage());
        }
        return false; // Retorna falso si las credenciales no coinciden o si hay un error
    }
}