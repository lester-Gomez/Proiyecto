package Coneccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Coneccion {
    private static final String URL = "jdbc:mysql://localhost/Universidad";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public Connection conector() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return conn;
    }
}

