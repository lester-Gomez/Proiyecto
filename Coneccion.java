import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Coneccion {


        private static final String URL = "jdbc:mysql://localhost:3306/Universidad";
        private static final String USER = "root";
        private static final String PASSWORD = "123456";

        static {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }

        public static void main(String[] args) {
            try (Connection connection = Coneccion.getConnection()) {
                if (connection != null) {
                    System.out.println("Conexión exitosa a la base de datos");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


