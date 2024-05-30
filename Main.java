public class Main{
public static void main(String[] args) {
    try {
        // Insertar un nuevo usuario
        insertarUsuario("usuario1", "contraseña1", "alumno", 1, 0);

        // Obtener un usuario por su ID
        obtenerUsuarioPorId(1);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    private static void obtenerUsuarioPorId(int i) {
    }

    private static void insertarUsuario(String usuario1, String contraseña1, String alumno, int i, int i1) {
    }
}