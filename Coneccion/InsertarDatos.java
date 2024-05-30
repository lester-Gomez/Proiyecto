package Coneccion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDatos {
    private Coneccion conexion;

    public InsertarDatos() {
        conexion = new Coneccion();
    }

    public void insertarAlumno(String nombre, String apellido, String fechaNacimiento, String direccion, String telefono, String email) {
        insertarDatos("alumno", "nombre, apellido, fecha_nacimiento, direccion, telefono, email", "?, ?, ?, ?, ?, ?", nombre, apellido, fechaNacimiento, direccion, telefono, email);
    }

    public void insertarCurso(String nombreCurso, String descripcion, int creditos) {
        insertarDatos("cursos", "nombre_curso, descripcion, creditos", "?, ?, ?", nombreCurso, descripcion, creditos);
    }

    public void insertarCatedratico(String nombre, String apellido, String especialidad, String email, String telefono, String fechaContratacion) {
        insertarDatos("catedraticos", "nombre, apellido, especialidad, email, telefono, fecha_contratacion", "?, ?, ?, ?, ?, ?", nombre, apellido, especialidad, email, telefono, fechaContratacion);
    }

    public void insertarAsignacionCursoCatedratico(int idCurso, int idCatedratico, String semestre, int ano) {
        insertarDatos("asignacion_cursos_catedraticos", "id_curso, id_catedratico, semestre, ano", "?, ?, ?, ?", idCurso, idCatedratico, semestre, ano);
    }

    public void insertarInscripcion(int idAlumno, int idAsignacion) {
        insertarDatos("inscripciones", "id_alumno, id_asignacion", "?, ?", idAlumno, idAsignacion);
    }

    public void insertarCalificacion(int idInscripcion, double calificacion, String fechaCalificacion) {
        insertarDatos("calificaciones", "id_inscripcion, calificacion, fecha_calificacion", "?, ?, ?", idInscripcion, calificacion, fechaCalificacion);
    }

    private void insertarDatos(String tabla, String columnas, String placeholders, Object... valores) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = conexion.conector();
            if (conn != null) {
                String sql = "INSERT INTO " + tabla + " (" + columnas + ") VALUES (" + placeholders + ")";
                statement = conn.prepareStatement(sql);

                for (int i = 0; i < valores.length; i++) {
                    statement.setObject(i + 1, valores[i]);
                }

                int filasInsertadas = statement.executeUpdate();
                if (filasInsertadas > 0) {
                    JOptionPane.showMessageDialog(null, "Datos insertados exitosamente en " + tabla + "!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al insertar los datos en " + tabla + ": " + ex.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
