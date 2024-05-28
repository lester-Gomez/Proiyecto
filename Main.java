public class Main {
    public static void main(String[]args){
        interface CursoDAO {
        }

        interface CatedraticoDAO {
        }

        interface InscripcionDAO {
        }

        class CursoDAOImpl implements CursoDAO {
        }

        class CatedraticoDAOImpl implements CatedraticoDAO {
        }

        class InscripcionDAOImpl implements InscripcionDAO {
        }

        AlumnoDAO alumnoDAO = new AlumnoDAO();
        CursoDAO cursoDAO = new CursoDAOImpl();
        CatedraticoDAO catedraticoDAO = new CatedraticoDAOImpl();
        InscripcionDAO inscripcionDAO = new InscripcionDAOImpl();

        Alumno alumno = new Alumno("Juan", "Perez", "juan.perez@gamil.com");
        alumnoDAO.registrarAlumno(alumno);

    }
}

    }
}

