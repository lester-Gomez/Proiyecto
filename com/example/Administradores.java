import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

// Método para obtener un usuario por su ID
public static void obtenerUsuarioPorId(int idUsuario) throws SQLException {
    String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, idUsuario);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                String nombreUsuario = rs.getString("nombre_usuario");
                String contrasena = rs.getString("contrasena");
                String rol = rs.getString("rol");
                int idAlumno = rs.getInt("id_alumno");
                int idCatedratico = rs.getInt("id_catedratico");
                // Aquí puedes hacer lo que necesites con los datos del usuario
            } else {
                System.out.println("Usuario no encontrado");
            }
        }
    }
}

