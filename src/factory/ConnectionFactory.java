package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {

        String URL = "jdbc:postgresql://localhost:5432/db-insetos";
        String USER = "postgres";
        String PASSWORD = "ADMIN";

        return DriverManager.getConnection(URL, USER, PASSWORD);

    }
}
